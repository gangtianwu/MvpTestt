package com.hdsxtech.www.mvptestt;

import android.widget.EditText;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public class LoginPresenter {
    LoginView loginview;
    public LoginPresenter(LoginView loginView) {
        this.loginview = loginView;
    }

    public void login(EditText username, EditText password) {
        loginview.showLoading();
        if (username.equals(password)){
            loginview.showSuccess("成功了");
        }else {
            loginview.showFailed("失败了");
        }

    }
}
