package com.pl.work4;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class HomeWork {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        int result;
        // 在这里创建一个线程或线程池，
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        };

        // 异步执行 下面方法

        result = callable.call();

//        int result = sum(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
        Thread.currentThread().stop();
        System.out.println("退出成功");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }

    public static class MyThread implements Callable {
        //定义指定线程名称的构造方法

        @Override
        public Object call() throws Exception {
            return  sum();
        }
    }
}
