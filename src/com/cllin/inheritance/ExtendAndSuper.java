package com.cllin.inheritance;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class ExtendAndSuper implements Exercise {

	@Override
	public void runExercise() {
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		
		list.add(new Vehicle());
		list.add(new Bicycle());
		list.add(new SportsCar());
		list.add(new Bus());
		
		for(Vehicle v : list){
			v.getCapacity();
		}

	}
	
	private class SuperVehicle{
		private static final String name = "super vehicle";
		private static final int capacity = 0;
	} 
	
	private class Vehicle extends SuperVehicle{
		private static final String name = "vehicle";
		private static final int capacity = 1;
		
		@SuppressWarnings("static-access")
		public void getCapacity(){
			System.out.print("A " + name + " can carry " + capacity + " people. ");
			System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
		}
	}
	
	private class Automobile extends Vehicle{
		private static final String name = "automobile";
		private static final int capacity = 4;

		@SuppressWarnings("static-access")
		public void getCapacity(){
			System.out.print("A " + name + " can carry " + capacity + " people. ");
			System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
		}
	}
	
	private class Bicycle extends Vehicle{
		private static final String name = "bicycle";
		private static final int capacity = 1;
		
		@SuppressWarnings("static-access")
		public void getCapacity(){
			System.out.print("A " + name + " can carry " + capacity + " people. ");
			System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
		}
	} 
	
	private class SportsCar extends Automobile{
		private static final String name = "sports car";
		private static final int capacity = 2;
		
		@SuppressWarnings("static-access")
		public void getCapacity(){
			System.out.print("A " + name + " can carry " + capacity + " people. ");
			System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
		}
	}
	
	private class Bus extends Automobile{
		private static final String name = "bus";
		private static final int capacity = 30;
		
		@SuppressWarnings("static-access")
		public void getCapacity(){
			System.out.print("A " + name + " can carry " + capacity + " people. ");
			System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
		}
	}

}
