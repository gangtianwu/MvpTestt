package com.hdsxtech.www.mvptestt.fragment;


import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.adapter.TestAdapter;
import com.hdsxtech.www.mvptestt.javatest.nettest.CeshiBaseFg;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;
import com.hdsxtech.www.mvptestt.presenter.TestPresenter;

/**
 * 作者:丁文 on 2018/4/18.
 * copyright: www.hdsxtech.com
 */

public class CeshiFragment extends CeshiBaseFg {
    private TestPresenter presenter;
    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        presenter = new TestPresenter(this);
        return this.presenter;
    }

    @NonNull
    @Override
    protected BaseQuickAdapter getAdapter() {
        TestAdapter adapter = new TestAdapter(R.layout.item_fragment_mynews, null);
        return adapter;
    }

    @NonNull
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_theme;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }
    //    @NonNull
//    @Override
//    int getLayoutId() {
//        return R.layout.fragment_theme;
//    }
//
//    @NonNull
//    @Override
//    BasePresenter getPresenter() {
//        return new TestPresenter(this);
//    }
//
//    @NonNull
//    @Override
//    BaseQuickAdapter getAdapter() {
//        XinxiAdapter adapter = new XinxiAdapter(R.layout.item_news, null);
//
//        return adapter;
//    }
}
