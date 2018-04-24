package com.hdsxtech.www.mvptestt.javatest.nettest.API;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public interface StatusController {
    /**
     * 首次加载
     */
    void firstLoading();
    /**
     * 下拉刷新
     */
    void refresh();
    /**
     * 加载更多
     */
    void loadMore();


}
