package com.cllin.thread;

import com.cllin.main.Exercise;

/***************************************************************************************
*    Title: Java Tutorials Code Sample Deadlock.java
*    Author: Oracle
*    Date: 2013/12/14
*    Code version: N/A
*    Availability: http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/essential/concurrency/examples/Deadlock.java
*
***************************************************************************************/

public class Deadlock extends Exercise {

    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        
//      The deadlock will not happen if the method is not synchronized
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();

        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }

    @Override
    protected void test() {
        return;
    }
}
