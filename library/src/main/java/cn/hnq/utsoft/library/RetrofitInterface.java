package cn.hnq.utsoft.library;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：reteofit的接口
 * Desc：
 */

public interface RetrofitInterface {
    @POST
    Observable<String> getData(@Url String url, @QueryMap Map<String,String> map);
}
