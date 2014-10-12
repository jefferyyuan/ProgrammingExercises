package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */

public class Exercise01_01 extends Exercise {

    private final String[] testSuite = new String[] {
            null, 
            "     ", 
            "zzzzz", 
            "car", 
            "apple", 
            "banana"
            };
    private String input;
    
    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (String string : testSuite) {
            input = string;
        }    
    }

    @Override
    protected void test() {
    System.out.printf("%s has %s characters%n", input, (isAllUnique(input))? "all unique" : "duplicate");    
    }
    
    /*
     * Bit Vector Solution: Assuming characters are limited to lower-cased alphabets
     * Time Complexity = O(n)
     * Space Complexity = O(1)
     */
    private boolean isAllUnique(String string) {
        if (string == null || string.length() <= 1) return true;
        
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int value = (int) string.charAt(i) - 'a';
            
            /*
             * If exists duplicate characters, 
             * the duplicated digit will be 1 again, making checker & (1 << value) != 0 anymore
             */
            if ((checker & (1 << value)) != 0) return false;
            
            checker |= (1 << value);
        }
        
        return true;
    }
    
    /*
     * Hashtable Solution
     * Time Complexity = O(n)
     * Space Complexity = O(n)
    private boolean isAllUnique(String string) {
        if (string == null || string.length() <= 1) return true;
        
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < string.length(); i++) {
            if (set.contains(string.charAt(i))) {
                return false;
            } else {
                set.add(string.charAt(i));
            }
        }
        
        return true;
    }
    */
}
