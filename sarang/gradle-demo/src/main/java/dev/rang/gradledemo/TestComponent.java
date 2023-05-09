package dev.rang.gradledemo;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private TestInterface testInterface;
    public TestComponent(TestInterface testInterface) {
        this.testInterface = testInterface;
    }


    public void sayHello(){
        this.testInterface.sayHello();
    }
}
