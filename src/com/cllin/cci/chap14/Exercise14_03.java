package com.cllin.cci.chap14;

import com.cllin.main.Exercise;

public class Exercise14_03 extends Exercise {
    @SuppressWarnings("unused")
    private final int finalInteger = 1;

    private class MyClass{
        // Methods of a final class is not overrideable
        public final void printName(){
            System.out.println("printName():\tMyClass");
        }
        
        public void finalize() throws Throwable {
            super.finalize();
        }
    }
    
    private class MyChildrenClass extends MyClass {
        // This declaration is not allowed
        // public void printName(){
        // System.out.println("MyChildrenClass");
        // }
    }

    // A final class is not inheritable
    private final class MyFinalClass{
        public final void printName(){
            System.out.println("printName():\tMyFinalClass");
        }
        
        public void finalize() throws Throwable {
            super.finalize();
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        try {
            MyClass myClass = new MyClass();
            myClass.printName();
            myClass.finalize();

            MyChildrenClass myChildrenClass = new MyChildrenClass();
            myChildrenClass.printName();
            myChildrenClass.finalize();

            MyFinalClass myFinalClass = new MyFinalClass();
            myFinalClass.printName();
            myFinalClass.finalize();

            super.finalize();
        } catch (Throwable e) {
            System.out.println("An throwable is caught: " + e.getMessage());
        } finally {
            System.out.println("Finally, I'm in the finally block");
        }
    }

    @Override
    protected boolean test() {
        return true;
    }
}
