package com.dingpw.hornbook;

import java.lang.reflect.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 11:30.
 */
@Component
public class ApplicationMongoEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoTemplate mongo;

//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
//        if (event != null) {
//            ReflectionUtils.doWithFields(event.getClass(), new ReflectionUtils.FieldCallback() {
//                public void doWith(Field field)
//                    throws IllegalArgumentException, IllegalAccessException {
//                    ReflectionUtils.makeAccessible(field);
//                    // 如果字段添加了我们自定义的AutoIncKey注解
//                    if (field.isAnnotationPresent(AutoIncrementKey.class)) {
//                        // 设置自增ID
//                        field.set(event, getNextId(event.getClass().getSimpleName()));
//                    }
//                }
//            });
//        }
//    }

    /**
     * 获取下一个自增ID
     *
     * @param collName 集合（这里用类名，就唯一性来说最好还是存放长类名）名称
     * @return 序列值
     */
    private Long getNextId(String collName) {
        return 0L;
    }
}
