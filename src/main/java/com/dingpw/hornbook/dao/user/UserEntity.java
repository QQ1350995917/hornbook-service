package com.dingpw.hornbook.dao.user;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-09 17:35.
 */
public class UserEntity {

    private Long id;
    private Integer status;
    private Long createTime = System.currentTimeMillis();
    private Long updateTime = System.currentTimeMillis();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
