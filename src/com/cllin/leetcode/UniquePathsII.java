package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *         [
 *           [0,0,0],
 *           [0,1,0],
 *           [0,0,0]
 *         ]
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * Source: http://oj.leetcode.com/problems/unique-paths-ii/
 */

public class UniquePathsII extends Exercise {
    private final int[][][] testSuite = new int[][][]{
            {{1, 0}},
            {{0, 0}, {0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
            {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0} ,{0, 0, 1, 0}, {0, 0, 0, 0}},
            {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0} ,{0, 0, 1, 0}, {0, 0, 1, 0}}
            };
    
    private int index;
    private int result;

    @Override
    public void initialize() {
        result = 0;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        
        paths[0][0] = (obstacleGrid[0][0] == 1)? 0 : 1;
        
        for (int i = 1; i < m; i++) {
            paths[i][0] = (obstacleGrid[i][0] == 1)? 0 : paths[i - 1][0];
        }
        
        for (int j = 1; j < n; j++) {
            paths[0][j] = (obstacleGrid[0][j] == 1)? 0 : paths[0][j - 1];
        }
            
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = (obstacleGrid[i][j] == 1)? 0 : paths[i - 1][j] + paths[i][j - 1];
            }
        }
        
        return paths[m - 1][n - 1];
    }

    @Override
    public boolean test() {
        for (index = 0; index < testSuite.length; index++) {
            result = uniquePathsWithObstacles(testSuite[index]);

            int[][] grid = testSuite[index];
            int m = grid.length;
            int n = grid[0].length;

            System.out.printf("There are %d unique paths for this grid%n", result);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", grid[i][j]);
                }
                System.out.println();
            }

            System.out.println("------------");
        }
        
        return true;
    }
}
