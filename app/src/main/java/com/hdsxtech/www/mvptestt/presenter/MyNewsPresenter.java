package com.hdsxtech.www.mvptestt.presenter;


import com.hdsxtech.www.mvptestt.API.ApiNewsUtils;
import com.hdsxtech.www.mvptestt.bean.MyNewsBean;
import com.hdsxtech.www.mvptestt.utils.ApiException;
import com.hdsxtech.www.mvptestt.view.NewsFrgView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:丁文 on 2018/4/11.
 * copyright: www.hdsxtech.com
 */

public class MyNewsPresenter {
    NewsFrgView view;

    public MyNewsPresenter(NewsFrgView view) {
        this.view = view;
    }


    public void getData(final int mNextRequestPage) {
        ApiNewsUtils.getInstance().getMyNews("0002", mNextRequestPage, "", "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyNewsBean myNewsBean) {
                        view.getData(myNewsBean, mNextRequestPage);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.failed(ApiException.getException(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
