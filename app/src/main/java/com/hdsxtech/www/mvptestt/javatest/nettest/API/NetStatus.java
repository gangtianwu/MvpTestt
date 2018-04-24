package com.hdsxtech.www.mvptestt.javatest.nettest.API;


import com.hdsxtech.www.mvptestt.bean.BaseBean;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public interface NetStatus {
    /**
     * loading
     */
    void Loading();
    /**
     * 成功
     */
    void success(BaseBean bean);
    /**
     * 失败
     */
    void failed(String fail);
}
