package com.hdsxtech.www.mvptestt.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者:丁文 on 2018/4/11.
 * copyright: www.hdsxtech.com
 */

public class ApiNewsUtils {
    public static final String bath_url = "http://211.101.37.249:9082/djapp/";
    private static ApiService apiService;

    public static ApiService getApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
//            }

        OkHttpClient okHttpClient = builder
                //SSL证书
                .connectTimeout(15 * 1000L, TimeUnit.MILLISECONDS)//15
                .readTimeout(20 * 1000L, TimeUnit.MILLISECONDS)//20
                .writeTimeout(30 * 1000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String token = "partybuild0002e10adc3949ba59abbe56e057f20f883e";
                        request = request.newBuilder()
                                .addHeader("token", token)
                                .build();
                        return chain.proceed(request);
                    }
                })
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
