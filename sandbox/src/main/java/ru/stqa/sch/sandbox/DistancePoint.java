package ru.stqa.sch.sandbox;

public class DistancePoint {

  public static void main(String[] args) {
    Point p1 = new Point(1,1);
    Point p2 = new Point(1,2);
    Point p3 = new Point(2,2);


    System.out.println("Расстояние между точками а(" + p1.xCoord + "," + p1.yCoord + ") и b(" + p2.xCoord + ","
            + p2.yCoord + ") равно " + p1.distance(p1,p2));

    System.out.println("Расстояние между точками а(" + p1.xCoord + "," + p1.yCoord + ") и b(" + p3.xCoord + ","
            + p3.yCoord + ") равно " + p1.distance(p1,p3));

  }

}
