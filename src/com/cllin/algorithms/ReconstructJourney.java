package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * You visited a list of places recently, but you do not remember the order in which you visited them. 
 * You have with you the airplane tickets that you used for traveling. 
 * Each ticket contains just the start location and the end location. 
 * 
 * Reconstruct your journey.
 * 
 * Source: http://www.careercup.com/question?id=5072902038749184
 */

public class ReconstructJourney extends Exercise {

    private Ticket[][] testSuite = new Ticket[][]{
            new Ticket[]{
                    new Ticket("New York", "San Francisco"),
                    new Ticket("Chicago", "Los Angeles"),
                    new Ticket("Paris", "New York"),
                    new Ticket("London", "Paris"),
                    new Ticket("San Francisco", "Chicago")},
            new Ticket[]{
                    new Ticket("New York", "San Francisco"),
                    new Ticket("San Francisco", "New York")},
    };

    private int index;
    private ArrayList<String> route;
    
    /*
     * The code stands on two premises:
     *         1) There is only one starting point, i.e. it's not a forest
     *         2) The route is not circulated
     */
    private ArrayList<String> getRoute(Ticket[] tickets) {
        HashMap<String, String> map = new HashMap<String, String>();
        
        for (Ticket ticket : tickets) {
            if (!map.containsKey(ticket.departure)) {
                map.put(ticket.departure, ticket.destination);
            }
        }
        
        String start = "Circulated journey, can't find the starting point";
        for (String key : map.keySet()) {
            if (!map.containsValue(key)) start = key;
        }
        
        ArrayList<String> route = new ArrayList<String>();
        route.add(start);
        while (map.containsKey(start)) {
            route.add(map.get(start));
            start = map.get(start);
        }
        
        return route;
    }

    private class Ticket {
        String departure;
        String destination;
        
        Ticket(String departure, String destination) {
            this.departure = departure;
            this.destination = destination;
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }

    @Override
    protected void test() {
        for (index = 0; index < testSuite.length; index++) {
            route = getRoute(testSuite[index]);

            System.out.print("Journey = \n");
            for (String string : route) {
                System.out.printf("-> %s ", string);
            }
            System.out.println("\r\n------------------------------");
        }
    }
}
