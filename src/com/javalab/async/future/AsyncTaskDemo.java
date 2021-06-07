package com.javalab.async.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncTaskDemo {



    public static void main(String[] args) {
        AsyncTask asyncTask = new AsyncTask();
        Future<Integer> future1 = asyncTask.calculate(1);
        Future<Integer> future2 = asyncTask.calculate(2);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println("Executor: " + Thread.currentThread().getName() + "#" + "Calculating...");
            sleep(300);
        }

        try {
            Integer result1 = future1.get();
            Integer result2 = future2.get();
            System.out.println(result1 + "#" + result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
