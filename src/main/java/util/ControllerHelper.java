package util;

import annotation.RequestMapping;
import org.apache.commons.lang3.ArrayUtils;
import util.entity.Handler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Created by gongchengping on 2018/08/01
 * @Description
 */
public class ControllerHelper {

    private static Map<String, Handler> handlerMap = new HashMap<>();

    static {
        Set<Class<?>> controllerSet = AnnotationClassLoad.getControllerClassSet();

        if (controllerSet != null) {
            for (Class<?> cls : controllerSet) {
                Method[] methods = cls.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                           RequestMapping requestMapping =  method.getAnnotation(RequestMapping.class);
                           String key = requestMapping.value();
                           Handler handler = new Handler(IocUtil.getBean(cls), method);
                           handlerMap.put(key, handler);
                        }
                    }
                }
            }
        }
    }

    public static Map<String, Handler> getHandlerMap() {
        return handlerMap;
    }

}
