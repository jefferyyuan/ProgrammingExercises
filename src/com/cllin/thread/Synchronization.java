package com.cllin.thread;

import com.cllin.main.Exercise;

public class Synchronization implements Exercise {
	private CounterWithoutSynchronization counterWithoutSynchronization;

	@Override
	public void runExercise() {
		counterWithoutSynchronization = new CounterWithoutSynchronization();
		
		try {
			Thread thread = new Thread(new WithoutSyncronization());
			thread.run();
			
			Thread.sleep(1000);

			System.out.println("------");
			System.out.println("count = " + counterWithoutSynchronization.getCount() + ", which might not be expected");
			System.out.println("Such unpredictable behavior is due to THREAD INTERFERENCE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class WithoutSyncronization implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("In the beginning, count = " + counterWithoutSynchronization.getCount());
				MyThread threadA = new MyThread(true);
				MyThread threadB = new MyThread(false);
				
				threadA.start();
				threadB.start();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private class CounterWithoutSynchronization {
		private int count = 0;
		
//		Things change after adding the keyword "synchronized" to each method,  
//		public synchronized void increment(){
//			count++;
//		}
//		
//		public synchronized void decrement(){
//			count--;
//		}
		
		public void increment(){
			count++;
		}
		
		public void decrement(){
			count--;
		}
		
		public int getCount(){
			return count;
		}
	}
	
	private class MyThread extends Thread {
		private boolean flag;
		
		public MyThread(boolean flag){
			this.flag = flag;
		}
		
		@Override
		public void run(){
			for(int i = 0; i < 1000; i++){
				if(flag){
					counterWithoutSynchronization.increment();
				}else{
					counterWithoutSynchronization.decrement();
				}
			}
		}
	}
}
