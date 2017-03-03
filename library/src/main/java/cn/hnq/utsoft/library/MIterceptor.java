package cn.hnq.utsoft.library;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：retrofit拦截器，可以为每一个请求添加相同的请求头
 * Desc：
 */

public class MIterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        Log.i("http",proceed.body().string());
        return proceed;
    }
}
