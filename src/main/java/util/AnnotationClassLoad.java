package util;

import annotation.Controller;
import annotation.Service;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Created by gongchengping on 2018/07/29
 * @Description 获取带类注解的class
 */
public class AnnotationClassLoad {

    private static Set<Class<?>> classSet;

    static {
        String packageName = ""; //扫描的包名
        classSet = ClassUtil.getLoadClassSet(packageName);
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> resultSet = new LinkedHashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Controller.class)) {
                resultSet.add(cls);
            }
        }
        return resultSet;
    }

    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> resultSet = new LinkedHashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Service.class)) {
                resultSet.add(cls);
            }
        }
        return resultSet;
    }

    public static Set<Class<?>> getClassSet() {
        Set<Class<?>> resultSet = new LinkedHashSet<>();
        resultSet.addAll(getControllerClassSet());
        resultSet.addAll(getServiceClassSet());
        return resultSet;

    }
}
