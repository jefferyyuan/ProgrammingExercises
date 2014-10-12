package com.cllin.cci.chap14;

import com.cllin.main.Exercise;

public class Exercise14_01 extends Exercise {

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        System.out.println("******************");
        System.out.println("SINGLETON PATTERN");
        System.out.println("******************");
        
        MyClass singleton = MyClass.getSingletonInstance();
        System.out.println("content=" + singleton.getContent());
        
        System.out.println("\n\n******************");
        System.out.println("FACTORY PATTERN");
        System.out.println("******************");
        
        MyClass factory = MyClass.getFactoryInstance("Hello World!");
        System.out.println("content=\t" + factory.getContent());
    }

    @Override
    protected void test() {
        return;
    }
}
