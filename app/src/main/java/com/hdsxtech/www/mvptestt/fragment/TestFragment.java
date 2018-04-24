package com.hdsxtech.www.mvptestt.fragment;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.adapter.TestAdapter;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;
import com.hdsxtech.www.mvptestt.presenter.TestPresenter;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class TestFragment extends BaseFragment {


    private TestPresenter presenter;

    @NonNull
    @Override
    int getLayoutId() {
        return R.layout.fragment_theme;
    }

    @NonNull
    @Override
    BasePresenter getPresenter() {
        presenter = new TestPresenter(this);
        return this.presenter;
    }

    @NonNull
    @Override
    BaseQuickAdapter getAdapter() {
        TestAdapter adapter = new TestAdapter(R.layout.item_fragment_mynews, null);
        return adapter;
    }
}
