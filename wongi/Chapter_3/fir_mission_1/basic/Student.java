package dev.thoourh.basic;

import javax.xml.namespace.QName;

public class Student extends AbstractPerson {
    public Student(String name, int age){
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(String.format("My name is %s, and I am a student.", getName()));
    }
}
