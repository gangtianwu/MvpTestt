package com.hdsxtech.www.mvptestt.javatest.nettest.API;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public class RefreshLoading implements NetStatus {
    BaseQuickAdapter adapter;
    RecyclerView rvTheme;
    Fragment fg;
    View emptyView;
    BasePresenter presenter;
    private View errorView;
    SwipeRefreshLayout sfSwipe;

    public RefreshLoading(SwipeRefreshLayout rfLayout, BaseQuickAdapter adapter, RecyclerView rvThme, Fragment fg, BasePresenter presenter) {
        this.sfSwipe = rfLayout;
        this.presenter = presenter;
        this.adapter = adapter;
        this.rvTheme = rvThme;
        this.fg = fg;
        init();
    }

    private void init() {
        emptyView = fg.getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) rvTheme.getParent(), false);
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
        errorView = fg.getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) rvTheme.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });
    }

    @Override
    public void Loading() {
        adapter.setEnableLoadMore(false);

    }

    public void refresh() {
        Loading();
        adapter.setEnableLoadMore(false);
        presenter.getData(1);
    }

    @Override
    public void success(BaseBean bean) {
        Log.d("刷新测试", "走了这一步");
        int size = bean == null ? 0 : bean.getR().size();
        if (sfSwipe != null && sfSwipe.isRefreshing()) {
            sfSwipe.setRefreshing(false);
        }
        if (size == 0) {
            adapter.setEmptyView(emptyView);
        } else {
            adapter.setNewData(bean.getR());
        }
    }

    @Override
    public void failed(String fail) {
        if (sfSwipe != null && sfSwipe.isRefreshing()) {
            sfSwipe.setRefreshing(false);
        }
        TextView tv_error = (TextView) errorView.findViewById(R.id.tv_error);
        tv_error.setText(fail);
        adapter.setEmptyView(errorView);
    }
}
