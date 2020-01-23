package com.ruoyi.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;

public class MapObjectUtil {
	/**
     * 将对象转成TreeMap,属性名为key,属性值为value
     * @param object    对象
     * @return
     * @throws IllegalAccessException
     */
    public static TreeMap<String, Object> objToMap(Object object) throws IllegalAccessException {

        Class clazz = object.getClass();
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();

        while ( null != clazz.getSuperclass() ) {
            Field[] declaredFields1 = clazz.getDeclaredFields();

            for (Field field : declaredFields1) {
                String name = field.getName();

                // 获取原来的访问控制权限
                boolean accessFlag = field.isAccessible();
                // 修改访问控制权限
                field.setAccessible(true);
                Object value = field.get(object);
                // 恢复访问控制权限
                field.setAccessible(accessFlag);

                if (null != value && StringUtils.isNotBlank(value.toString())) {
                    //如果是List,将List转换为json字符串
                    if (value instanceof List) {
                        value = JSON.toJSONString(value);
                    }
                    treeMap.put(name, value);
                }
            }

            clazz = clazz.getSuperclass();
        }
        return treeMap;
    }
}
