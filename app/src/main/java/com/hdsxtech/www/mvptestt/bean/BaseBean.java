package com.hdsxtech.www.mvptestt.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class BaseBean<T> implements Serializable {
    public int c;
    public String m;
    public List<T> r;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }


    public void setM(String m) {
        this.m = m;
    }

    public List<T> getR() {
        return r;
    }

    public void setR(List<T> r) {
        this.r = r;
    }
}
