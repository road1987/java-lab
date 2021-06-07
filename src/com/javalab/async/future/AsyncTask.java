package com.javalab.async.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncTask {
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    public Future<Integer> calculate(Integer input) {
        // 此处提交一个 callable ， 也可以提交一个runable , 区别在于 callable有返回值， runable 没有，callable
        // 可以在外部捕获exception , runable不可以，只能在内部处理
        return executor.submit(() -> {
            System.out.println("Executor: " + Thread.currentThread().getName() + "#" + "Calculating..." + input);
            Thread.sleep(1000);
            return input * input;
        });
    }
}
