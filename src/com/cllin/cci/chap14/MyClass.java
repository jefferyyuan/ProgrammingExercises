package com.cllin.cci.chap14;


public class MyClass{
//    ************************************************************
//    Methods below are used in Exercise 14_01
    
    private static final MyClass instance = new MyClass();
    private String content = new String();
    
    private MyClass(){
        System.out.println("MyClass:\tMyClass() is called");
    }
    
    private MyClass(String content){
        System.out.println("MyClass:\tMyClass(String content) is called");
        this.content = content;
    }
    
//    SINGLETON PATTERN
    public static MyClass getSingletonInstance(){
        System.out.println("MyClass:\tgetSingletonInstance() is called");
        return instance;
    }
    
//    FACTORY PATTERN
    public static MyClass getFactoryInstance(String content){
        System.out.println("MyClass:\tgetFactoryInstance() is called");
        return new MyClass(content);
    }
    
    public String getContent(){
        return content;
    }
    
//    ************************************************************
    
//    ************************************************************
//    Methods below are used in Exercise 14_05
    public void doSomething(){
        System.out.println("I am invoked and start doing something");
    }
    
    public void doSomethingWithInput(String input){
        System.out.println("I am invoked and start doing something with input: " + input);
    }
    
    @SuppressWarnings("unused")
    private void doSomePrivateThing(){
        System.out.println("I am invoked and start doing some private thing");
    }
    
    @MyAnnotation(name = "methodWithAnnotation")
    public void methodWithAnnotation(){
        System.out.println("\tI am a method with a cool annotation!");
    }
    
//    ************************************************************
}
