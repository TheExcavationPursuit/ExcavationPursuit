package com.ep.test;
import com.ep.math.*;

/**
 * Created by Josh Pacana on 2/22/16.
 */
public class PointTest {
    public static void main(String args[]) {
        EpPoint point1 = new EpPoint(1.0, 2.0, 3.0);
        EpPoint point2 = new EpPoint(2.0, 4.0, 8.0);
        EpPoint point3 = new EpPoint(-2.0, 2.0, -4.0);

        System.out.println("point1");
        System.out.println(point1);
        System.out.println();

        System.out.println("Distance: point2 -> point3");
        System.out.println(EpPoint.distanceBetweenPoints(point2, point3));
        System.out.println();
    }
}
