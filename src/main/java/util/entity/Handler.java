package util.entity;

import java.lang.reflect.Method;

/**
 * @author Created by gongchengping on 2018/08/01
 * @Description
 */
public class Handler {
    private Object object;
    private Method method;


    public Handler(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }
}
