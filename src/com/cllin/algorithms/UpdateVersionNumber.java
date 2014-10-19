package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Assume a version schema of the form: major.minor.feature.patch, where each field is a natural number.
 * 
 * When incrementing a field, less significant fields are set to zero.
 * For example, given the version 2.4.3.7, if the minor field is to be incremented, the new version will be 2.5.0.0.
 * 
 * Write a function that takes a string containing a version and an index to increment.
 * The index starts from 0, where 0 indicates the major field, 1 indicates the minor field, etc.
 * 
 * The function should pass back a string containing the new version.
 */

public class UpdateVersionNumber extends Exercise {

    private final String[] testSuite = {
            "1.0.0.0",
            "1.1.0.0",
            "1.1.1.0",
            "1.1.1.1",
            "1.0.1.0",
            "1.0.1.1",
            "wrong"
    };

    private static String updateVersionNumber(String currentVersion, int index) throws Exception {
        if (currentVersion == null || currentVersion.length() == 0) {
            throw new Exception("Invalid current version: " + currentVersion);
        }
        
        if (index < 0 || index > 3) {
            throw new Exception("Invalid index: " + index);
        }
        
        String[] fields = currentVersion.split("\\.");
        if (fields.length != 4) {
            throw new Exception("Invalid current version: " + currentVersion);
        }
        
        fields[index] = Integer.toString(Integer.parseInt(fields[index], 10) + 1, 10);
        
        StringBuffer newVersion = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            newVersion.append((i <= index)? fields[i] : "0");
            
            if (i != 3) newVersion.append(".");
        }
        
        return newVersion.toString();
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (String string : testSuite) {
            for (int i = -1; i <= 4; i++) {
                String newVersion = new String();
                try {
                    newVersion = updateVersionNumber(string, i);
                } catch (Exception e) {
                    newVersion = e.getMessage();
                }
                
                System.out.printf("Version = %s, index = %d, New Version = %s%n", string, i, newVersion);
            }
        }        
    }

    @Override
    protected void test() {
        return;
    }
}
