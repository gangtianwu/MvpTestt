package com.hdsxtech.www.mvptestt.presenter;

import com.hdsxtech.www.mvptestt.API.ApiUtils;
import com.hdsxtech.www.mvptestt.bean.ThemesBean;
import com.hdsxtech.www.mvptestt.view.ThemeFrgView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public class ThemeFragPresenter {
    ThemeFrgView themeFrgView;
    private Observer<ThemesBean> observer;

    public ThemeFragPresenter(ThemeFrgView themeFrgView) {
        this.themeFrgView = themeFrgView;
        init();
    }

    private void init() {
        observer = new Observer<ThemesBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ThemesBean themesBean) {
                if (themesBean == null || themesBean.getStories().size() == 0) {
                    themeFrgView.nodata("没有数据");
                    return;
                }
                themeFrgView.getData(themesBean);
            }

            @Override
            public void onError(Throwable e) {
                themeFrgView.failed("网络或未知错误,获取数据失败");
            }

            @Override
            public void onComplete() {

            }
        };

    }

    public void getData(int id) {
        ApiUtils.getInstance().onLoad(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
