package com.ep.test;
import com.ep.math.*;

/**
 * Created by Josh Pacana on 3/2/16.
 */
public class MatrixTest {
    public static void main(String args[]) {
        double[][] components = new double[4][4];

        components[0][0] = 1.0; components[0][1] = 2.0; components[0][2] = 3.0; components[0][3] = 4.0;
        components[1][0] = 2.0; components[1][1] = 3.0; components[1][2] = 4.0; components[1][3] = 5.0;
        components[2][0] = 3.0; components[2][1] = 4.0; components[2][2] = 5.0; components[2][3] = 6.0;
        components[3][0] = 4.0; components[3][1] = 5.0; components[3][2] = 6.0; components[3][3] = 7.0;
        EpMatrix m1 = new EpMatrix(components);

        components[0][0] = 1.0; components[0][1] = 2.0; components[0][2] = 1.0; components[0][3] = 2.0;
        components[1][0] = 1.0; components[1][1] = 2.0; components[1][2] = 1.0; components[1][3] = 2.0;
        components[2][0] = 1.0; components[2][1] = 2.0; components[2][2] = 1.0; components[2][3] = 2.0;
        components[3][0] = 1.0; components[3][1] = 2.0; components[3][2] = 1.0; components[3][3] = 2.0;
        EpMatrix m2 = new EpMatrix(components);

        EpMatrix m3 = EpMatrix.multiply(m1, m2);
        System.out.println(m3);
        System.out.println();

        m2.rightMultiply(m1);
        System.out.println(m2);
        System.out.println();


    }
}
