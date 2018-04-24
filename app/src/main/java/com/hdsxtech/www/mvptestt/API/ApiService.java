package com.hdsxtech.www.mvptestt.API;


import com.hdsxtech.www.mvptestt.bean.BaseBean;
import com.hdsxtech.www.mvptestt.bean.MyNewsBean;
import com.hdsxtech.www.mvptestt.bean.TestNewsBean;
import com.hdsxtech.www.mvptestt.bean.ThemesBean;
import com.hdsxtech.www.mvptestt.bean.TitleBean;
import com.hdsxtech.www.mvptestt.bean.XinwenBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 作者:丁文 on 2017/10/19.
 * copyright: www.tpri.org.cn
 */

public interface ApiService<T> {

    /**
     * 获取省级列表
     */
    @GET("themes")
    Observable<TitleBean> getLeftContent();

    @GET("theme/{id}")
    Observable<ThemesBean> onLoad(@Path("id") int id);


    //我的消息
    @GET("API/message/getMessageList")
    Observable<MyNewsBean> getMyNews(@Query("userId") String userId, @Query("index") int index, @Query("time") String time, @Query("keywords") String keywords);

    @GET("API/message/getMessageList")
    Observable<BaseBean<TestNewsBean>> getNews(@Query("userId") String userId, @Query("index") int index, @Query("time") String time, @Query("keywords") String keywords);
    @GET("API/info/searchResourceInfoList")
    Observable<BaseBean<XinwenBean>> getXinwen(@Query("ccpartyId") String ccpartyId, @Query("index") int index, @Query("time") String time, @Query("keywords") String keywords);
//
//    @GET("news/latest")
//    Observable <HomeBean> onLatest();
//
//    @GET("news/{id}")
//    Observable <WebBean>onLoadWeb(@Path("id") int id);
//
//    @GET("news/before/{date}")
//    Observable <HomeBean> onGone(@Path("date") String date);
//    //  at.zhihu.com/api/4/section/34/before/1465772400
//    @GET("theme/{id}/before/{timestamp}")
//    Observable <ThemesBean> onThemeGone(@Path("timestamp") String timestamp, @Path("id")int id);
//
//    @GET("story-extra/{id}")
//    Observable <WebExtraBean> onLoadExtra(@Path("id")int id);


//    @GET("china/")
////    Observable<List<Province>> getProvince();
//    /**
//     * 获取市级列表
//     */
//    @GET("china/{id}")
//    Observable<List<City>> getCity(@Path("id") int id);
//    /**
//     * 获取区县列表
//     */
//    @GET("china/{cityId}/{id}")
//    Observable<List<Country>> getCountry(@Path("cityId") int province, @Path("id") int city);
//    /**
//     * 获取天气状况
//     */
//    @GET("weather")
//    Observable<Weather> getWeather(@Query("cityid") String cityid,
//                                   @Query("key") String key);
//    @GET("weather")
//    Observable<ResponseBody> getWeatherString(@Query("cityid") String cityid,
//                                              @Query("key") String key);


}
