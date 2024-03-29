package com.cllin.inheritance;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class ExtendAndSuper extends Exercise {
    
    class SuperVehicle {
        protected static final String name = "super vehicle";
        protected static final int capacity = 0;
    } 
    
    class Vehicle extends SuperVehicle {
        protected static final String name = "vehicle";
        protected static final int capacity = 1;
        
        @SuppressWarnings("static-access")
        private void getCapacity() {
            System.out.print("A " + name + " can carry " + capacity + " people. ");
            System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
        }
    }
    
    class Automobile extends Vehicle {
        protected static final String name = "automobile";
        protected static final int capacity = 4;

        @SuppressWarnings("static-access")
        public void getCapacity() {
            System.out.print("A " + name + " can carry " + capacity + " people. ");
            System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
        }
    }
    
    private class Bicycle extends Vehicle {
        private static final String name = "bicycle";
        private static final int capacity = 1;
        
        @SuppressWarnings({ "static-access", "unused" })
        public void getCapacity() {
            System.out.print("A " + name + " can carry " + capacity + " people. ");
            System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
        }
    } 
    
    private class SportsCar extends Automobile {
        private static final String name = "sports car";
        private static final int capacity = 2;
        
        @SuppressWarnings("static-access")
        public void getCapacity() {
            System.out.print("A " + name + " can carry " + capacity + " people. ");
            System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
        }
    }
    
    private class Bus extends Automobile {
        private static final String name = "bus";
        private static final int capacity = 30;
        
        @SuppressWarnings("static-access")
        public void getCapacity() {
            System.out.print("A " + name + " can carry " + capacity + " people. ");
            System.out.println("Its parent, a " + super.name + " can carry " + super.capacity + " people. ");
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
        
        list.add(new Vehicle());
        list.add(new Bicycle());
        list.add(new SportsCar());
        list.add(new Bus());
        
        for (Vehicle v : list) {
            v.getCapacity();
        }    
    }

    @Override
    protected boolean test() {
        return true;
    }

}
