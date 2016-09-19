package ru.stqa.sch.sandbox;

public class Point {

  public int xCoord;
  public int yCoord;

  public Point(int xCoord, int yCoord) {
    this.xCoord = xCoord;
    this.yCoord = yCoord;
  }

  public double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.xCoord - p1.xCoord), 2)  + Math.pow((p2.yCoord - p1.yCoord), 2));
  }
}
