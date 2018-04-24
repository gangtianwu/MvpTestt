package com.hdsxtech.www.mvptestt.javatest.nettest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.javatest.nettest.API.NetStatus;
import com.hdsxtech.www.mvptestt.javatest.nettest.controller.SetStatus;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;
import com.hdsxtech.www.mvptestt.view.BaseFrgView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public abstract class CeshiBaseFg extends Fragment implements BaseFrgView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rv_theme)
    RecyclerView rvTheme;
    @BindView(R.id.sf_swipe)
    SwipeRefreshLayout sfSwipe;
    Unbinder unbinder;
    private int mNextRequestPage;
    private BasePresenter presenter;
    private BaseQuickAdapter adapter;
    int PAGE_SIZE = 20;
    private SetStatus instance;
    private NetStatus status;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), getLayoutId(), null);
        unbinder = ButterKnife.bind(this, view);
        initFg();
        presenter.getData(mNextRequestPage);
        return view;
    }

    public void initFg() {
        presenter = getPresenter();
        sfSwipe.setOnRefreshListener(this);
        mNextRequestPage = 1;

        rvTheme.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = getAdapter();
        rvTheme.setAdapter(adapter);

        //首次登陆时loading页面
        instance = new SetStatus(sfSwipe, adapter, rvTheme, this, presenter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                instance.loadMore();
                status = instance.status;
                presenter.getData(mNextRequestPage);
            }
        }, rvTheme);
        instance.firstLoading();
        status = instance.status;
        status.Loading();
    }

    @NonNull
    protected abstract BasePresenter getPresenter();


    @NonNull
    protected abstract BaseQuickAdapter getAdapter();


    @NonNull
    protected abstract int getLayoutId();
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void onRefresh() {
        Log.d("ceshi+refresh之前",        status.getClass().getName()+"++++");

        instance.refresh();
        status = instance.status;
        presenter.getData(1);

        Log.d("ceshi+refresh之后",        status.getClass().getName()+"++++");


    }

    @Override
    public void getData(BaseBean bean, int mNextRequestPage) {
        status.success(bean);
        this.mNextRequestPage++;
        Log.d("ceshi",mNextRequestPage +         status.getClass().getName()+"++++");
    }

    @Override
    public void failed(String fail) {
        status.failed(fail);
    }

    @Override
    public void loading() {

    }
}
