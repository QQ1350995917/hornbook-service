package com.dingpw.hornbook.feedback;

import com.dingpw.hornbook.common.ObjectListEntity;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 11:10. inCharge@韦宏毅@115477@13811808950
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest {

    @Autowired
    private IFeedbackService feedbackService;

    private static FeedbackEntity feedbackEntity = new FeedbackEntity();

    static {
        feedbackEntity.setType("type");
        feedbackEntity.setTitle("title");
        feedbackEntity.setContent("content");
        feedbackEntity.setUserId(3L);
        feedbackEntity.setUserName("userName");
        feedbackEntity.setPlatform("iOS:890");
        feedbackEntity.setVersion("234");
        feedbackEntity.setCreateTime(System.currentTimeMillis());
        feedbackEntity.setUpdateTime(System.currentTimeMillis());
    }

    @Test
    public void add() throws Exception {
        feedbackEntity.setId(UUID.randomUUID().toString());
        feedbackService.add(feedbackEntity);
    }

    @Test
    public void updateStatus() throws Exception {
        feedbackEntity.setId("f67a36ee-75dc-4798-b1c8-ef89766d9117");
        feedbackEntity.setStatus(1L);
        feedbackEntity.setUpdateTime(System.currentTimeMillis());
        feedbackService.updateStatus(feedbackEntity);
    }

    @Test
    public void reply() throws Exception {
        feedbackEntity.setId("f67a36ee-75dc-4798-b1c8-ef89766d9117");
        feedbackEntity.setStatus(2L);
        feedbackEntity.setReplyId(4L);
        feedbackEntity.setReplyContent("replyContent");
        feedbackEntity.setUpdateTime(System.currentTimeMillis());
        feedbackService.reply(feedbackEntity);
    }

    @Test
    public void list() throws Exception {
        ObjectListEntity<FeedbackEntity> objectListEntity = feedbackService.list(null,null, 0, 1);
        System.out.println(objectListEntity.getElements().size());
    }
}