package com.hdsxtech.www.mvptestt.javatest.nettest.controller;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.javatest.nettest.API.FirstLoading;
import com.hdsxtech.www.mvptestt.javatest.nettest.API.LoadMore;
import com.hdsxtech.www.mvptestt.javatest.nettest.API.NetStatus;
import com.hdsxtech.www.mvptestt.javatest.nettest.API.RefreshLoading;
import com.hdsxtech.www.mvptestt.javatest.nettest.API.StatusController;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public class SetStatus implements StatusController {
    SwipeRefreshLayout sfSwipe;
    public NetStatus status;
    BaseQuickAdapter adapter;
    RecyclerView rvTheme;
    Fragment fg;
    BasePresenter presenter;
    private FirstLoading firstLoading;
    private RefreshLoading refreshLoading;
    private LoadMore loadMore;

    public SetStatus(SwipeRefreshLayout sfSwipe, BaseQuickAdapter adapter, RecyclerView rvThme, Fragment fg, BasePresenter presenter) {
        this.presenter = presenter;
        this.adapter = adapter;
        this.rvTheme = rvThme;
        this.fg = fg;
        this.sfSwipe = sfSwipe;
        init();
    }

    private void init() {
        firstLoading = new FirstLoading(adapter, rvTheme, fg, presenter);
        refreshLoading = new RefreshLoading(sfSwipe, adapter, rvTheme, fg, presenter);
        loadMore = new LoadMore(adapter, rvTheme, fg, presenter);
    }

    @Override
    public void firstLoading() {
        setStatus(firstLoading);
    }

    @Override
    public void refresh() {
        setStatus(refreshLoading);
    }

    @Override
    public void loadMore() {
        setStatus(loadMore);
    }

    public void setStatus(NetStatus status) {
        this.status = status;
    }
}
