package com.dingpw.hornbook.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingpw.hornbook.ApplicationProperties;
import com.dingpw.hornbook.exception.BaseException;
import com.dingpw.hornbook.utils.GzipUtil;
import com.dingpw.hornbook.utils.StringUtil;
import io.swagger.annotations.Api;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "检查模板操作", description = "检查模板操作")
@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    public static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal();
    public static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal();

    protected String local = "en";

    public String getLocal() {
        return local == null ? "en" : local;
    }

    public String getPlatform() {
        return "Android";
    }

    public static void setRequestLocal(HttpServletRequest httpServletRequest) {
        requestLocal.set(httpServletRequest);
    }

    public static void setResponseLocal(HttpServletResponse httpServletResponse) {
        responseLocal.set(httpServletResponse);
    }

    public static HttpServletRequest getRequest() {
        return requestLocal.get();
    }

    public static HttpServletResponse getResponse() {
        return responseLocal.get();
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        setRequestLocal(request);
        setResponseLocal(response);
    }

    public <T extends ApiController> void outputExceptionToLog(Class<T> clazz, Exception e,
        Object... input) {
        if (e instanceof BaseException) {
            // 如果是baseException，是手动抛出，不需要告警，只打印info日志
            LOGGER.info(String
                .format("IntervalServerError:className:%s，requestParams:%s，", clazz.getName(),
                    JSONObject.toJSONString(input)), e);
        } else {
            LOGGER.error(String
                .format("IntervalServerError:className:%s，requestParams:%s，", clazz.getName(),
                    JSONObject.toJSONString(input)), e);
        }
    }

    public void outputException(int code, String message) {
        Meta meta = new Meta(code, message);
        Output<Object> objectOutput = new Output<>(meta, null);
        this.finalOutput(JSON.toJSONString(objectOutput));
    }

    public void outputException(int code) {
        String message = ApplicationProperties.apiBundles.get(getLocal()).getString(code + "");
        Meta meta = new Meta(code, message);
        Output<Object> objectOutput = new Output<>(meta, null);
        this.finalOutput(JSON.toJSONString(objectOutput));
    }

    public <T> void outputData(Meta meta, T t) {
        Output<Object> objectOutput = new Output<>(meta, t);
        this.finalOutput(JSON.toJSONString(objectOutput));
    }

    public <T> void outputData(Meta meta) {
        Output<Object> objectOutput = new Output<>(meta, null);
        this.finalOutput(JSON.toJSONString(objectOutput));
    }

    public <T> void outputData(T t) {
        this.outputData(new Meta(), t);
    }

    private void finalOutput(String data) {
        String clientEncoding = getRequest().getHeader("Accept-Encoding");
        boolean canGzip = false;
        if (clientEncoding != null && clientEncoding.indexOf("gzip") > -1
            && StringUtil.null2Str(data).length() >= 200) {
            canGzip = true;
            getResponse().setHeader("Content-Encoding", "gzip");
        }
        getResponse().setHeader("Content-Type", "application/json");
        getResponse().setCharacterEncoding("UTF-8");
        try {
            if (canGzip) {
                byte[] e = this.compressData(data);
                ServletOutputStream out = getResponse().getOutputStream();
                if (e != null) {
                    out.write(e);
                }
                out.flush();
                out.close();
            } else {
                getResponse().getWriter().append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] compressData(String data) {
        byte[] bytes = null;

        try {
            bytes = GzipUtil.compress(data.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
    }
}
