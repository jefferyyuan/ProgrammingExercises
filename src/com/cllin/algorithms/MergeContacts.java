package com.cllin.algorithms;

import java.util.HashMap;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given a list of contacts, each contact has a list of email addresses.
 * Contacts are considered the same person if they share a same email address.
 * Return the clusters of contacts.
 */

public class MergeContacts extends Exercise {

    private Contact[][] testSuite = {
            new Contact[]{
                    new Contact("Bob", new String[]{"bob@gmail.com", "bob@yahoo.com"}),
                    new Contact("Jack Smith", new String[]{"jack@gmail.com"}),
                    new Contact("Bob C", new String[]{"bob@fb.com", "bob@yahoo.com"}),
                    new Contact("Jack A. Smith", new String[]{"jack@gmail.com", "jack5566@gmail.com"}),
                    new Contact("Bobby", new String[]{"bob@fb.com"}),
                    new Contact("Nate", new String[]{"nate@gmail.com"}),
                    new Contact("Bob", new String[]{"bob@hotmail.com"})
            }
    };
    
    private int index;
    private HashSet<HashSet<String>> contactClusters;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            contactClusters = mergeContacts(testSuite[index]);
            test();
        }
    }
    
    private HashSet<HashSet<String>> mergeContacts(Contact[] contacts) {
        HashSet<HashSet<String>> clusters = new HashSet<HashSet<String>>();
        HashMap<String, HashSet<String>> emailToName = new HashMap<String, HashSet<String>>();
        HashMap<String, HashSet<String>> reachables = new HashMap<String, HashSet<String>>();
        
        for (Contact contact : contacts) {
            for (String email : contact.emails) {
                HashSet<String> names = emailToName.get(email);
                if (names == null) {
                    names = new HashSet<String>();
                    names.add(contact.name);
                }
                
                emailToName.put(email, names);
            }
        }
        
        for (Contact contact : contacts) {
            HashSet<String> reachable = new HashSet<String>();
            
            for (String email : contact.emails) {
                reachable.addAll(emailToName.get(email));
            }
            reachables.put(contact.name, reachable);
        }
        
        for (Contact contact : contacts) {
            HashSet<String> cluster = new HashSet<String>();
            for (HashSet<String> c : clusters) {
                if (c.contains(contact.name)) {
                    cluster = c;
                }
            }
            
            cluster.addAll(reachables.get(contact.name));
            clusters.add(cluster);
        }
        
        return clusters;
    }
    
    protected void test() {
        System.out.print("Contacts = { ");
        for (Contact contact : testSuite[index]) {
            System.out.printf("%n    %s = { ", contact.name);
            
            for (String email : contact.emails) {
                System.out.printf("%n        %s", email);
            }
            System.out.printf("%n    }%n");
        }
        System.out.printf("}%n%n");
        
        System.out.print("Merged Contacts = { ");
        for (HashSet<String> cluster : contactClusters) {
            
            System.out.printf("%n    { ");
            for (String name : cluster) {
                System.out.printf("%n        %s", name);
            }
            System.out.printf("%n    }%n");
        }
        System.out.printf("}%n");
    }

    private class Contact {
        String name;
        String[] emails;
        
        Contact(String name, String[] emails) {
            this.name = name;
            this.emails = emails;
        }
    }
}
