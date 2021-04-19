package com.javalab.lambda.lesson1;

public class TypeInterfaceExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringLengthLambda strLenFuntion = a -> a.length();
        System.out.println(strLenFuntion.getLength("test"));

        printLambda(a -> a.length() + 1);

        for (int i = 0; i < 10; i++) {
            runMultipleThread(new Thread() {
                public void run() {
                    System.out.println(Math.random());
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            runMultipleThread(new Thread(() -> System.out.println((int) (Math.random() * 10))));
        }
    }

    public static void printLambda(StringLengthLambda strLenLambda) {
        System.out.println(strLenLambda.getLength("test"));
    }

    public static void runMultipleThread(Thread thread) {
        thread.run();
    }

    interface StringLengthLambda {
        int getLength(String a);
    }
}
