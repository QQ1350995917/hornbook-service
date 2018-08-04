package com.dingpw.hornbook.feedback;

import com.dingpw.hornbook.common.ObjectListEntity;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 14:36.
 */
@Repository
public class FeedbackDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public FeedbackEntity insert(FeedbackEntity feedbackEntity) {
        mongoTemplate.insert(feedbackEntity);
        return feedbackEntity;
    }

    public FeedbackEntity updateStatus(FeedbackEntity feedbackEntity) {
        Query query = new Query(Criteria.where("id").is(feedbackEntity.getId()));
        Update update = new Update();
        update.set("status", feedbackEntity.getStatus());
        update.set("updateTime", feedbackEntity.getUpdateTime());
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, FeedbackEntity.class);
        if (writeResult.getModifiedCount() > 0) {
            return feedbackEntity;
        } else {
            return null;
        }
    }

    public FeedbackEntity reply(FeedbackEntity feedbackEntity) {
        Query query = new Query(Criteria.where("id").is(feedbackEntity.getId()));
        Update update = new Update();
        update.set("status", feedbackEntity.getStatus());
        update.set("replyId", feedbackEntity.getReplyId());
        update.set("replyContent", feedbackEntity.getReplyContent());
        update.set("updateTime", feedbackEntity.getUpdateTime());
        UpdateResult writeResult = mongoTemplate.updateFirst(query, update, FeedbackEntity.class);
        if (writeResult.getModifiedCount() > 0) {
            return feedbackEntity;
        } else {
            return null;
        }
    }

    public ObjectListEntity<FeedbackEntity> list(Long userId, Long status, int index, int size) {
        Query query = new Query();
        if (userId != null && status != null) {
            query.addCriteria(Criteria.where("userId").is(userId).and("status").is(status));
        } else if (userId != null && status == null) {
            query.addCriteria(Criteria.where("userId").is(userId));
        } else if (userId == null && status != null) {
            query.addCriteria(Criteria.where("status").is(status));
        }

        query.skip(index * size);
        query.limit(size);

        List<FeedbackEntity> feedbackEntities = mongoTemplate.find(query, FeedbackEntity.class);
        ObjectListEntity<FeedbackEntity> objectListEntity = new ObjectListEntity<>();
        objectListEntity.setElements(feedbackEntities);
        return objectListEntity;
    }
}
