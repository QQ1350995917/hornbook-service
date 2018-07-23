package com.dingpw.hornbook.font;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 22:02.
 */
@Entity
@Table(name = "font")
@JsonIgnoreProperties(value = {"oid"}, allowGetters = true)
@Component
public class FontEntity implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long nid;
    @NotNull
    private Long oid;
    @NotBlank
    private String title;
    @NotBlank
    private String ttfName;
    private String summary;
    private String thumb;
    private long createTime;
    private long updateTime;

    public FontEntity() {
        super();
    }

    public FontEntity(@NotNull Long nid, @NotNull Long oid,
        @NotBlank String title, @NotBlank String ttfName, String summary) {
        this.nid = nid;
        this.oid = oid;
        this.title = title;
        this.ttfName = ttfName;
        this.summary = summary;
    }

    public FontEntity(@NotNull Long id,@NotNull Long nid, @NotNull Long oid,
        @NotBlank String title, @NotBlank String ttfName, String summary) {
        this(nid, oid, title, ttfName, summary);
        this.id = id;
    }

    public FontEntity(@NotNull Long nid, @NotNull Long oid,
        @NotBlank String title, @NotBlank String ttfName, String summary, long createTime,
        long updateTime) {
        this(nid, oid, title, ttfName, summary);
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public FontEntity(@NotNull Long id,@NotNull Long nid, @NotNull Long oid,
        @NotBlank String title, @NotBlank String ttfName, String summary, long createTime,
        long updateTime) {
        this(id,nid, oid, title, ttfName, summary);
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTtfName() {
        return ttfName;
    }

    public void setTtfName(String ttfName) {
        this.ttfName = ttfName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return this.nid + " " + this.title;
    }
}
