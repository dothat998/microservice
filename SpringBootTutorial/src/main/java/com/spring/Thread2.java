package com.spring;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("Running in " + threadName);
            Thread.sleep(5000);
            System.out.println("Finish in " + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Start");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 1 : " + i);
                    //Dừng luồng trong bao nhie dây
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t1.start();
        System.out.println("End");

        //lamda
        new Thread(() -> {
            //code thread
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2 : " + i);
                //Dừng luồng trong bao nhie dây
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}