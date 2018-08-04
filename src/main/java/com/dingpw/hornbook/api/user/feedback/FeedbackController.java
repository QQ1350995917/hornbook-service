package com.dingpw.hornbook.api.user.feedback;

import com.dingpw.hornbook.api.ListOutput;
import com.dingpw.hornbook.api.PagingInput;
import com.dingpw.hornbook.api.PagingOutput;
import com.dingpw.hornbook.api.user.UserController;
import com.dingpw.hornbook.common.ObjectListEntity;
import com.dingpw.hornbook.feedback.FeedbackEntity;
import com.dingpw.hornbook.feedback.IFeedbackService;
import io.swagger.annotations.Api;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 21:26.
 */
@Api(value = "/api/user/feedback", description = "feedback")
@RestController(value = "userFeedback")
@RequestMapping("/api/user/feedback")
public class FeedbackController extends UserController {

    @Autowired
    private IFeedbackService feedbackService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(FeedbackListInput input) {
        try {
            PagingInput pagingInput = new PagingInput();
            BeanUtils.copyProperties(input, pagingInput);
            ObjectListEntity<FeedbackEntity> objectListEntity = feedbackService
                .list(input.getUserId(), null, input.getIndex(), input.getSize());
            List<FeedbackAddOutput> listOutput = new LinkedList<>();
            for (FeedbackEntity feedbackEntity : objectListEntity.getElements()) {
                FeedbackAddOutput output = new FeedbackAddOutput();
                BeanUtils.copyProperties(feedbackEntity, output);
                listOutput.add(output);
            }
            PagingOutput pagingOutput = new PagingOutput();
            BeanUtils.copyProperties(objectListEntity, pagingOutput);
            ListOutput<FeedbackAddOutput> feedbackOutputListOutput = new ListOutput<>();
            feedbackOutputListOutput.setPaging(pagingOutput);
            feedbackOutputListOutput.setList(listOutput);
            super.outputData(feedbackOutputListOutput);
        } catch (Exception e) {
            super.outputException(500);
            super.outputExceptionToLog(this.getClass(), e, input);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public void add(FeedbackAddInput input) {
        try {
            FeedbackEntity feedbackEntity = new FeedbackEntity();
            BeanUtils.copyProperties(input, feedbackEntity);
            FeedbackEntity addFeedbackEntity = feedbackService.add(feedbackEntity);
            FeedbackAddOutput feedbackOutput = new FeedbackAddOutput();
            BeanUtils.copyProperties(addFeedbackEntity, feedbackOutput);
            super.outputData(feedbackOutput);
        } catch (Exception e) {
            super.outputException(500);
            super.outputExceptionToLog(this.getClass(), e, input);
        }
    }
}
