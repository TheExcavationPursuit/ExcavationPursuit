package com.ep.math;

/**
 * Created by Josh Pacana on 2/17/16.
 */
public class EpVector {

    private float[] components;     //!< Components that define the vector (x, y, z)

    /**
     * Construct a vector with all components initialized to 0.0f
     */
    public EpVector()
    {
        components = new float[3];
        components[0] = 0.0f;
        components[1] = 0.0f;
        components[2] = 0.0f;
    }

    /**
     * Construct a vector by specifying one dimension
     * @param x a float describing the x component of a vector.
     */
    public EpVector(float x)
    {
        components = new float[3];
        components[0] = x;
        components[1] = 0.0f;
        components[2] = 0.0f;
    }

    /**
     * Construct a vector by specifying two dimensions
     * @param x a float describing the x component of a vector.
     * @param y a float describing the y component of a vector.
     */
    public EpVector(float x, float y)
    {
        components = new float[3];
        components[0] = x;
        components[1] = y;
        components[2] = 0.0f;
    }

    /**
     * Construct a vector by specifying three dimensions
     * @param x a float describing the x component of a vector.
     * @param y a float describing the y component of a vector.
     * @param z a float describing the z component of a vector.
     */
    public EpVector(float x, float y, float z)
    {
        components = new float[3];
        components[0] = x;
        components[1] = y;
        components[2] = z;
    }

    /**
     * Get the component requested at that index
     * @param component Component requested, i.e. 0 = x, 1 = y, 2 = z
     * @return The value of the component
     */
    public float get(int component)
    {
        if ((component <= this.components.length) && (component >= 0))
        {
            return components[component];

        }
        return 0.0f;
    }

    /**
     * String representation of an EpVector
     * @return String representation of an EpVector in the form of [x, y, z]
     */
    @Override
    public String toString() {
        String retval;
        retval = String.format("[%f, %f, %f]", components[0], components[1], components[2]);
        return retval;
    }

    /**
     * Add the EpVector u to this EpVector
     * @param u EpVector to add to this EpVector
     */
    public void add(EpVector u)
    {
        components[0] += u.get(0);
        components[1] += u.get(1);
        components[2] += u.get(2);
    }

    /**
     * Subtract the EpVector u from this EpVector
     * @param u EpVector to subtract from this EpVector
     */
    public void subtract(EpVector u)
    {
        components[0] -= u.get(0);
        components[1] -= u.get(1);
        components[2] -= u.get(2);
    }

    /**
     * Multiply the vector by the scalar
     * @param multiplier Scalar to multiply the vector by
     */
    public void multiply(float multiplier)
    {
        components[0] *= multiplier;
        components[1] *= multiplier;
        components[2] *= multiplier;
    }

    /**
     * Divide the vector by the scalar
     * @param divisor Scalar to divide the vector by
     */
    public void divide(float divisor)
    {
        components[0] /= divisor;
        components[1] /= divisor;
        components[2] /= divisor;
    }

    /**
     * Perform the dot product operation using this EpVector and the parameter EpVector
     * @param vector2 The EpVector to perform the dot product with
     * @return The dot product of these EpVectors
     */
    public float dot(EpVector vector2)
    {
        float retval;
        retval = (components[0] * vector2.get(0)) + (components[1] * vector2.get(1)) + (components[2] * vector2.get(2));

        return retval;
    }

    /**
     * Perform the cross product on the two EpVectors passed in
     * @param u First EpVector used in cross product
     * @param v Second EpVector used in cross product
     */
    public void cross(EpVector u, EpVector v)
    {
        components[0] = (u.get(1) * v.get(2)) - (u.get(2) * v.get(1));
        components[1] = (u.get(2) * v.get(0)) - (u.get(0) * v.get(2));
        components[2] = (u.get(0) * v.get(1)) - (u.get(1) * v.get(0));
    }

    /**
     * Calculate the magnitude of the EpVector
     * @return Magnitude of the EpVector
     */
    public float magnitude()
    {
        float retval;
        float xSquared = components[0] * components[0];
        float ySquared = components[1] * components[1];
        float zSquared = components[2] * components[2];
        double retvalD = Math.sqrt(xSquared + ySquared + zSquared);     //  Math.sqrt returns a double, so create a double and return as Float
        retval = (float)retvalD;
        return retval;
    }

    /**
     * Normalize the EpVector, i.e. turn it into an EpVector of magnitude 1
     */
    public void normalize()
    {
        float magnitude = magnitude();
        components[0] /= magnitude;
        components[1] /= magnitude;
        components[2] /= magnitude;
    }

    /**
     * Negate the EpVector, i.e. same magnitude, but opposite direction
     */
    public void negate()
    {
        components[0] *= -1;
        components[1] *= -1;
        components[2] *= -1;
    }

    /**
     * Calculate the angle, in radians, between two EpVectors
     * @param u First EpVector
     * @param v Second EpVector
     * @return Angle, in radians, between the two EpVectors
     */
    public static float angleBetweenVectors(EpVector u, EpVector v)
    {
        float retval;
        float dotProduct;
        dotProduct = u.dot(v);

        float magnitudesMultiplied;
        magnitudesMultiplied = u.magnitude() * v.magnitude();

        double cosTheta = dotProduct / magnitudesMultiplied;

        double theta;
        theta = Math.acos(cosTheta);
        retval = (float)theta;

        return retval;
    }

}
