package util;

import org.junit.Before;
import org.junit.Test;
import util.entity.Handler;

import java.util.Map;

import static org.junit.Assert.*;

public class ControllerHelperTest {

    Map<String, Handler> handlerMap;

    @Before
    public void init() {
        handlerMap  = ControllerHelper.getHandlerMap();
    }

    @Test
    public void getHandlerMapNotNull() {
        assertNotNull(handlerMap);
    }

    @Test
    public void printHandlerMap() {
        for (String key : handlerMap.keySet()) {
            System.out.println(key);
            Handler handler = handlerMap.get(key);

            ReflectionUtil.invokeMethod(handler.getObject(), handler.getMethod(), null);
        }
        assertNotNull(handlerMap);
    }

    @Test
    public void tesRequest() {
        Handler handler = handlerMap.get("/");

        ReflectionUtil.invokeMethod(handler.getObject(), handler.getMethod(), null);

        handler = handlerMap.get("/sayHello");

        ReflectionUtil.invokeMethod(handler.getObject(), handler.getMethod(), null);

        assertNotNull(handlerMap);
    }
}