package com.cllin.leetcode;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Source: http://oj.leetcode.com/problems/simplify-path/
 */

public class SimplifyPath extends Exercise {

    private final String[] testSuite = {
            "/home/",
            "/a/./b/../../c/",
            "/..", 
            "/", 
            "///", 
            "/.", 
            "/...",
            "/home/foo/.ssh/../.ssh2/authorized_keys/"
    };
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private String simplifyPath(String path) {
        if (path == null || path.length() == 0) return new String();

        int i = 0;
        LinkedList<String> directories = new LinkedList<String>();
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }
            
            int index = path.indexOf("/", i);
            String d = (index == -1)? path.substring(i) : path.substring(i, index);
            i = (index == -1)? path.length() : index + 1;
            
            if (d.equals("..")) {
                if (!directories.isEmpty()) directories.removeLast();
            } else if (!d.equals(".")) {
                directories.add(d);
            }
        }
        
        StringBuffer buffer = new StringBuffer();
        while (!directories.isEmpty()) {
            buffer.append("/").append(directories.poll());
        }
        
        if (buffer.length() == 0) return "/";
        if (buffer.charAt(buffer.length() - 1) == '/') return buffer.substring(0, buffer.length() - 1);
        
        return buffer.toString();
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            String simplifiedPath = simplifyPath(testSuite[index]);

            System.out.printf(
                    "The simplified path of {%s} is {%s}%n", testSuite[index], simplifiedPath);
        }

        return true;
    }

}
