package com.cllin.main;

public abstract class Exercise {
    
    public final void run() {
        System.out.println("Running:" + this.getClass().getName());

        try {
            initialize();
            runExercise();
            test();
        } catch (Exception e) {
            System.out.println("Exception while running " + this.getClass().getName());
            e.printStackTrace();
        }
    }
    
    protected abstract void initialize();
    protected abstract void runExercise();
    protected abstract boolean test();
}
