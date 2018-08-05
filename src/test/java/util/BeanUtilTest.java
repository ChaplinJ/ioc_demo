package util;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class BeanUtilTest {

    @Test
    public void testGetBeanMap() {
        BeanUtil beanUtil = new BeanUtil();
        Map<Class<?>, Object> beanMap = beanUtil.getBeanMap();
        for (Class cls :beanMap.keySet()) {
            System.out.println(cls);
        }
    }
}