package com.dingpw.hornbook.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "检查模板操作", description = "检查模板操作")
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public void application() {

    }
}
