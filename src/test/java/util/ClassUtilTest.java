package util;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ClassUtilTest {

    @Test
    public void testGetClassSet() {
        Set<Class<?>> result = ClassUtil.getLoadClassSet("");
        System.out.println(result.size());
        result.forEach( cls -> System.out.println(cls));
    }
}