package ru.stqa.sch.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistancePlus() {
        Point a1 = new Point(0, 0);
        Point a2 = new Point(0, 5);
        Assert.assertEquals(a1.distance(a1, a2), 5.0);
    }

    @Test
    public void testDistanceMinus() {
        Point a1 = new Point(0, 0);
        Point a2 = new Point(0, -5);
        Assert.assertEquals(a1.distance(a1, a2), 5.0);
    }
}
