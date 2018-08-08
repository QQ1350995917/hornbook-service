package com.dingpw.hornbook.api.officer.version;

import com.dingpw.hornbook.api.officer.OfficerController;
import com.dingpw.hornbook.version.IVersionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 08:32.
 */
@Api(value = "/api/officer/version", description = "version")
@RestController(value = "officerVersion")
@RequestMapping("/api/officer/version")
public class VersionController extends OfficerController {

    @Autowired
    private IVersionService versionService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create() {

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update() {

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list() {

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void delete() {

    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public void find() {
    }
}
