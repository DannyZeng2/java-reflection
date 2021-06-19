package com.oocl;

import java.lang.reflect.Constructor;

/**
 * 通过构造器创建实例
 */
public class D06_CreatInstance {

    public static void main(String[] args) throws Exception {
        Class<?> userCls = Class.forName("com.oocl.entity.User");

        //1. 通过newInstance创建实例
        Object u1 = userCls.newInstance();
        System.out.println(u1);
        //2. 通过public的有参构造器创建实例
        Constructor<?> constructor = userCls.getConstructor(String.class, int.class);
        Object u2 = constructor.newInstance("danny", 23);
        System.out.println(u2);
        //3. 通过非public的有参构造器创建实例
        Constructor<?> declaredConstructor = userCls.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true); //使用反射访问私有构造器/字段/方法
        Object u3 = declaredConstructor.newInstance("eric");
        System.out.println(u3);

    }
}
