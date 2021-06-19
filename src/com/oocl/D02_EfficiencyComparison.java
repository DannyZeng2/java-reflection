package com.oocl;

import com.oocl.entity.Cat;

import java.lang.reflect.Method;

/**
 * 传统方式和反射调用方法的效率比较
 */
public class D02_EfficiencyComparison {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();

    }

    // 传统方式调用效率
    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.add();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1:" + (end - start) + "ms");
    }

    // 反射方式调用效率
    public static void m2() throws Exception {
        Class cls = Class.forName("com.oocl.entity.Cat");
        Object cat = cls.newInstance();
        Method add = cls.getMethod("add");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            add.invoke(cat);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2:" + (end - start) + "ms");
    }

    // 反射方式调用优化，关闭访问检查
    public static void m3() throws Exception {
        Class cls = Class.forName("com.oocl.entity.Cat");
        Object cat = cls.newInstance();
        Method add = cls.getMethod("add");
        add.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            add.invoke(cat);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2:" + (end - start) + "ms");
    }
}
