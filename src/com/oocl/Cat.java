package com.oocl;

public class Cat {
    public String name = "Meow";
    public int age = 23;

    public Cat() {}

    public Cat(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("hi..." + name);
    }

    public int add() {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            count ++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
