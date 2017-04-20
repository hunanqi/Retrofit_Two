package cn.hnq.utsoft.retrofit_two.utils;

import java.util.Map;

import cn.hnq.utsoft.library.RetrofitUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：
 * Desc： 网络请求管理类
 */
public class NetWork {
    //查询手机号码的归属地
    public static <T> Observable<T> query(Map<String, String> map, Class<T> tClass) {
        Observable<T> observable = RetrofitUtils.getObservable("http://apis.juhe.cn/", "mobile/get",
                map, tClass).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread());
        return observable;
    }
}
