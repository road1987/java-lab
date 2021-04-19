package com.javalab.lambda.lesson1;

public class Greeter {

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // before java8
        Greeter greeter = new Greeter();
        Greeting greeting = new HelloWorldGreeting();
        greeter.greet(greeting);

        // Anonymous class , business code write in business code blocks , such as the thread
        // creating
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("innerClass hello world");
            }
        };
        greeter.greet(innerClassGreeting);

        // function
        // reduce the implement of Greeting class
        Greeting greetingFuntion = () -> System.out.println("hello world function");
        greetingFuntion.perform();

        MyLambda myLambdaFunction = () -> System.out.println("hello world");
        MyAddFuntion addFuntion = (int a, int b) -> a + b;
        int result = addFuntion.perform(2, 0);
        System.out.println(result);
    }

}


@FunctionalInterface
interface MyLambda {
    void foo();

    default void bee() {

    };
}


@FunctionalInterface
interface MyAddFuntion {
    int perform(int a, int b);

    default int action(int a, int b) {
        return a + b;
    }
}
