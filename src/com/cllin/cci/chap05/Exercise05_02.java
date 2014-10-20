package com.cllin.cci.chap05;

import com.cllin.main.Exercise;

/*
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation.
 * If the number can not be represented accurately in binary, print “ERROR”.
 */

public class Exercise05_02 extends Exercise {
    private final String[] testSuite = {"1.5", "3.1415926", "2.8", "0.5566", "0.25", "0", "2.125"};

    private String getInBinary(String input) {
        StringBuffer buffer = new StringBuffer();
        String integerString = input.substring(0, (input.indexOf(".") >= 0)? 
                input.indexOf(".") : input.length());
        String decimalString = input.substring((input.indexOf(".") >= 0)? 
                input.indexOf(".") : input.length(), input.length());
        
        int integer = Integer.parseInt(integerString);
        double decimal = (decimalString.length() == 0)? 0 : Double.parseDouble(decimalString);
        StringBuffer integerInBinary = new StringBuffer();
        StringBuffer decimalInBinary = new StringBuffer();
        
        while (integer > 0) {
            integerInBinary.insert(0, (integer % 2 == 0)? "0" : "1");
            integer >>= 1;
        }
        
        while (decimal > 0) {
            if (decimalInBinary.length() > 32) return "ERROR";
            if (decimal == 1) {
                decimalInBinary.append(decimal);
                break;
            }
            
            decimalInBinary.append((decimal * 2 >= 1)? "1" : "0");
            decimal = (decimal * 2) % 1;
        }
        
        if (integerInBinary.length() == 0) integerInBinary.append("0");
        if (decimalInBinary.length() == 0) decimalInBinary.append("0");
        buffer.append(integerInBinary).append(".").append(decimalInBinary).toString();
        
        return buffer.toString();
    }

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (String string : testSuite) {
            String inBinary = getInBinary(string);
            
            if (inBinary.equals("ERROR")) {
                System.out.printf("%s cannot be parsed into binary representation%n", string);
                continue;
            }
            
            System.out.printf("%s is %s in binary%n", string, inBinary);
        }    
    }

    @Override
    protected boolean test() {
        return true;
    }

}
