package com.javalab.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class Counter0 {
    int count;

    // does synnhronized will cause performance issue
    public void increase() {
        count++; // count = count + 1; //it's not a atomic operation , thread not safe
    }
}


class Counter1 {
    int count;

    // does synnhronized will cause performance issue
    public synchronized void increase() {
        count++; // count = count + 1; //it's not a atomic operation , thread not safe
    }
}


class Counter2 {
    AtomicInteger count = new AtomicInteger();

    public void increase() {
        count.incrementAndGet(); // atomic operation
    }
}



public class ThreadDemo {


    public static void main(String[] args) throws InterruptedException {

        Counter2 counter = new Counter2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.count);
    }

}
