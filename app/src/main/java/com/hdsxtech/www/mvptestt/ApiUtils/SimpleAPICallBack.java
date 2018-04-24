package com.hdsxtech.www.mvptestt.ApiUtils;


/**
 * Created by 小鹿 on 2017/2/8.
 */
public class SimpleAPICallBack<T> extends AbsAPICallback<T> {


    public SimpleAPICallBack() {
        super("连接错误", "解析错误", "未知错误");
    }

    public SimpleAPICallBack(String networkMsg, String parseMsg, String unknownMsg) {
        super(networkMsg, parseMsg, unknownMsg);
    }

    @Override
    protected void onError(ApiException ex) {

    }

    @Override
    protected void onPermissionError(ApiException ex) {

    }

    @Override
    protected void onResultError(ApiException ex) {

    }


}
