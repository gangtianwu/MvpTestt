package com.hdsxtech.www.mvptestt.javatest.API;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class StatusOn implements Status {
    @Override
    public String OpenTv() {
        return "打开电视失败,已开机状态";
    }

    @Override
    public String CloseTv() {
        return "关闭电视成功";
    }

    @Override
    public String TurnUp() {
        return "加音成功,+1";
    }

    @Override
    public String TurnDown() {
        return "减音成功,-1";
    }
}
