package com.dingpw.hornbook.feedback;

import com.dingpw.hornbook.common.ObjectListEntity;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 09:54.
 */
@Service
public interface IFeedbackService {

    FeedbackEntity add(FeedbackEntity feedbackEntity);

    FeedbackEntity updateStatus(FeedbackEntity feedbackEntity);

    FeedbackEntity reply(FeedbackEntity feedbackEntity);

    ObjectListEntity<FeedbackEntity> list(Long userId,Long status,int index,int size);
}
