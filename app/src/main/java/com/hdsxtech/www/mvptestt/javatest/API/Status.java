package com.hdsxtech.www.mvptestt.javatest.API;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public interface Status {
    /**
     * 打开
     */
    String OpenTv();
    /**
     * 关闭
     */
    String CloseTv();
    /**
     * 升音
     */
    String TurnUp();
    /**
     * 降音
     */
    String TurnDown();
}
