package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 *         (-1,  0, 0, 1)
 *         (-2, -1, 1, 2)
 *         (-2,  0, 0, 2)
 * 
 * Source: http://oj.leetcode.com/problems/4sum/
 */

public class FourSum extends Exercise {

    private final int[][] testSuite = {
            {1, 0, -1, 0, -2, 2},
            {0, 0, 0, 0}, 
            {-3, -1, 0, 2, 4, 5}, 
            {2, 4, 0, 4, -3, -3},
            {5, 5, 3, 5, 1, -5, 1, -2}, 
            {-5, 5, 4, -3, 0, 0, 4, -2}, {
                -493, -482, -482, -456, -427, -405, -392, -385, -351, -269, 
                -259, -251, -235, -235, -202, -201, -194, -189, -187, -186, 
                -180, -177, -175, -156, -150, -147, -140, -122, -112, -112, 
                -105, -98, -49, -38, -35, -34, -18, 20, 52, 53, 
                57, 76, 124, 126, 128, 132, 142, 147, 157, 180, 
                207, 227, 274, 296, 311, 334, 336, 337, 339, 349, 
                354, 363, 372, 378, 383, 413, 431, 471, 474, 481, 
                492
            }, {
                -500, -481, -480, -469, -437, -423, -408, -403, -397, -381, 
                -379, -377, -353, -347, -337, -327, -313, -307, -299, -278, 
                -265, -258, -235, -227, -225, -193, -192, -177, -176, -173, 
                -170, -164, -162, -157, -147, -118, -115, -83, -64, -46, 
                -36, -35, -11, 0, 0, 33, 40, 51, 54, 74, 
                93, 101, 104, 105, 112, 112, 116, 129, 133, 146, 
                152, 157, 158, 166, 177, 183, 186, 220, 263, 273, 
                320, 328, 332, 356, 357, 363, 372, 397, 399, 420, 
                422, 429, 433, 451, 464, 484, 485, 498, 499
            }, {
                -497, -494, -484, -477, -453, -453, -444, -442, -428, -420, 
                -401, -393, -392, -381, -357, -357, -327, -323, -306, -285, 
                -284, -263, -262, -254, -243, -234, -208, -170, -166, -162, 
                -158, -136, -133, -130, -119, -114, -101, -100, -86, -66, 
                -65, -6, 1, 3, 4, 11, 69, 77, 78, 107, 
                108, 108, 121, 123, 136, 137, 151, 153, 155, 166, 
                170, 175, 179, 211, 230, 251, 255, 266, 288, 306, 
                308, 310, 314, 321, 322, 331, 333, 334, 347, 349, 
                356, 357, 360, 361, 361, 367, 375, 378, 387, 387, 
                408, 414, 421, 435, 439, 440, 441, 470, 492
            }, {
                91277418, 66271374, 38763793, 4092006, 11415077, 60468277, 1122637, 72398035, -62267800, 22082642, 
                60359529, -16540633, 92671879, -64462734, -55855043, -40899846, 88007957, -57387813, -49552230, -96789394, 
                18318594, -3246760, -44346548, -21370279, 42493875, 25185969, 83216261, -70078020, -53687927, -76072023, 
                -65863359, -61708176, -29175835, 85675811, -80575807, -92211746, 44755622, -23368379, 23619674, -749263, 
                -40707953, -68966953, 72694581, -52328726, -78618474, 40958224, -2921736, -55902268, -74278762, 63342010, 
                29076029, 58781716, 56045007, -67966567, -79405127, -45778231, -47167435, 1586413, -58822903, -51277270, 
                87348634, -86955956, -47418266, 74884315, -36952674, -29067969, -98812826, -44893101, -22516153, -34522513, 
                34091871, -79583480, 47562301, 6154068, 87601405, -48859327, -2183204, 17736781, 31189878, -23814871, 
                -35880166, 39204002, 93248899, -42067196, -49473145, -75235452, -61923200, 64824322, -88505198, 20903451, 
                -80926102, 56089387, -58094433, 37743524, -71480010, -14975982, 19473982, 47085913, -90793462, -33520678, 
                70775566, -76347995, -16091435, 94700640, 17183454, 85735982, 90399615, -86251609, -68167910, -95327478, 
                90586275, -99524469, 16999817, 27815883, -88279865, 53092631, 75125438, 44270568, -23129316, -846252, 
                -59608044, 90938699, 80923976, 3534451, 6218186, 41256179, -9165388, -11897463, 92423776, -38991231, 
                -6082654, 92275443, 74040861, 77457712, -80549965, -42515693, 69918944, -95198414, 15677446, -52451179, 
                -50111167, -23732840, 39520751, -90474508, -27860023, 65164540, 26582346, -20183515, 99018741, -2826130, 
                -28461563, -24759460, -83828963, -1739800, 71207113, 26434787, 52931083, -33111208, 38314304, -29429107, 
                -5567826, -5149750, 9582750, 85289753, 75490866, -93202942, -85974081, 7365682, -42953023, 21825824, 
                68329208, -87994788, 3460985, 18744871, -49724457, -12982362, -47800372, 39958829, -95981751, -71017359, 
                -18397211, 27941418, -34699076, 74174334, 96928957, 44328607, 49293516, -39034828, 5945763, -47046163, 
                10986423, 63478877, 30677010, -21202664, -86235407, 3164123, 8956697, -9003909, -18929014, -73824245  
            }
    };
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> solution = new  ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return solution;
        Arrays.sort(num);
        
        int length = num.length;
        
        int p = 0;
        while (p <= length - 4) {
            int q = length - 1;
            while (q > p + 2) {
                int m, n;
                m = p + 1;
                n = q - 1;
                
                while (m < n) {
                    int sum = num[p] + num[m] + num[n] + num[q];
                    if (sum > target) {
                        n--;
                        while (n > 0 && num[n + 1] == num [n]) n--;
                    } else if (sum < target) {
                        m++;
                        while (m < length && num[m - 1] == num[m]) m++;
                    } else {
                        ArrayList<Integer> s = new ArrayList<Integer>();
                        s.add(num[p]);
                        s.add(num[m]);
                        s.add(num[n]);
                        s.add(num[q]);
                        solution.add(s);
                        
                        m++;
                        n--;
                        while (n > 0 && num[n + 1] == num [n]) n--;
                        while (m < length && num[m - 1] == num[m]) m++;
                    }
                }
                
                q--;
                while (q < length - 1 && q > 0 && num[q + 1] == num [q]) q--;
            }
            p++;
            while (p > 0 && p < length && num[p - 1] == num[p]) p++;
        }
        
        return solution;
    }
    
    // Hashset will be a nice solution if we only want to know if there exist
    // such quadruplets.
    private static boolean fourSumLessTime(int[] num, int target) {
        if (num == null || num.length == 0) return false;
        
        HashMap<Integer, HashSet<HashSet<Integer>>> twoSumTable = twoSum(num);
        
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int key = target - num[i] - num[j];
                if (twoSumTable.containsKey(key) && twoSumTable.get(key).size() != 0) return true;
            }
        }
        
        return false;
    }
    
    private static HashMap<Integer, HashSet<HashSet<Integer>>> twoSum(int[] num) {
        HashMap<Integer, HashSet<HashSet<Integer>>> map = new HashMap<Integer, HashSet<HashSet<Integer>>>();
        if (num == null || num.length == 0) return map;

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int key = num[i] + num[j];
                HashSet<HashSet<Integer>> set = 
                        (map.containsKey(key))? map.get(key) : new HashSet<HashSet<Integer>>();
                        
                HashSet<Integer> s = new HashSet<Integer>();
                s.add(i);
                s.add(j);
                set.add(s);
                map.put(key, set);
            }
        }
        
        return map;
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            for (int target = 0; target <= 0; target++) {
                ArrayList<ArrayList<Integer>> combinations = fourSum(testSuite[index], target);
                
                boolean hasAuadruplet = fourSumLessTime(testSuite[index], target);
                if (combinations.size() == 0 && hasAuadruplet) {
                    System.out.println("Failed");
                    return false;
                }
                
                System.out.print("For this set of candidates: { ");
                for (int i = 0; i < testSuite[index].length; i++) System.out.printf("%d ", testSuite[index][i]);
                System.out.printf("} and %d as the target, there are %d combinations: %n", target, combinations.size());
                
                for (ArrayList<Integer> combination : combinations) {
                    int sum = 0;
                    for (int i = 0; i < combination.size(); i++) {
                        System.out.printf("%d\t", combination.get(i));
                        sum += combination.get(i);
                    }
                    if (sum != target) {
                        System.out.println("Failed");
                        return false;
                    }
                    System.out.println();
                }
                
                System.out.println("------------------------------");
            }
        }
        
        return true;
    }

}
