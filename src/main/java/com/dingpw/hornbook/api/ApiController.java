package com.dingpw.hornbook.api;

import com.alibaba.fastjson.JSONObject;
import com.dingpw.hornbook.exception.BaseException;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "检查模板操作", description = "检查模板操作")
@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
    public <T extends ApiController> void outputExceptionWithLog(int code, String message, Class<T> clazz, Exception e, Object... input) {
        if (e instanceof BaseException) {
            // 如果是baseException，是手动抛出，不需要告警，只打印info日志
            LOGGER.info(String.format("服务异常，类名：%s，请求入参：%s，", clazz.getName(), JSONObject.toJSONString(input)), e);
        } else {
            LOGGER.error(String.format("服务异常，类名：%s，请求入参：%s，", clazz.getName(), JSONObject.toJSONString(input)), e);
        }
    }


    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public void application() {

    }
}
