package com.infinite.fake_mz.entity;

/**
 * Created by inf on 2016/11/8.
 */

public class ValueInfo {
    /***
     * "_id": "582131bf421aa91376974652",
     "createdAt": "2016-11-08T10:00:31.146Z",
     "desc": "\u6df1\u5165Android\u5185\u5b58\u6cc4\u9732",
     "publishedAt": "2016-11-08T11:51:41.578Z",
     "source": "web",
     "type": "Android",
     "url": "http://blog.csdn.net/ccj659/article/details/53032683",
     "used": true,
     "who": "Chauncey"
     */

    public String _id;
    public String createdAt;
    public String desc;
    private String publicshedAt;
    private String source;
    public String type;
    public String url;
    public boolean used;
    public String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublicshedAt() {
        return publicshedAt;
    }

    public void setPublicshedAt(String publicshedAt) {
        this.publicshedAt = publicshedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
