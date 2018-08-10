package com.dingpw.hornbook.api.user.version;

import com.dingpw.hornbook.api.Meta;
import com.dingpw.hornbook.api.user.UserController;
import com.dingpw.hornbook.business.version.IVersionService;
import com.dingpw.hornbook.dao.version.VersionEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 08:32.
 */
@Api(value = "/api/user/version", description = "version")
@RestController(value = "userVersion")
@RequestMapping("/api/user/version")
public class VersionController extends UserController {

    @Autowired
    private IVersionService versionService;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    private void check(@RequestParam(required = true) Integer code) {
        try {
            VersionEntity versionEntity = versionService
                .checkNew(code, super.getPlatform());
            if (versionEntity == null) {
                super.outputData(new Meta(304, "已经是最新版本啦"));
            } else {
                super.outputData(versionEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
