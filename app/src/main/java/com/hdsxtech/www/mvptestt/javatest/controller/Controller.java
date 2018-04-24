package com.hdsxtech.www.mvptestt.javatest.controller;

import android.util.Log;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class Controller {

    private PowerController controller;

    public Controller() {
        controller = new PowerController();
        controller.PowerOff();
    }


    public void OpenTv() {
        Log.d("电视", controller.status.OpenTv() + "=====");
        controller.status.OpenTv();
        controller.PowerOn();
    }

    public void Up() {
        controller.status.TurnUp();
        Log.d("电视", controller.status.TurnUp() + "=====");
    }

    public void Down() {
        controller.status.TurnDown();
        Log.d("电视", controller.status.TurnDown() + "=====");

    }

    public void CloseTv() {
        Log.d("电视", controller.status.CloseTv() + "=====");
        controller.status.CloseTv();
        controller.PowerOff();
    }


    public String Controll() {
        return controller.status.OpenTv() + "==" +
                controller.status.TurnUp() + "==" +
                controller.status.TurnDown() + "==" +
                controller.status.CloseTv() + "==" +
                controller.status.OpenTv();
    }

}
