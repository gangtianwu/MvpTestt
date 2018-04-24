package com.hdsxtech.www.mvptestt;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public interface LoginView {
    void showLoading();
    void showSuccess(String hint);
    void showFailed(String fail);

}
