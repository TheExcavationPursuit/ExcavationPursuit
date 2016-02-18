package com.ep.math;

/**
 * Created by Josh Pacana on 2/17/16.
 */
public class Ep_Vector {
    /**
     * Construct a vector with all components initialized to 0.0f
     */
    public Ep_Vector()
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
    public Ep_Vector(float x)
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
    public Ep_Vector(float x, float y)
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
    public Ep_Vector(float x, float y, float z)
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
     * String representation of an Ep_Vector
     * @return String representation of an Ep_Vector in the form of [x, y, z]
     */
    @Override
    public String toString() {
        String retval;
        retval = String.format("[%f, %f, %f]", components[0], components[1], components[2]);
        return retval;
    }

    /**
     * Perform the dot product operation using this Ep_Vector and the parameter Ep_Vector
     * @param vector2 The Ep_Vector to perform the dot product with
     * @return The dot product of these Ep_Vectors
     */
    public float dot(Ep_Vector vector2)
    {
        float retval;
        retval = (components[0] * vector2.get(0)) + (components[1] * vector2.get(1)) + (components[2] * vector2.get(2));

        return retval;
    }

    /**
     * Perform the cross product on the two Ep_Vectors passed in
     * @param u First Ep_Vector used in cross product
     * @param v Second Ep_Vector used in cross product
     */
    public void cross(Ep_Vector u, Ep_Vector v)
    {
        components[0] = (u.get(1) * v.get(2)) - (u.get(2) * v.get(1));
        components[1] = (u.get(2) * v.get(0)) - (u.get(0) * v.get(2));
        components[2] = (u.get(0) * v.get(1)) - (u.get(1) * v.get(0));
    }

    /**
     * Calculate the magnitude of the Ep_Vector
     * @return Magnitude of the Ep_Vector
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
     * Normalize the Ep_Vector, i.e. turn it into an Ep_Vector of magnitude 1
     */
    public void normalize()
    {
        float magnitude = magnitude();
        components[0] /= magnitude;
        components[1] /= magnitude;
        components[2] /= magnitude;
    }

    /**
     * Calculate the angle, in radians, between two Ep_Vectors
     * @param u First Ep_Vector
     * @param v Second Ep_Vector
     * @return Angle, in radians, between the two Ep_Vectors
     */
    public static float angleBetweenVectors(Ep_Vector u, Ep_Vector v)
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

    private float[] components;     //!< Components that define the vector (x, y, z)
}
