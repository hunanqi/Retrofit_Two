package cn.hnq.utsoft.retrofit_two.utils;

import android.util.Log;

import java.util.HashMap;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：
 * Desc：
 */

public class RetrofitUtils {
    public static Flowable<String> getFlowable(String baseurl, String url, Object bin){
        //得到包含参数的map集合
        HashMap<String, String> maps = MapUtils.getValuesHash(bin.getClass(), bin);
        //retrofit初始化
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(baseurl)
                .client(getOkHttp())//增加OKhttp设置生效
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //支持RXjava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Flowable<String> flowable = retrofitInterface.getData(url, maps);        return flowable;
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
