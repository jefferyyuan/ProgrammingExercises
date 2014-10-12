package com.cllin.cci.chap10;

import com.cllin.main.Exercise;

public class Exercise10_03 extends Exercise {
    private final Line[] lines = {new Line(1, 1, false), new Line(1, 3, false), 
            new Line(2, 1, false), new Line(7, 9, false), new Line(-12, 10, false), 
            new Line(0, 10, true), new Line(0, 3, true), new Line(0, 10, true)};
    
    private class Line {
        private int slope = 0;
        private int yIntercept = 0;
        private boolean isVertical = false;
        
        public Line(int slope, int yIntercept, boolean isVertical) {
            this.slope = slope;
            this.yIntercept = yIntercept;
            this.isVertical = isVertical;
        }
        
        public boolean isIntersecting(Line line) {
            if (this.isVertical && line.isVertical) {
                return this.yIntercept == line.yIntercept;
            } else if (this.isVertical != line.isVertical) {
                return true;
            }
            
            if (this.slope != line.slope) {
                return true;
            } else if (this.yIntercept == line.yIntercept) {
                return true;
            }
            
            return false;
        }
        
        public String getLine() {
            if (this.isVertical) {
                return "x=" + yIntercept;
            } else {
                return "y=" + slope + "x + " + yIntercept;
            }
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (Line line : lines) {
            for (Line anotherLine : lines) {
                if (line.isIntersecting(anotherLine)) {
                    System.out.println(line.getLine() + " and "
                            + anotherLine.getLine() + " will not intersect");
                }
            }
        }
    }

    @Override
    protected void test() {
        return;
    }
}
