package com.cllin.cci.chap06;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * There are one hundred closed lockers in a hallway.
 * A man begins by opening all one hundred lockers. Next, he closes every second locker.
 * Then he goes to every third locker and closes it if it is open or opens it if it is closed
 * (e.g., he toggles every third locker). 
 * 
 * After his one hundredth pass in the hallway, in which he toggles only locker number one hundred, how many lockers are open?
 */

public class Exercise06_06 extends Exercise {
    private LinkedList<Integer> mOpenedLockers;
    
    private static LinkedList<Integer> findOpenedLocker(int nLockers){
        LinkedList<Integer> openedLocker = new LinkedList<Integer>();
        
        for (int i = 1; i <= nLockers; i++) {
//          Using i <= nLockers / i instead of i * i <= nLockers to avoid overflow
            if (i * i <= nLockers / i) openedLocker.add(i);
        }
        
        return openedLocker;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        mOpenedLockers = findOpenedLocker(100);
    }

    @Override
    protected void test() {
        for (int n : mOpenedLockers) {
            System.out.printf("The %dth locker is open%n", n);
        }
    }

}
