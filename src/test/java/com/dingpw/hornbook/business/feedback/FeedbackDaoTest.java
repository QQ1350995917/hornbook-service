package com.dingpw.hornbook.business.feedback;

import com.dingpw.hornbook.business.ObjectListEntity;
import com.dingpw.hornbook.dao.feedback.FeedbackDao;
import com.dingpw.hornbook.dao.feedback.FeedbackEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 14:42.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackDaoTest {
    @Autowired
    private FeedbackDao feedbackDao;

    @Test
    public void add() throws Exception {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setType("type");
        feedbackEntity.setTitle("title");
        feedbackEntity.setContent("content");
        feedbackEntity.setUserId(3L);
        feedbackEntity.setUserName("userName");
        feedbackEntity.setReplyId(4L);
        feedbackEntity.setReplyContent("replyContent");
        feedbackEntity.setPlatform("iOS:890");
        feedbackEntity.setVersion("234");
        feedbackEntity.setStatus(0L);
        feedbackEntity.setCreateTime(System.currentTimeMillis());
        feedbackEntity.setUpdateTime(System.currentTimeMillis());
        feedbackDao.insert(feedbackEntity);
    }

    @Test
    public void list() throws Exception {
        ObjectListEntity<FeedbackEntity> list = feedbackDao.list(0L,0L, 1, 1);
        System.out.println(list);
    }
}