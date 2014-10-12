package com.cllin.thread;

import com.cllin.main.Exercise;

public class Thread101 extends Exercise {
    
    private class MyRunnable implements Runnable {
        private static final int SLEEP_TIME = 500;
        private int id = 0;
        
        public MyRunnable(int i){
            id = i;
        }
        
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("#" + id + " MyRunnable is going to sleep");
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    @Override
    protected void initialize() {
	return;
    }

    @Override
    protected void runExercise() {
        try {
            System.out.println("Starting running a new thread, calling join() this time");
            Thread thread1 = new Thread(new MyRunnable(1));
            thread1.join();
            thread1.run();
            System.out.println("MyRunnable is finally finished");
            
            System.out.println("Starting running a new thread, without calling join() to wait for the runnable");
            Thread thread2 = new Thread(new MyRunnable(2));
            thread2.start();
            System.out.println("MyRunnable is finally finished...really?");
        } catch (Exception e) {
            e.printStackTrace();
        }	
    }

    @Override
    protected void test() {
	return;
    }

}
