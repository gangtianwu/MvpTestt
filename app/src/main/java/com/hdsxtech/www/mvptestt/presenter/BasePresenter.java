package com.hdsxtech.www.mvptestt.presenter;


import com.hdsxtech.www.mvptestt.ApiUtils.ApiException;
import com.hdsxtech.www.mvptestt.ApiUtils.SimpleAPICallBack;
import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.view.BaseFrgView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:丁文 on 2018/4/16.
 * copyright: www.hdsxtech.com
 */

public abstract class BasePresenter {
    BaseFrgView view;

    public BasePresenter(BaseFrgView view) {
        this.view = view;
    }

    public void attachView(BaseFrgView view) {

    }

    public void detachView() {
        view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public void getData(final int mPage) {
        getObservable(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleAPICallBack<BaseBean>() {
                    @Override
                    protected void onError(ApiException ex) {
                        if (isViewAttached())
                            view.failed(ex.getDisplayMessage() + ",请稍后重试!");
                    }

                    @Override
                    public void onNext(BaseBean bean) {

                        if (isViewAttached())
                            view.getData(bean, mPage);
                    }
                });
    }

    //new Observer<BaseBean>() {
//        @Override
//        public void onSubscribe(Disposable d) {
//
//        }
//
//        @Override
//        public void onNext(BaseBean bean) {
//            view.getData(bean, mPage);
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            view.failed(ApiException.getException(e));
//        }
//
//        @Override
//        public void onComplete() {
//
//        }
//    }
    abstract Observable<BaseBean> getObservable(int mPage);

}
