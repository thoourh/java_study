package dev.rang.gradledemo;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
@Component
public class TestImplementation implements TestInterface{
    @Override
    public void sayHello(){
        System.out.println("hello, i'm a bean");
    }
}
