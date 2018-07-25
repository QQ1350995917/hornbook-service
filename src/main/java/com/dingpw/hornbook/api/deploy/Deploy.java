package com.dingpw.hornbook.api.deploy;

import com.dingpw.hornbook.ApplicationConfigure;
import com.dingpw.hornbook.utils.ShellUtil;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-25 14:15.
 */
//@Api(value = "service", description = "服务")
@RestController
@RequestMapping("/service")
public class Deploy {

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
