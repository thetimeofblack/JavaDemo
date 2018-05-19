package javaClassChina.eason.practice4.exp4;

import javaClassChina.eason.toolkit.SquareEquation;

public class SunRise {
    public static void main(String[] args) {
        SquareEquation equation = new SquareEquation(4,5,1);
        equation.getRoots();
        equation.setCoefficient(-3,4,5);
        equation.getRoots();
    }
}
