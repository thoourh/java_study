package dev.thoourh.gradledemo;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    TestInterface testInterface;
    public TestComponent(
            TestInterface testInterface,
            int gradeBean
    ){
        this.testInterface = testInterface;
        System.out.println(gradeBean);
    }
    public TestComponent(TestInterface testInterface){
        this.testInterface = testInterface;
    }

    public void sayHello(){
        this.testInterface.sayHello();
    }
}
