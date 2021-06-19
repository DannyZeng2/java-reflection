package com.oocl.entity;

public class User {
    private static String name;

    private int age;

    public String phone;

    public User() {
    }

    private User(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int add(int a, int b) {
        return a + b;
    }

    public String hello(String name) {
        return "I am" + name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
