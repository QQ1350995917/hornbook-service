package com.dingpw.hornbook.api.user.feedback;

import com.dingpw.hornbook.api.user.UserController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 21:26.
 */
@Api(value = "/api/user/feedback", description = "feedback")
@RestController
@RequestMapping("/api/user/feedback")
public class FeedbackController extends UserController {

}
