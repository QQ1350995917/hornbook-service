package com.dingpw.hornbook.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.ApplicationProperties;
import com.dingpw.hornbook.api.font.FontOutput;
import com.dingpw.hornbook.exception.BaseException;
import com.dingpw.hornbook.utils.GzipUtil;
import com.dingpw.hornbook.utils.ShellUtil;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    public <T extends ApiController> void outputExceptionToLog(int code, String message,
        Class<T> clazz, Exception e, Object... input) {
        if (e instanceof BaseException) {
            // 如果是baseException，是手动抛出，不需要告警，只打印info日志
            LOGGER.info(String
                .format("服务异常，类名：%s，请求入参：%s，", clazz.getName(), JSONObject.toJSONString(input)), e);
        } else {
            LOGGER.error(String
                .format("服务异常，类名：%s，请求入参：%s，", clazz.getName(), JSONObject.toJSONString(input)), e);
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

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Output<String> api(@RequestParam(value = "params", required = false) String input) {
        Meta meta = new Meta();
        if (input == null) {
            meta.setMessage("you can request with \"params=hello-word\"");
        }
        return new Output<>(meta, input);
    }

    @RequestMapping(value = "/ping/get", method = RequestMethod.GET)
    public Output<ApiInput> get(ApiInput input) {
        Meta meta = new Meta();
        if (input == null) {
            meta.setMessage(
                "you can request with \"strings=1&strings=2&anInt=4&aLong=1&string=g_222\"");
        }
        return new Output<>(meta, input);
    }

    @RequestMapping(value = "/ping/post", method = RequestMethod.POST)
    public Output<ApiInput> post(@RequestParam ApiInput input) {
        Meta meta = new Meta();
        if (input == null) {
            meta.setMessage(
                "you can request with \"strings=1&strings=2&anInt=4&aLong=1&string=g_222\"");
        }
        return new Output<>(meta, input);
    }

    @RequestMapping(value = "/redeploy", method = RequestMethod.POST)
    private void reploy(HttpServletRequest request) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ShellUtil.execute(ApplicationConfigure.getAutoDeployShell());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
