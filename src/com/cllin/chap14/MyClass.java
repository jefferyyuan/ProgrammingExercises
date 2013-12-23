package com.cllin.chap14;

public class MyClass{
	private static final MyClass instance = new MyClass();
	private String content = new String();
	
	private MyClass(){
		System.out.println("MyClass:\tMyClass() is called");
	}
	
	private MyClass(String content){
		System.out.println("MyClass:\tMyClass(String content) is called");
		this.content = content;
	}
	
//	SINGLETON PATTERN
	public static MyClass getSingletonInstance(){
		System.out.println("MyClass:\tgetSingletonInstance() is called");
		return instance;
	}
	
//	FACTORY PATTERN
	public static MyClass getFactoryInstance(String content){
		System.out.println("MyClass:\tgetFactoryInstance() is called");
		return new MyClass(content);
	}
	
	public String getContent(){
		return content;
	}
}
