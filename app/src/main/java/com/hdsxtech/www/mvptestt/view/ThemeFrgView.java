package com.hdsxtech.www.mvptestt.view;


import com.hdsxtech.www.mvptestt.bean.ThemesBean;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public interface ThemeFrgView {
    /**
     * 获取数据or下拉刷新
     * @param titleBean
     */
    void getData(ThemesBean titleBean);

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
    /**
     * 上拉加载更多
     */
    void loadMore();

}
