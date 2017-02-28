package cn.hnq.utsoft.retrofit_two.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
/**
 * Created by 胡楠启 on 2017/2/24 14:13
 * Function:
 * Desc:
 */
public class MapUtils {

    /**
     * 把请求实体类里面的参数取出来，然后放入hashmap中
     * @param clazz
     * @param object
     * @return
     */
    public static HashMap<String,String> getValuesHash(Class<?> clazz,Object object){
        HashMap<String,String> result=new HashMap<String,String>();
        if(object.equals(null))return result;
        Field[] field  = clazz.getFields();
        for(Field f : field){
            if ("serialVersionUID".equals(f.getName()))
                continue;
            try {
                Object value=f.get(object);
                 if(value!=null){
                     result.put(String.valueOf(f.getName()),String.valueOf(value));
                 }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

}
