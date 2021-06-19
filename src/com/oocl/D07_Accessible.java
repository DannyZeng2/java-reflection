package com.oocl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class D07_Accessible {

    public static void main(String[] args) throws Exception {
        Class<?> userCls = Class.forName("com.oocl.entity.User");
        Object u1 = userCls.newInstance();
        // 1. 给public字段设值
        Field phone = userCls.getField("phone");
        phone.set(u1,"15625443443");
        System.out.println(u1);

        // 2. 给非public字段设值
        Field name = userCls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(u1,"tom");
        // name.set(null,"tom"); // 因为name是静态属性，所以第一个参数写成null也可以
        System.out.println(u1);

        // 3. 调用非public方法
        Method adder = userCls.getDeclaredMethod("add",int.class,int.class);
        adder.setAccessible(true);
        Object sum = adder.invoke(u1, 3, 6);
        System.out.println(sum);


    }
}
