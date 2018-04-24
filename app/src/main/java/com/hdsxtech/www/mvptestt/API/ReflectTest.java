package com.hdsxtech.www.mvptestt.API;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class ReflectTest {

    private String getName(String Faqizhe) {

        return getClass().getName() + "======" + Faqizhe;
    }
    public int getNum(int a , int b){
        int max = Math.max(a, b);
        return max;
    }
}
