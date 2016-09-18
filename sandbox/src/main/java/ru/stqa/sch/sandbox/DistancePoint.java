package ru.stqa.sch.sandbox;

public class DistancePoint {

  public static void main(String[] args) {
    Point p1 = new Point(1,1);
    Point p2 = new Point(1,2);

    System.out.println("Расстояние между точками а(" + p1.xCoord + "," + p1.yCoord + ") и b(" + p2.xCoord + ","
            + p2.yCoord + ") равно " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.xCoord - p1.xCoord), 2)  + Math.pow((p2.yCoord - p1.yCoord), 2));
  }

}
