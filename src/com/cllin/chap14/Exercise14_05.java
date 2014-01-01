package com.cllin.chap14;

import java.lang.reflect.Method;

import com.cllin.main.Exercise;

public class Exercise14_05 implements Exercise {

	@Override
	public void runExercise() {
		MyClass myclass = MyClass.getSingletonInstance();
		Method method;
		
		System.out.println("------");
		
		try {
//			The null in invoke() indicates there are no parameters being passed to the doSomething method
			method = myclass.getClass().getMethod("doSomething", null);
			method.invoke(myclass, null);
			
//			String.class is the type of the input, while the input is passed in invoke()
			String input = "Hello World!";
			method = myclass.getClass().getMethod("doSomethingWithInput", String.class);
			method.invoke(myclass, input);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I've failed to do something");
		}
		
		System.out.println("------");
		
		try {
//			Using getDeclaredMethod() instead of getMethod() to invoke a private method
//			Calling setAccessible(true) to provide permission
			method = myclass.getClass().getDeclaredMethod("doSomePrivateThing", null);
			method.setAccessible(true);
			method.invoke(myclass, null);
		} catch (Exception e) {
			System.out.println("I've failed to do some private thing, the method is private so it cannot be called");
			e.printStackTrace();
		}
		
		System.out.println("------");

//		Execute a method only if it has specific annotation
		try {
			Method[] methods = myclass.getClass().getMethods();
			for(Method m : methods){
				MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
				if(myAnnotation != null){
					System.out.println("******************");
					System.out.println(m.getName() + "() says:");
					m.invoke(myclass, null);
					System.out.println("******************");					
				}else{
					System.out.println(m.getName() + "() does not have the annotation");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
