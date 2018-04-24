package com.hdsxtech.www.mvptestt.presenter;


import com.hdsxtech.www.mvptestt.API.ApiNewsUtils;
import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.view.BaseFrgView;

import io.reactivex.Observable;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public class TestPresenter extends BasePresenter {
    public TestPresenter(BaseFrgView view) {
        super(view);
    }

    @Override
    Observable<BaseBean> getObservable(int mPage) {
        return ApiNewsUtils.getInstance().getNews("0002", mPage, "", "");
    }
}
