package com.cllin.cci.chap07;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). 
 * There can be multiple employees, but only one TL or PM. 
 * 
 * An incoming telephone call must be allocated to a fresher who is free. 
 * If a fresher can��t handle the call, he or she must escalate the call to technical lead. 
 * If the TL is not free or not able to handle it, then the call should be escalated to PM. 
 * 
 * Design the classes and data structures for this problem. Implement a method getCallHandler().
 */

public class Exercise07_02 implements Exercise {

	@Override
	public void run() {
		CallCenter center = new CallCenter();
		
		int trials = 10;
		for (int i = 0; i < trials; i++) {
			center.getCall();
			System.out.println("------------------------------");
		}
	}
	
	private class CallCenter {
		private final int nFresher = 5;
		
		private ArrayList<Fresher> mFresherList;
		private TechnicalLead mTechnicalLead;
		private ProductManager mProductManager;
		
		public CallCenter() {
			mFresherList = new ArrayList<Fresher>();
			mTechnicalLead = new TechnicalLead();
			mProductManager = new ProductManager();
			
			for(int i = 0; i < nFresher; i++){
				mFresherList.add(new Fresher());
			}
		}
		
		private Employee escalatePhone(Employee employee) {
			if (employee.getClass().equals(Fresher.class)) {
				return mTechnicalLead;
			} else if(employee.getClass().equals(TechnicalLead.class)) {
				return mProductManager;
			} else {
				return null;
			}
		}
		
		public void getCall() {
			for (Fresher fresher : mFresherList) {
				if (fresher.isAvaliable()) {
					getCallHandler(fresher);
					return;
				}
			}
			System.out.println("Sorry, we don't have any fresher avaliable now. Please call again later, thank you!");
		}
		
		public void getCallHandler(Employee employee) {
			boolean isGood = employee.takePhoneCall();
			if (!isGood) {
				getCallHandler(escalatePhone(employee));
			}
		}
		
		private class Fresher implements Employee {
			@Override
			public boolean isAvaliable() {
				return getRandomBoolean();
			}
			
			@Override
			public boolean isAbleToHandle() {
				return getRandomBoolean();
			}
			
			@Override
			public boolean takePhoneCall() {
				boolean isAble = isAbleToHandle();
				System.out.printf("%s%n", (isAble)? "I'm a fresher. Your problem is solved, thank you for your call!" : "I'm a fresher. Sorry that I cannot solve your problem, please allow me to transfer the call to our technical lead");
				return isAble;
			}

			@Override
			public boolean getRandomBoolean() {
				return Math.random() < 0.3;
			}
		}
		
		private class TechnicalLead implements Employee {
			@Override
			public boolean isAvaliable() {
				return getRandomBoolean();
			}
			
			@Override
			public boolean isAbleToHandle() {
				return getRandomBoolean();
			}
			
			@Override
			public boolean takePhoneCall() {
				boolean isAvaliable = isAvaliable();
				boolean isAble = isAbleToHandle();
				
				if (!isAvaliable) {
					System.out.println("I'm the technical lead. Sorry that I am not free now, please allow me to transfer the call to our product manager");
					return false;
				}
				
				System.out.printf("%s%n", (isAble)? "I'm the technical lead. Your problem is solved, thank you for your call!" : "I'm the technical lead. Sorry that I cannot solve your problem, please allow me to transfer the call to our product manager");
				return isAble;
			}

			@Override
			public boolean getRandomBoolean() {
				return Math.random() < 0.5;
			}
		}
		
		private class ProductManager implements Employee {
			@Override
			public boolean isAvaliable() {
				return true;
			}
			
			@Override
			public boolean isAbleToHandle() {
				return true;
			}
			
			@Override
			public boolean takePhoneCall() {
				boolean isAvaliable = isAvaliable();
				boolean isAble = isAbleToHandle();
				
				System.out.println("I'm the product manager. Your problem is solved, thank you for your call!");
				
				return isAvaliable && isAble;
			}

			@Override
			public boolean getRandomBoolean() {
				return true;
			}
		}
	}
	
	
	private interface Employee {
		boolean isAvaliable();
		boolean isAbleToHandle();
		boolean takePhoneCall();
		boolean getRandomBoolean();
	}
}
