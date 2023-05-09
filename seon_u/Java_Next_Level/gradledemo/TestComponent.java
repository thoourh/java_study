package dev.sw.gradledemo;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private TestInterface testInterface;

    public TestComponent(
            TestInterface testInterface,
            int gradeBean
    ){

        this.testInterface = testInterface;
        System.out.println(gradeBean);
    }

    public void sayHello(){
        this.testInterface.sayHello();
    }
}
