package com.hdsxtech.www.mvptestt.bean;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class TestNewsBean {
    private String createtime;
    private int messtatus;
    private String id;
    private String mescontent;
    private String mesname;
    private int mestype;
    private String url;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getMesstatus() {
        return messtatus;
    }

    public void setMesstatus(int messtatus) {
        this.messtatus = messtatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMescontent() {
        return mescontent;
    }

    public void setMescontent(String mescontent) {
        this.mescontent = mescontent;
    }

    public String getMesname() {
        return mesname;
    }

    public void setMesname(String mesname) {
        this.mesname = mesname;
    }

    public int getMestype() {
        return mestype;
    }

    public void setMestype(int mestype) {
        this.mestype = mestype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
