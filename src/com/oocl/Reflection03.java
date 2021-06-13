package com.oocl;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflection03 {

    public static void main(String[] args) throws Exception {
        String classFullName = "com.oocl.Cat";
        Class<?> cls = Class.forName(classFullName);

        System.out.println(cls);
        System.out.println(cls.getClass());
        System.out.println("包名：" + cls.getPackage().getName());
        System.out.println("全类名：" + cls.getName());
        Cat cat = (Cat) cls.newInstance();
        System.out.println("Cat对象实例：" + cat);
        Field age = cls.getField("age");
        System.out.println("age:" + age.get(cat));
        age.set(cat,20);
        System.out.println("age:" + age.get(cat));

        Field[] fields = cls.getFields();
        System.out.println(fields.length);


    }

}
