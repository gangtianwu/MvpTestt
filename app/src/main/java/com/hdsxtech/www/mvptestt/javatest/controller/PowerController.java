package com.hdsxtech.www.mvptestt.javatest.controller;


import com.hdsxtech.www.mvptestt.javatest.API.Power;
import com.hdsxtech.www.mvptestt.javatest.API.Status;
import com.hdsxtech.www.mvptestt.javatest.API.StatusOff;
import com.hdsxtech.www.mvptestt.javatest.API.StatusOn;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class PowerController implements Power {
    Status status;

    @Override
    public void PowerOn() {
        setStatus(new StatusOn());
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void PowerOff() {
        setStatus(new StatusOff());
    }
}
