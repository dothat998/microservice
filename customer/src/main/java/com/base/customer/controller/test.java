package com.base.customer.controller;

public class test extends Thread{

    private Thread t;
    private String threadName;

    test(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    public static void main(String args[]) {
        System.out.println("Main thread running... ");

        test T1 = new test("Thread-1-HR-Database");
        T1.start();

        test T2 = new test("Thread-2-Send-Email");
        T2.start();

        System.out.println("==> Main thread stopped!!! ");
    }
}
