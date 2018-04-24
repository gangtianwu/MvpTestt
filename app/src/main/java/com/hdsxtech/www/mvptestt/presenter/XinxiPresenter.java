package com.hdsxtech.www.mvptestt.presenter;


import com.hdsxtech.www.mvptestt.API.ApiNewsUtils;
import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.view.BaseFrgView;

import io.reactivex.Observable;

/**
 * 作者:丁文 on 2018/4/17.
 * copyright: www.hdsxtech.com
 */

public class XinxiPresenter extends BasePresenter {
    public XinxiPresenter(BaseFrgView view) {
        super(view);
    }

    @Override
    Observable<BaseBean> getObservable(int mPage) {
        return ApiNewsUtils.getInstance().getXinwen("020.001.007",mPage,"","");
    }
}
