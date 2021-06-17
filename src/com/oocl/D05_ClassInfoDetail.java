package com.oocl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * class的详细信息
 */
public class D05_ClassInfoDetail {

    public static void main(String[] args) throws Exception {
        Class personCls = Class.forName("com.oocl.Person");
        // 获取全类名
        System.out.println("1. 全类名："+personCls.getName());
        // 获取简单类名
        System.out.println("2. 简单类名："+personCls.getSimpleName());
        // 获取所有public修饰的字段，包括本类和父类
        System.out.println("3. public修饰的字段:");
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        // 获取本类所有字段
        // getModifiers 可以获取修饰符：0-默认 1-public 2-private 4-protected 8-static 16-final
        // 例如 public static final = 1+8+16 = 25
        // getType 获取字段类型
        System.out.println("4. 本类所有字段(权限修饰符-类型-字段名):");
        Field[] allFields = personCls.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println(field.getModifiers()+"-"+field.getType()+"-"+field.getName());
        }
        // 获取public修饰的方法，包括本类和父类
        System.out.println("5. public修饰的方法:");
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        // 获取所有方法
        // getReturnType 获取方法返回类型
        // getParameterType 获取参数类型
        System.out.println("6. 本类所有方法:");
        Method[] allMethods = personCls.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method.getReturnType() +"-"+ method.getName());
            System.out.println("  --参数类型--");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType);
            }
        }
        // 获取所有public修饰的本类构造器
        System.out.println("7. public修饰的构造器：");
        Constructor[] constructors = personCls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }
        // 获取本类所有构造器
        System.out.println("8. public修饰的构造器：");
        Constructor[] allConstructors = personCls.getDeclaredConstructors();
        for (Constructor constructor : allConstructors) {
            System.out.println(constructor.getName());
        }
        // 以Package形式包信息
        System.out.println("9. 包信息："+personCls.getPackage());
        // 以Class形式返回父类信息
        System.out.println("10. 父类信息：" + personCls.getSuperclass());
        // 以Class[]形式返回本类接口信息
        Class[] interfaces = personCls.getInterfaces();
        System.out.println("11. 接口信息：");
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        // Annotation[]形式返回本类注解信息
        System.out.println("11. 接口信息：");
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

@Deprecated
class Person extends Parent implements A,B{

    private String name;

    public static final String sex = "male";

    public String address;

    protected int age;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public void m1() { }

    private void m2() { }

    protected String m3(int a,String b,Object o) {
        return "";
    }
}

@SuppressWarnings({})
class Parent {
    public String phone;

    private String email;
}

interface A {}

interface B {}
