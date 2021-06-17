package com.oocl;

/**
 * 创建class的六种方式
 */
public class D04_CreateClass{

    public static void main(String[] args) throws Exception {
        // 1. Class.forName() 应用场景：多用于配置文件
        Class cls1 = Class.forName("com.oocl.Cat");

        // 2. 类名.class 应用场景：已知具体多类，性能最高，多用于参数传递
        Class<Cat> cls2 = Cat.class;

        // 3. 对象.getClass(), 应用场景：有对象实例
        Cat cat = new Cat();
        Class cls3 = cat.getClass();

        // 4. 通过类加载器classLoader
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class cls4 = classLoader.loadClass("com.oocl.Cat");

        // cls1,2,3,4是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        // 5. 基本数据类型.class
        Class<Integer> intClass = int.class;

        // 6. 包装类型.TYPE
        Class<Integer> integerClass = Integer.TYPE;

        System.out.println(intClass.hashCode());
        System.out.println(integerClass.hashCode());


    }
}
