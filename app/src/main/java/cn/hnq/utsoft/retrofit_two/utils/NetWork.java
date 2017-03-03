package cn.hnq.utsoft.retrofit_two.utils;

import cn.hnq.utsoft.library.RetrofitUtils;
import cn.hnq.utsoft.retrofit_two.Entity.UserEntity;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：
 * Desc： 网络请求管理类
 */
public class NetWork {
    //查询手机号码的归属地
    public static <T> Flowable<T> query(UserEntity user,Class<T> tClass) {
        Flowable<T> flowable1 = RetrofitUtils.getFlowable("http://apis.juhe.cn/", "mobile/get", user, tClass);
        Flowable<T> tFlowable = flowable1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return tFlowable;
}
}
