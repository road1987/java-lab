package com.javalab.async.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("future 1 , run in thread : " + threadName);
            return "Hello ";
        });

        future.thenAccept(res -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("future 1 , thenAccept run in thread : " + threadName);
            System.out.println("future 1 , thenAccept result: " + res);
        });

        future.thenAcceptAsync(res -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("future 1 , thenAcceptAsync run in thread : " + threadName);
            System.out.println("future 1 , thenAcceptAsync result: " + res);
        });

        future.thenApply(res -> {
            return res.toUpperCase();
        }).thenAccept(res -> {
            System.out.println(res);
        });

        future.thenAccept(res -> {
            System.out.println(res);
        });

    }

    public static void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
