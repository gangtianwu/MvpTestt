package com.hdsxtech.www.mvptestt.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:丁文 on 2017/10/19.
 * copyright: www.tpri.org.cn
 */

public class ApiUtils {
    public static final String bath_url = "http://news-at.zhihu.com/api/4/";
    private static ApiService apiService;

    public static ApiService getApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        if (BuildConfig.DEBUG){
//            LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
//            }

        OkHttpClient okHttpClient = builder
                .connectTimeout(15 * 1000L, TimeUnit.MILLISECONDS)//15
                .readTimeout(20 * 1000L, TimeUnit.MILLISECONDS)//20
                .writeTimeout(30 * 1000L, TimeUnit.MILLISECONDS)
                .build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(bath_url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        return apiService;
    }

    public synchronized static ApiService getInstance() {
        if (apiService == null) {
            getApiService();
        }
        return apiService;
    }
}
