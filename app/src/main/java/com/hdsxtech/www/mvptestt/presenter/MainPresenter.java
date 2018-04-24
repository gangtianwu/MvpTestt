package com.hdsxtech.www.mvptestt.presenter;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hdsxtech.www.mvptestt.API.ApiUtils;
import com.hdsxtech.www.mvptestt.MainActivity;
import com.hdsxtech.www.mvptestt.bean.TitleBean;
import com.hdsxtech.www.mvptestt.view.MainActivityView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:丁文 on 2018/4/3.
 * copyright: www.hdsxtech.com
 */

public class MainPresenter {
    MainActivityView view;
    BaseQuickAdapter adapter;
    RecyclerView rvLeft;
    private Observer<TitleBean> observer;
    private Observable<TitleBean> leftContent;

    public MainPresenter(MainActivityView view) {
        this.view = view;
        initApi();
    }

    public MainPresenter(MainActivity mainActivity, BaseQuickAdapter adapter, RecyclerView rvLeft) {
        this.view = mainActivity;
        this.adapter = adapter;
        this.rvLeft = rvLeft;
        initApi();
    }

    public void getData() {
        view.loading();
        leftContent.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public void initApi() {
        leftContent = ApiUtils.getInstance().getLeftContent();
        observer = new Observer<TitleBean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(TitleBean titleBean) {
                if (titleBean == null || titleBean.getOthers().size() == 0) {
                    view.nodata("数据为空");
                    return;
                }
                view.getData(titleBean);
            }

            @Override
            public void onError(Throwable e) {
                view.failed("网络或未知故障,获取数据失败");
            }

            @Override
            public void onComplete() {

            }
        };
    }

}
