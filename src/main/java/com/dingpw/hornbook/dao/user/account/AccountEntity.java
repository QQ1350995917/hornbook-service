package com.dingpw.hornbook.dao.user.account;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-08-09 18:03.
 */
public class AccountEntity {

    private Long id;
    private Long userId;
    private String name;
    private String type;
    private String authId;
    private String authName;
    private String authAvatar;
    private Long createTime;
    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthAvatar() {
        return authAvatar;
    }

    public void setAuthAvatar(String authAvatar) {
        this.authAvatar = authAvatar;
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
