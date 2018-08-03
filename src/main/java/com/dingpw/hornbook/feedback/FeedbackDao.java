package com.dingpw.hornbook.feedback;

import com.dingpw.hornbook.common.ObjectListEntity;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-03 14:36.
 */
@Component
public class FeedbackDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public FeedbackEntity add(FeedbackEntity feedbackEntity) {
        mongoTemplate.save(feedbackEntity);
        return feedbackEntity;
    }

    public FeedbackEntity replying(FeedbackEntity feedbackEntity) {
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

    public FeedbackEntity replyed(FeedbackEntity feedbackEntity) {
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

    public ObjectListEntity<FeedbackEntity> list(String status, int index, int size) {
        ObjectListEntity<FeedbackEntity> objectListEntity = new ObjectListEntity<>();
//        Query query = new Query(Criteria.where("status").is(status));
        Query query = new Query();
        query.skip(index * size).limit(size);
        query.with(new Sort(Sort.Direction.DESC, "updateTime"));

        List<FeedbackEntity> feedbackEntities = mongoTemplate.find(query, FeedbackEntity.class);
        objectListEntity.setElements(feedbackEntities);
        return objectListEntity;
    }
}
