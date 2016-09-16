package ru.stqa.sch.sandbox;

/**
 * Created by aponomar on 16-Sep-16.
 */
public class Point {

    public static void main(String[] args) {
        System.out.println(distance(1, 1, 1, 2));
    }

    public static double distance(int xCoordA, int yCoordA, int xCoordB, int yCoordB) {
        return Math.sqrt(Math.pow((xCoordB - xCoordA), 2)  + Math.pow((yCoordB - yCoordA), 2));
    }
}
