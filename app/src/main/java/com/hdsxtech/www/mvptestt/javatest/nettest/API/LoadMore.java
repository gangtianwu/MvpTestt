package com.hdsxtech.www.mvptestt.javatest.nettest.API;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public class LoadMore implements NetStatus {
    BaseQuickAdapter adapter;
    RecyclerView rvTheme;
    Fragment fg;
    BasePresenter presenter;

    public LoadMore(BaseQuickAdapter adapter, RecyclerView rvThme, Fragment fg, BasePresenter presenter) {
        this.presenter = presenter;
        this.adapter = adapter;
        this.rvTheme = rvThme;
        this.fg = fg;

    }

    @Override
    public void Loading() {

    }

    @Override
    public void success(BaseBean bean) {
        int size = bean == null ? 0 : bean.getR().size();
        if (size > 0) {
            adapter.addData(bean.getR());
        }
        if (size < 20) {
            //第一页如果不够一页就不显示没有更多数据布局
            adapter.loadMoreEnd(true);
        } else {
            adapter.loadMoreComplete();
        }
    }

    @Override
    public void failed(String fail) {
        adapter.loadMoreFail();
    }
}
