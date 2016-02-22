package com.ep.test;
import com.ep.math.*;

/**
 * Created by Josh Pacana on 2/17/16.
 */
public class VectorTest {
    public static void main(String args[]) {
        EpVector v1 = new EpVector(3.0f, -3.0f, 1.0f);
        EpVector v2 = new EpVector(4.0f, 9.0f, 2.0f);
        EpVector v3 = new EpVector();
        v3.cross(v1, v2);

        System.out.println("v1");
        System.out.println(v1);
        System.out.println();

        System.out.println("v2");
        System.out.println(v2);
        System.out.println();

        System.out.println("v3 = v1 x v2");
        System.out.println(v3);
        System.out.println();

        System.out.println("v3.magnitude()");
        System.out.println(v3.magnitude());
        System.out.println();

        System.out.println("v3.normalize()");
        v3.normalize();
        System.out.println(v3);
        System.out.println();

        System.out.println("v3.magnitude()");
        System.out.println(v3.magnitude());
        System.out.println();

        System.out.println("Angle between v1 and v2 in radians");
        System.out.println(EpVector.angleBetweenVectors(v1, v2));
        System.out.println();

        System.out.println("v1 - v2");
        v1.subtract(v2);
        System.out.println(v1);
        System.out.println();

        System.out.println("v1 + v2");
        v1.add(v2);
        System.out.println(v1);
        System.out.println();

        System.out.println("v1.negate()");
        v1.negate();
        System.out.println(v1);
        System.out.println();

        System.out.println("v1.multiply(5)");
        v1.multiply(5);
        System.out.println(v1);
        System.out.println();

        System.out.println("v1.divide(5)");
        v1.divide(5);
        System.out.println(v1);
        System.out.println();

    }
}
