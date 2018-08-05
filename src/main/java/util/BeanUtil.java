package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Created by gongchengping on 2018/07/29
 * @Description 加载所有带注解的类
 */
public class BeanUtil {

    private static Map<Class<?>, Object> beanMap = new HashMap<>();

    static {
        Set<Class<?>> classSet = AnnotationClassLoad.getClassSet();

        for (Class<?> cls:classSet) {
            Object object = ReflectionUtil.newInstance(cls);
            beanMap.put(cls, object);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return  beanMap;
    }


}
