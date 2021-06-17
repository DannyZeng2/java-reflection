package com.oocl;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class D01_SimpleDemo {

    public static void main(String[] args) throws Exception {

//        Cat cat = new Cat();
//        cat.say();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/cat.properties"));
        String classFullPath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println(classFullPath + "." + method);

        Class cls = Class.forName(classFullPath);
        Object cat = cls.newInstance();

        Method say = cls.getMethod(method);
        say.invoke(cat);

        Field age = cls.getField("age");
        System.out.println("Field:" + age.get(cat));

        Constructor constructor = cls.getConstructor(String.class);

        System.out.println(constructor);
    }
}
