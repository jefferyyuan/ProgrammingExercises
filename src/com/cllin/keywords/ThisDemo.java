package com.cllin.keywords;

import com.cllin.main.Exercise;

public class ThisDemo extends Exercise {

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        House h1 = new House(1, 1);
        House h2 = new House(1);
        House h3 = new House();
        
        h1.printHouse();
        h2.printHouse();
        h3.printHouse();    
    }

    @Override
    protected void test() {
    return;
    }
    
    class House {
        int nFloors;
        int nRooms;
        
        House(int nFloors, int nRooms) {
            this.nFloors = nFloors;
            this.nRooms = nRooms;
        }
        
        House(int nFloors) {
            this(nFloors, 1);
        }
        
        House() {
            this(1, 1);
        }
        
        void printHouse() {
            System.out.printf("This house has %d floors and %d rooms%n", nFloors, nRooms);
        }
    }
}
