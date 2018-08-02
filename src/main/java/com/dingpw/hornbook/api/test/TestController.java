package com.dingpw.hornbook.api.test;

import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.api.ApiController;
import com.dingpw.hornbook.api.Meta;
import com.dingpw.hornbook.api.Output;
import com.dingpw.hornbook.api.font.FontController;
import com.dingpw.hornbook.utils.ShellUtil;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-01 19:04.
 */
@Api(value = "检查模板操作", description = "检查模板操作")
@RestController
@RequestMapping("/api/test")
public class TestController extends ApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FontController.class);
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Output<String> api(@RequestParam(value = "params", required = false) String input) {
        super.outputExceptionToLog(this.getClass(),new Exception("test log"),input);
        Meta meta = new Meta();
        if (input == null) {
            meta.setMessage("you can request with \"params=hello-word\"");
        }
        return new Output<>(meta, input);
    }

    @RequestMapping(value = "/ping/get", method = RequestMethod.GET)
    public Output<TestInput> get(TestInput input) {
        super.outputExceptionToLog(this.getClass(),new Exception("test log"),input);
        Meta meta = new Meta();
        if (input == null) {
            meta.setMessage(
                "you can request with \"strings=1&strings=2&anInt=4&aLong=1&string=g_222\"");
        }
        return new Output<>(meta, input);
    }

    @RequestMapping(value = "/ping/post", method = RequestMethod.POST)
    public Output<TestInput> post(@RequestParam TestInput input) {
        super.outputExceptionToLog(this.getClass(),new Exception("test log"),input);
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
