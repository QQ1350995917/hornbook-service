package com.dingpw.hornbook.api.officer.feedback;

import com.dingpw.hornbook.api.ListOutput;
import com.dingpw.hornbook.api.PagingInput;
import com.dingpw.hornbook.api.PagingOutput;
import com.dingpw.hornbook.api.officer.OfficerController;
import com.dingpw.hornbook.api.user.feedback.*;
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
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 23:04.
 */
@Api(value = "/api/officer/feedback", description = "feedback")
@RestController(value = "officerFeedback")
@RequestMapping("/api/officer/feedback")
public class FeedbackController extends OfficerController {

    @Autowired
    private IFeedbackService feedbackService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(FeedbackListInput input) {
        try {
            PagingInput pagingInput = new PagingInput();
            BeanUtils.copyProperties(input, pagingInput);
            ObjectListEntity<FeedbackEntity> objectListEntity = feedbackService
                .list(null, input.getStatus(), input.getIndex(), input.getSize());
            List<FeedbackListOutput> listOutput = new LinkedList<>();
            for (FeedbackEntity feedbackEntity : objectListEntity.getElements()) {
                FeedbackListOutput output = new FeedbackListOutput();
                BeanUtils.copyProperties(feedbackEntity, output);
                listOutput.add(output);
            }
            PagingOutput pagingOutput = new PagingOutput();
            BeanUtils.copyProperties(objectListEntity, pagingOutput);
            ListOutput<FeedbackListOutput> feedbackOutputListOutput = new ListOutput<>();
            feedbackOutputListOutput.setPaging(pagingOutput);
            feedbackOutputListOutput.setList(listOutput);
            super.outputData(feedbackOutputListOutput);
        } catch (Exception e) {
            super.outputException(500);
            super.outputExceptionToLog(this.getClass(), e, input);
        }
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public void list(FeedbackReplyInput input) {
        try {
            FeedbackEntity feedbackEntity = new FeedbackEntity();
            BeanUtils.copyProperties(input, feedbackEntity);
            FeedbackEntity reply = feedbackService.reply(feedbackEntity);
            FeedbackReplyOutput feedbackReplyOutput = new FeedbackReplyOutput();
            BeanUtils.copyProperties(reply, feedbackReplyOutput);
            super.outputData(feedbackReplyOutput);
        } catch (Exception e) {
            super.outputException(500);
            super.outputExceptionToLog(this.getClass(), e, input);
        }
    }
}
