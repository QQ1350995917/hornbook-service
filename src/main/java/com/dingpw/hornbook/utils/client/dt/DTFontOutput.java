package com.dingpw.hornbook.utils.client.dt;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 17:12.
 */
public class DTFontOutput {

    private String id;
    private String href;
    private String title;
    private String ttfName;
    private String thumb;

    public DTFontOutput() {
        super();
    }

    public DTFontOutput(String id, String href, String title, String ttfName,String thumb) {
        this.id = id;
        this.href = href;
        this.title = title;
        this.ttfName = ttfName;
        this.thumb = thumb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
