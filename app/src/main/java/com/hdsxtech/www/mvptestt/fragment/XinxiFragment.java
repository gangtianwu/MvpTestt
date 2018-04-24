package com.hdsxtech.www.mvptestt.fragment;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.R;
import com.hdsxtech.www.mvptestt.adapter.XinxiAdapter;
import com.hdsxtech.www.mvptestt.javatest.controller.Controller;
import com.hdsxtech.www.mvptestt.presenter.BasePresenter;
import com.hdsxtech.www.mvptestt.presenter.XinxiPresenter;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class XinxiFragment extends BaseFragment {
    @NonNull
    @Override
    int getLayoutId() {
        return R.layout.fragment_theme;
    }

    @NonNull
    @Override
    BasePresenter getPresenter() {
        XinxiPresenter presenter = new XinxiPresenter(this);
        return presenter;
    }

    @NonNull
    @Override
    BaseQuickAdapter getAdapter() {
        final Controller controller = new Controller();
        XinxiAdapter adapter = new XinxiAdapter(R.layout.item_news, null);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position == 1){
                    controller.OpenTv();
                }
                if (position == 2){
                    controller.Up();
                }
                if (position == 3){
                    controller.Down();
                }
                if (position == 4){
                    controller.CloseTv();
                }
            }
        });
        return adapter;
    }
}
