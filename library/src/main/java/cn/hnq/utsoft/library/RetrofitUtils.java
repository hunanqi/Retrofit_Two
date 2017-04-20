package cn.hnq.utsoft.library;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：
 * Desc：
 */

public class RetrofitUtils {
    public static<T> Observable<T> getObservable(String baseurl, String url, Map<String,String> maps, final Class<T> tClass){
        //retrofit初始化
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(baseurl)
                .client(getOkHttp())//增加OKhttp设置生效
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //支持RXjava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Observable<String> observable = retrofitInterface.getData(url, maps);
        Observable<T> map = observable.map(new Function<String, T>() {
            @Override
            public T apply(String s) throws Exception {
                Gson gson = new Gson();
                T t = gson.fromJson(s, tClass);
                return t;
            }
        });
        return map;
    }
    /**
     * 设置OKhttp的参数，打印网络请求详情
     */
    private static OkHttpClient getOkHttp(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.i("RetrofitLog","retrofitBack = "+message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        return client;
    }

}
