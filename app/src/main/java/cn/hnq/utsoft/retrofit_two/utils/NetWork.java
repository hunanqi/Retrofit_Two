package cn.hnq.utsoft.retrofit_two.utils;

import com.google.gson.Gson;

import cn.hnq.utsoft.retrofit_two.Entity.DataEntity;
import cn.hnq.utsoft.retrofit_two.Entity.UserEntity;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 胡楠启 on 2017/2/24.
 * Function：
 * Desc： 网络请求管理类
 */
public class NetWork {
    //查询手机号码的归属地
    public static Flowable<DataEntity> query(UserEntity user) {
        final Flowable<String> flowable = RetrofitUtils.getFlowable("http://apis.juhe.cn/", "mobile/get", user);
        //将类型转化为需要的类型
        Flowable<DataEntity> map = flowable.map(new Function<String, DataEntity>() {
            @Override
            public DataEntity apply(String string) throws Exception {
                Gson gson=new Gson();
                DataEntity dataEntity = gson.fromJson(string, DataEntity.class);
                return dataEntity;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return map;
    }
}
