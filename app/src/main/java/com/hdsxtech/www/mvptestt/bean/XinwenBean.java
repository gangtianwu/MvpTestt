package com.hdsxtech.www.mvptestt.bean;

import java.io.Serializable;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class XinwenBean implements Serializable {

    /**
     * imageUrl :
     * name : 组工干部要常具“四心”
     * id : 23787047-BC97-4EB4-BDC9-D2F6F4AE5D3A
     * time : 2018-04-16 16:19:19
     * url : http://211.101.37.249:9081/djweb/resource-detail?id=23787047-BC97-4EB4-BDC9-D2F6F4AE5D3A
     */

    private String imageUrl;
    private String name;
    private String id;
    private String time;
    private String url;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
