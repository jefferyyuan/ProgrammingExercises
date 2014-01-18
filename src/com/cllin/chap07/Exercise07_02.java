package com.cllin.chap07;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class Exercise07_02 implements Exercise {

	@Override
	public void runExercise() {
		CallCenter center = new CallCenter();
		
		int trials = 10;
		for(int i = 0; i < trials; i++){
			center.getCall();
			System.out.println("------");
		}
	}
	
	private class CallCenter {
		private final int nFresher = 5;
		
		private ArrayList<Fresher> mFresherList;
		private TechnicalLead mTechnicalLead;
		private ProductManager mProductManager;
		
		public CallCenter(){
			mFresherList = new ArrayList<Fresher>();
			mTechnicalLead = new TechnicalLead();
			mProductManager = new ProductManager();
			
			for(int i = 0; i < nFresher; i++){
				mFresherList.add(new Fresher());
			}
		}
		
		private Employee escalatePhone(Employee employee){
			if(employee.getClass().equals(Fresher.class)){
				return mTechnicalLead;
			}else if(employee.getClass().equals(TechnicalLead.class)){
				return mProductManager;
			}
			return null;
		}
		
		public void getCall(){
			for(Fresher fresher : mFresherList){
				if(fresher.isAvaliable()){
					getCallHandler(fresher);
					return;
				}
			}
			System.out.println("Sorry, we don't have any fresher avaliable now. Please call again later, thank you!");
		}
		
		public void getCallHandler(Employee employee){
			boolean isGood = employee.takePhoneCall();
			if(!isGood){
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
				if(isAble){
					System.out.println("I'm a fresher. Your problem is solved, thank you for your call!");
				}else{
					System.out.println("I'm a fresher. Sorry that I cannot solve your problem, please allow me to transfer the call to our technical lead");
				}
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
				
				if(!isAvaliable){
					System.out.println("I'm the technical lead. Sorry that I am not free now, please allow me to transfer the call to our product manager");
					return false;
				}
				
				if(isAble){
					System.out.println("I'm the technical lead. Your problem is solved, thank you for your call!");
				}else{
					System.out.println("I'm the technical lead. Sorry that I cannot solve your problem, please allow me to transfer the call to our product manager");
				}
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