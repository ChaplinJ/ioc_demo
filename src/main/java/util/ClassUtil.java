package util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Created by gongchengping on 2018/07/29
 * @Description 类加载器
 */
public class ClassUtil {

    public static Class<?> loadClass(String className) {
        Class<?> cls = null;
        try {
            cls = Class.forName(className, false, getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cls;
    }
    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Set<Class<?>> getLoadClassSet(String packageName) {
        Set<Class<?>> classSet = new LinkedHashSet<>();

        try {

            Enumeration<URL> dirs = getClassLoader().getResources(packageName.replace(".", "/"));
            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if(protocol != null) {
                    if ("file".equals(protocol)) {
                        String packagePath = url.getPath().replaceAll("%20", "");
                        System.out.println(packagePath);
                        addClass(classSet, packagePath, packageName);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return classSet;
    }

    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if ((file.isFile() && file.getName().endsWith(".class")) || file.isDirectory()) {
                    return true;
                }
                return false;
            }
        });
        System.out.println(packagePath  + " "  + packageName + " " + files);

        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (StringUtils.isNotEmpty(packageName)) {
                    className = packageName + "." + className;
                }
                addClass(classSet, className);
            } else {
                String subPackagePath = fileName;
                if (StringUtils.isNotEmpty(packagePath)) {
                    subPackagePath = packagePath  + "/" + fileName;
                }

                String subPackageName = fileName;

                if (StringUtils.isNotEmpty(packageName)) {
                    subPackageName = packageName + "." + fileName;
                }
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }

    private static void addClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className);
        classSet.add(cls);
    }


}