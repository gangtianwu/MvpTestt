package com.hdsxtech.www.mvptestt.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.adapter.ThemefgAdapter;
import com.hdsxtech.www.mvptestt.bean.ThemesBean;
import com.hdsxtech.www.mvptestt.presenter.ThemeFragPresenter;
import com.hdsxtech.www.mvptestt.view.ThemeFrgView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public class ThemeFragment extends Fragment implements ThemeFrgView {

    @BindView(R.id.rv_theme)
    RecyclerView rvTheme;
    @BindView(R.id.sf_swipe)
    SwipeRefreshLayout sfSwipe;
    Unbinder unbinder;
    private ThemeFragPresenter presenter;
    private int id;
    private String theme;
    private View notDataView;
    private View errorView;
    private ThemefgAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_theme, null);
        unbinder = ButterKnife.bind(this, view);
        presenter = new ThemeFragPresenter(this);
        initData();
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            id = arguments.getInt("id");
            theme = arguments.getString("theme");
        }
        initFg();
        presenter.getData(id);
    }

    private void initFg() {
        rvTheme.setLayoutManager(new LinearLayoutManager(getContext()));
        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) rvTheme.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onrefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) rvTheme.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onrefresh();
            }
        });
        adapter = new ThemefgAdapter(R.layout.item_theme, null,getContext());
        rvTheme.setAdapter(adapter);
    }

    private void onrefresh() {

    }

    @Override
    public void getData(ThemesBean titleBean) {
        adapter.addData(titleBean.getStories());

    }

    @Override
    public void nodata(String nodata) {

    }

    @Override
    public void failed(String fail) {

    }

    @Override
    public void loading() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
