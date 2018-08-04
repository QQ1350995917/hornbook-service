package com.dingpw.hornbook.api.user;

import com.dingpw.hornbook.api.ApiController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 18:11.
 */
@Api(value = "/api/user", description = "user interface")
@RestController
@RequestMapping("/user")
public class UserController extends ApiController {
    protected Long getUserId(){
        return 0L;
    }
}
