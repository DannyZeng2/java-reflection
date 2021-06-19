package com.oocl.entity;

import com.oocl.service.A;
import com.oocl.service.B;

@Deprecated
class Person extends Parent implements A, B {

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