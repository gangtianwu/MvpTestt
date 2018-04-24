package com.hdsxtech.www.mvptestt.view;


import com.hdsxtech.www.mvptestt.bean.TitleBean;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public interface MainActivityView {
    /**
     * 获取数据
     * @param titleBean
     */
    void getData(TitleBean titleBean);

    void nodata(String nodata);

    /**
     * 获取数据失败
     * @param fail
     */
    void failed(String fail);

    /**
     * 显示loading界面
     */
    void loading();
}
