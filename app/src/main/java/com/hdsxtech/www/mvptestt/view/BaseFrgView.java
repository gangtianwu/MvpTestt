package com.hdsxtech.www.mvptestt.view;


import com.hdsxtech.www.mvptestt.bean.BaseBean;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public interface BaseFrgView {
    /**
     * 获取数据or下拉刷新
     *
     * @param titleBean
     */
    void getData(BaseBean bean, int mNextRequestPage);

    /**
     * 获取数据失败
     *
     * @param fail
     */
    void failed(String fail);

    /**
     * 显示loading界面
     */
    void loading();
}
