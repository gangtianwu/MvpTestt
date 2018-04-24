package com.hdsxtech.www.mvptestt.utils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * Author:       梁铖城
 * Email:        1038127753@qq.com
 * Date:         2015年11月21日15:28:25
 * Description:
 */
public class ApiException {

    public static String getException(Throwable e) {
        if (e instanceof UnknownHostException) {
            return "请打开网络，请稍后再试";
        } else if (e instanceof SocketTimeoutException) {
            return "请求超时，请稍后再试";
        } else if (e instanceof ConnectException) {
            return "连接失败，请稍后再试";
        } else if (e instanceof HttpException) {
            return "网路异常，请稍后再试";
        } else {
            return "网络不稳定,请稍后再试";
        }
    }
}
