package cn.hnq.utsoft.retrofit_two.utils;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：
 * Desc：
 */

public interface RetrofitInterface {
    @POST
    Flowable<String> getData(@Url String url, @QueryMap HashMap<String,String> map);
}
