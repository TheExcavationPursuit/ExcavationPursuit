package com.ep.math;

/**
 * Created by Josh Pacana on 3/2/16.
 */
public class EpMatrix {
    private double[][] components;              //!< Components that define the matrix (4x4)

    /**
     * Construct an EpMatrix as the identity matrix
     */
    public EpMatrix()
    {
        //  Row 1
        components = new double[4][4];
        components[0][0] = 1.0;
        components[0][1] = 0.0;
        components[0][2] = 0.0;
        components[0][3] = 0.0;

        //  Row 2
        components[1][0] = 0.0;
        components[1][1] = 1.0;
        components[1][2] = 0.0;
        components[1][3] = 0.0;

        //  Row 3
        components[2][0] = 0.0;
        components[2][1] = 0.0;
        components[2][2] = 1.0;
        components[2][3] = 0.0;

        //  Row 4
        components[3][0] = 0.0;
        components[3][1] = 0.0;
        components[3][2] = 0.0;
        components[3][3] = 1.0;
    }

    /**
     * Construct an EpMatrix, which is a 4x4 matrix, by passing in a 2D array
     * @param values 2D Array of doubles that must be 4x4
     */
    public EpMatrix(double values[][])
    {
        components = new double[4][4];
        if ((values.length == 4) && (values[0].length == 4))
        {
            for (int row = 0; row < 4; row++)
            {
                for (int col = 0; col < 4; col++)
                {
                    components[row][col] = values[row][col];
                }
            }
        }
        //else
        //{
            //  Need to create a basic identity matrix
        //}
    }

    /**
     * String representation of an EpMatrix
     * @return String representation of an EpMatrix in the form of 4 rows of [i, j, k, l]
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 4; row++)
        {
            sb.append("[");
            for (int col = 0; col < 4; col++)
            {
                sb.append(components[row][col]);
                if (col != 3)
                {
                    sb.append(", ");
                }
            }
            sb.append("]");
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    /**
     * Get the values at the row and column specified. Must be within the range of a 4x4 matrix.
     * @param row Row to get value from
     * @param col Column to get value from
     * @return Double value at row and column intersection
     */
    public double get(int row, int col)
    {
        double retval = 0.0;
        if ((row < components.length) && (col < components[0].length))
        {
            retval = components[row][col];
        }
        return retval;
    }

    /**
     * Get the values at the row and column specified. Must be within the range of a 4x4 matrix.
     * @param row Row to set value of
     * @param col Column to set value of
     * @param value Value to set row and column intersection to
     */
    public void set(int row, int col, double value)
    {
        if ((row < components.length) && (col < components[0].length))
        {
            components[row][col] = value;
        }
    }


    /**
     * Multiply Two EpMatrix together and return their result
     * @param leftMatrix First EpMatrix
     * @param rightMatrix Second EpMatrix
     * @return An EpMatrix with the result of the multiplication
     */
    public static EpMatrix multiply(EpMatrix leftMatrix, EpMatrix rightMatrix)
    {
        EpMatrix returnMatrix = new EpMatrix();
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                returnMatrix.components[row][col] = (   (leftMatrix.components[row][0] * rightMatrix.components[0][col]) +
                                                        (leftMatrix.components[row][1] * rightMatrix.components[1][col]) +
                                                        (leftMatrix.components[row][2] * rightMatrix.components[2][col]) +
                                                        (leftMatrix.components[row][3] * rightMatrix.components[3][col]) );
            }
        }
        return returnMatrix;
    }

    /**
     * Multiply two EpMatrix together, applying the passed in EpMatrix to the left
     * @param leftMatrix EpMatrix that will be multiplied to the left of this EpMatrix
     */
    public void leftMultiply(EpMatrix leftMatrix)
    {
        EpMatrix resultMatrix = EpMatrix.multiply(leftMatrix, this);
        this.components = resultMatrix.components;
    }

    /**
     * Multiply two EpMatrix together, applying the passed in EpMatrix to the right
     * @param rightMatrix EpMatrix that will be multiplied to the right of this EpMatrix
     */
    public void rightMultiply(EpMatrix rightMatrix)
    {
        EpMatrix resultMatrix = EpMatrix.multiply(this, rightMatrix);
        this.components = resultMatrix.components;
    }

}
