package com.cllin.cci.chap09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.cllin.main.Exercise;

/*
 * A circus is designing a tower routine consisting of people standing atop one another��s shoulders. 
 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
 * 
 * Given the heights and weights of each person in the circus, 
 * write a method to compute the largest possible number of people in such a tower.
 * 
 * EXAMPLE:
 *     Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 *     Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 */

public class Exercise09_07 extends Exercise {
    private final int CIRCUS_SIZE = 10;
    
    private Person[] circus;
    private ArrayList<Person> longestTower;
    
    @Override
    public void run() {
        initialize();
        longestTower = getLongestTower(circus);
        
        System.out.println("The longest tower is:");
        for (Person person : longestTower) {
            System.out.printf("(%d, %d) ", person.height, person.weight);
        }
    }
    
    private static ArrayList<Person> getLongestTower(Person[] circus) {
        Person[] sortByHeight = Arrays.copyOf(circus, circus.length);
        Person[] sortByWeight = Arrays.copyOf(circus, circus.length);
        
        Arrays.sort(sortByHeight, new HeightComparator());
        Arrays.sort(sortByWeight, new WeightComparator());
        
        ArrayList<Person> byHeight = new ArrayList<Person>();
        ArrayList<Person> byWeight = new ArrayList<Person>();
        for (int i = 0; i < circus.length; i++) {
            if (i == 0) {
                byHeight.add(sortByHeight[i]);
                byWeight.add(sortByWeight[i]);
                continue;
            }
            
            if (sortByHeight[i].weight > byHeight.get(byHeight.size() - 1).weight) {
                byHeight.add(sortByHeight[i]);
            }
            
            if (sortByWeight[i].height > byWeight.get(byWeight.size() - 1).height) {
                byWeight.add(sortByWeight[i]);
            }
        }
        
        return (byHeight.size() > byWeight.size())? byHeight : byWeight;
    }
    
    private static class HeightComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return Integer.compare(a.height, b.height);
        }
    }
    
    private static class WeightComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return Integer.compare(a.weight, b.weight);
        }
    }
    
    protected void initialize() {
        circus = new Person[CIRCUS_SIZE];
        for (int i = 0; i < CIRCUS_SIZE; i++) {
            circus[i] = new Person();
        }
    }

    private class Person {
        private static final int MAXIMUM_HEIGHT = 200;
        private static final int MINIMUM_HEIGHT = 160;
        private static final int MAXIMUM_WEIGHT = 100;
        private static final int MINIMUM_WEIGHT = 60;
        
        private int height;
        private int weight;
        
        public Person() {
            height = (int)(Math.random() * (MAXIMUM_HEIGHT - MINIMUM_HEIGHT)) + MINIMUM_HEIGHT;
            weight = (int)(Math.random() * (MAXIMUM_WEIGHT - MINIMUM_WEIGHT)) + MINIMUM_WEIGHT;
        }
    }
}
