package util;

import controller.HelloController;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class IocUtilTest {
    private Map<Class<?>, Object> iocMap;

    @Before
    public void init() {
        iocMap = IocUtil.getIOCMap();
    }

    @Test
    public void testIOCMap() {
        Object object = iocMap.get(HelloController.class);
        assertNotNull(object);
    }

}