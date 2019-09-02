package com.frankie.demo.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: Yao Frankie
 * @date: 2019/9/2 22:17
 */
public class ObjectPoolFactory {

    private Map<String, Object> objectPool = new HashMap();

    public void initPool(String fileName)
            throws ClassNotFoundException, NoSuchMethodException,
                   InvocationTargetException, InstantiationException, IllegalAccessException {
        try (FileInputStream file = new FileInputStream(fileName))
        {
            Properties props = new Properties();
            props.load(file);
            for (String name: props.stringPropertyNames()){
                objectPool.put(name, createObject(props.getProperty(name)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object createObject(String className)
            throws ClassNotFoundException, NoSuchMethodException,
                   IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Class.forName(className);
        return aClass.getConstructor().newInstance();
    }

    public Object getObject(String name){
        return objectPool.get(name);
    }

    public void setNameUsingReflection(String key, String realName)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object obj = objectPool.get(key);
        Method setNameMethod = obj.getClass().getMethod("setName", String.class);
        setNameMethod.invoke(obj, realName);
    }
}
