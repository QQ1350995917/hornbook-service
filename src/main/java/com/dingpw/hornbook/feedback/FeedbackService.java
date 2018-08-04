package com.dingpw.hornbook.feedback;

import com.dingpw.hornbook.common.ObjectListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 10:03.
 */
@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;


    @Override
    public FeedbackEntity add(FeedbackEntity feedbackEntity) {
        return feedbackDao.insert(feedbackEntity);
    }

    @Override
    public FeedbackEntity updateStatus(FeedbackEntity feedbackEntity) {
        return feedbackDao.updateStatus(feedbackEntity);
    }

    @Override
    public FeedbackEntity reply(FeedbackEntity feedbackEntity) {
        return feedbackDao.reply(feedbackEntity);
    }

    @Override
    public ObjectListEntity<FeedbackEntity> list(Long userId,Long status, int index, int size) {
        return feedbackDao.list(userId, status, index, size);
    }
}
