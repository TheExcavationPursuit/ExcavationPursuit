package com.ep.math;

/**
 * Created by joshpacana on 2/17/16.
 */
public class Ep_Vector {
    /**
     * Construct a vector with all components initialized to 0.0f
     */
    public Ep_Vector()
    {
        components = new Float[3];
        components[0] = 0.0f;
        components[1] = 0.0f;
        components[2] = 0.0f;
    }

    /**
     * Construct a vector by specifying one dimension
     * @param x a float describing the x component of a vector.
     */
    public Ep_Vector(Float x)
    {
        components = new Float[3];
        components[0] = x;
        components[1] = 0.0f;
        components[2] = 0.0f;
    }

    /**
     * Construct a vector by specifying two dimensions
     * @param x a float describing the x component of a vector.
     * @param y a float describing the y component of a vector.
     */
    public Ep_Vector(Float x, Float y)
    {
        components = new Float[3];
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
    public Ep_Vector(Float x, Float y, Float z)
    {
        components = new Float[3];
        components[0] = x;
        components[1] = y;
        components[2] = z;
    }

    /**
     * Get the component requested at that index
     * @param component Component requested, i.e. 0 = x, 1 = y, 2 = z
     * @return The value of the component
     */
    public Float Get(int component)
    {
        if ((component <= this.components.length) && (component >= 0))
        {
            return components[component];

        }
        return null;
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
    public Float Dot(Ep_Vector vector2)
    {
        Float retval;
        retval = (components[0] * vector2.Get(0)) + (components[1] * vector2.Get(1)) + (components[2] * vector2.Get(2));

        return retval;
    }

    /**
     * Perform the cross product on the two Ep_Vectors passed in
     * @param u First Ep_Vector used in cross product
     * @param v Second Ep_Vector used in cross product
     */
    public void Cross(Ep_Vector u, Ep_Vector v)
    {
        components[0] = (u.Get(1) * v.Get(2)) - (u.Get(2) * v.Get(1));
        components[1] = (u.Get(2) * v.Get(0)) - (u.Get(0) * v.Get(2));
        components[2] = (u.Get(0) * v.Get(1)) - (u.Get(1) * v.Get(0));
    }

    /**
     * Calculate the magnitude of the Ep_Vector
     * @return Magnitude of the Ep_Vector
     */
    public Float Magnitude()
    {
        Float retval;
        Float xSquared = components[0] * components[0];
        Float ySquared = components[1] * components[1];
        Float zSquared = components[2] * components[2];
        Double retvalD = Math.sqrt(xSquared + ySquared + zSquared);     //  Math.sqrt returns a double, so create a double and return as Float
        retval = retvalD.floatValue();
        return retval;
    }

    /**
     * Normalize the Ep_Vector, i.e. turn it into an Ep_Vector of magnitude 1
     */
    public void Normalize()
    {
        Float magnitude = Magnitude();
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
    public static Float AngleBetweenVectors(Ep_Vector u, Ep_Vector v)
    {
        Float retval;
        Float dotProduct;
        dotProduct = u.Dot(v);

        Float magnitudesMultiplied;
        magnitudesMultiplied = u.Magnitude() * v.Magnitude();

        Double cosTheta = dotProduct.doubleValue() / magnitudesMultiplied.doubleValue();

        Double theta;
        theta = Math.acos(cosTheta);
        retval = theta.floatValue();

        return retval;
    }


    private Float[] components;     //!< Components that define the vector (x, y, z)
}
