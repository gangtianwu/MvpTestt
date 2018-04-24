package com.hdsxtech.www.mvptestt.API;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class Yeah {
    private ReflectTest test;
    private String test1 = "测试";

    public Yeah() {
    }

    public String get() {

        try {
            Class name = Class.forName("com.hdsxtech.www.mydesigntest.API.ReflectTest");
            Object o = name.getConstructor().newInstance();
            Method getName = name.getDeclaredMethod("getName", String.class);
            getName.setAccessible(true);
            test1 = (String) getName.invoke(o, "反射测试");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        test.getNum(1, 13);
        return test1;
    }
}
