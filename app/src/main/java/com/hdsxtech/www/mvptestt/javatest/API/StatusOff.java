package com.hdsxtech.www.mvptestt.javatest.API;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class StatusOff implements Status {
    @Override
    public String OpenTv() {
        return "打开电视成功,已开启";
    }

    @Override
    public String CloseTv() {
        return "关闭电视失败,已是关机状态";
    }

    @Override
    public String TurnUp() {
        return "加音失败,已是关机状态";
    }

    @Override
    public String TurnDown() {
        return "减音失败,已是关机状态";
    }
}
