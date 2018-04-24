package com.hdsxtech.www.mvptestt.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.adapter.NewsAdapter;
import com.hdsxtech.www.mvptestt.bean.MyNewsBean;
import com.hdsxtech.www.mvptestt.presenter.MyNewsPresenter;
import com.hdsxtech.www.mvptestt.view.NewsFrgView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者:丁文 on 2018/4/11.
 * copyright: www.hdsxtech.com
 */

public class MyNewsFragment extends Fragment implements NewsFrgView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_theme)
    RecyclerView rvTheme;
    @BindView(R.id.sf_swipe)
    SwipeRefreshLayout sfSwipe;
    Unbinder unbinder;
    private View notDataView;
    private View errorView;
    private NewsAdapter adapter;
    private MyNewsPresenter presenter;
    private int mNextRequestPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_theme, null);
        unbinder = ButterKnife.bind(this, view);
        initFg();
        presenter = new MyNewsPresenter(this);
        presenter.getData(mNextRequestPage);
        return view;
    }

    private void initFg() {
        sfSwipe.setOnRefreshListener(this);
        mNextRequestPage = 1;

        rvTheme.setLayoutManager(new LinearLayoutManager(getContext()));
        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) rvTheme.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading();
                onRefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) rvTheme.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading();
                onRefresh();
            }
        });
        adapter = new NewsAdapter(R.layout.item_fragment_mynews, null);
        rvTheme.setAdapter(adapter);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getData(mNextRequestPage);
            }
        }, rvTheme);
        //首次登陆时loading页面
        loading();
    }

    int PAGE_SIZE = 20;

    @Override
    public void getData(MyNewsBean titleBean, int mNextRequestPage) {
        Log.d("refresh", mNextRequestPage + "个");

        int size = titleBean == null ? 0 : titleBean.getR().size();
        if (sfSwipe.isRefreshing()) {
            sfSwipe.setRefreshing(false);
        }
        if (mNextRequestPage == 1) {
            if (size == 0) {
                adapter.setEmptyView(notDataView);
            } else {
                adapter.setNewData(titleBean.getR());
            }
        } else {
            if (size > 0) {
                adapter.addData(titleBean.getR());
            }
            if (size < PAGE_SIZE) {
                //第一页如果不够一页就不显示没有更多数据布局
                adapter.loadMoreEnd(true);
            } else {
                adapter.loadMoreComplete();
            }
        }
        this.mNextRequestPage++;
    }

    @Override
    public void nodata(String nodata) {
        if (sfSwipe.isRefreshing()) {
            sfSwipe.setRefreshing(false);
        }
    }

    @Override
    public void failed(String fail) {
        if (mNextRequestPage == 1) {
            if (sfSwipe.isRefreshing()) {
                sfSwipe.setRefreshing(false);
            }
            TextView tv_error = (TextView) errorView.findViewById(R.id.tv_error);
            tv_error.setText(fail);
            adapter.setEmptyView(errorView);
        } else {
            adapter.loadMoreFail();
        }

    }

    @Override
    public void loading() {
        adapter.setEmptyView(R.layout.loading_view, (ViewGroup) rvTheme.getParent());
    }

    @Override
    public void loadMore() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        mNextRequestPage = 1;
        adapter.setEnableLoadMore(false);
        presenter.getData(mNextRequestPage);
    }
}
