package com.cllin.main;

public abstract class Exercise {
    
    public final void run() {
        initialize();
        runExercise();
        test();
    }
    
    protected abstract void initialize();
    protected abstract void runExercise();
    protected abstract void test();
}
