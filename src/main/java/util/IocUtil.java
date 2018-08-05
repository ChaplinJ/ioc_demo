package util;

import annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Created by gongchengping on 2018/07/29
 * @Description 对注解进行di依赖注入
 */
public class IocUtil {

    private static final Map<Class<?>, Object> beanMap;

    static {

        beanMap = BeanUtil.getBeanMap();
        for(Map.Entry<Class<?>, Object> entry:beanMap.entrySet()) {
            Class<?> cls = entry.getKey();
            Object object = entry.getValue();
            Field[] fields = cls.getDeclaredFields();
            for (Field field: fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Class<?> fieldClass = field.getType();//getType() 是一个.class 而getClass返回的是field，运行时类型属性
                    Object fieldObject = beanMap.get(fieldClass);
                    //通过反射设置field的值
                    if (fieldObject != null) {
                        ReflectionUtil.setField(object, field, fieldObject);
                    }
                }
            }

        }
    }


    public static Map<Class<?>, Object> getIOCMap() {
        return beanMap;
    }

    public static Object getBean(Class<?> cls) {
        return beanMap.get(cls);
    }

}
