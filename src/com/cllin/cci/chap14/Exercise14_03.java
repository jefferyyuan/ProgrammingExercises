package com.cllin.cci.chap14;

import com.cllin.main.Exercise;

public class Exercise14_03 extends Exercise {
//    A FINAL OBJECT IS UNCHANGABLE
    @SuppressWarnings("unused")
    private final int finalInteger = 1;
    
    @Override
    public void run() {
//        THIS OPERATION IS NOT ALLOWED
//        finalInteger++;
        
        try{
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
        }catch(Throwable e){
            System.out.println("An throwable is caught: " + e.getMessage());
        }finally{
            System.out.println("Finally, I'm in the finally block");
        }
    }

    private class MyClass{
//        A FINAL CLASS IS NOT OVERRIDEABLE
        public final void printName(){
            System.out.println("printName():\tMyClass");
        }
        
        public void finalize() throws Throwable {
            super.finalize();
        }
    }
    
    private class MyChildrenClass extends MyClass{
//        THIS OPERATION IS NOT ALLOWED
//        public void printName(){
//            System.out.println("MyChildrenClass");
//        }        
    }
    
//    A FINAL CLASS IS NOT INHERITABLE
    private final class MyFinalClass{
        public final void printName(){
            System.out.println("printName():\tMyFinalClass");
        }
        
        public void finalize() throws Throwable {
            super.finalize();
        }
    }
    
//    THIS OPERATION IS NOT ALLOWED
//    private class MyChildrenOfFinalClass extends MyFinalClass{}
}
