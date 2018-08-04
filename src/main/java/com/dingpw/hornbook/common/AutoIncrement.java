package com.dingpw.hornbook.common;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-04 11:25.
 */

@Document(collection = "sequence")
public class AutoIncrement {
    @Id
    private String id;// 主键
    @Field
    private String collName;// 集合名称
    @Field
    private Long seqId;// 序列值

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollName() {
        return collName;
    }

    public void setCollName(String collName) {
        this.collName = collName;
    }

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }
}
