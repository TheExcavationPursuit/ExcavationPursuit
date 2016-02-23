package com.ep.math;

/**
 * Created by Josh Pacana on 2/22/16.
 */
public class EpPoint {
    private double[] components;     //!< Components that make up EpPoint (x, y, z)

    /**
     * Construct an EpPoint with all components initialized to 0.0
     */
    public EpPoint()
    {
        components  = new double[3];
        components[0] = 0.0;
        components[1] = 0.0;
        components[2] = 0.0;
    }

    /**
     * Construct an EpPoint by specifying one dimensions
     * @param x a double describing the x component of a point.
     */
    public EpPoint(double x)
    {
        components = new double[3];
        components[0] = x;
        components[1] = 0.0;
        components[2] = 0.0;
    }

    /**
     * Construct an EpPoint by specifying two dimensions
     * @param x a double describing the x component of a point.
     * @param y a double describing the y component of a point.
     */
    public EpPoint(double x, double y)
    {
        components = new double[3];
        components[0] = x;
        components[1] = y;
        components[2] = 0.0;
    }

    /**
     * Construct an EpPoint by specifying three dimensions
     * @param x a double describing the x component of a point.
     * @param y a double describing the y component of a point.
     * @param z a double describing the z component of a point.
     */
    public EpPoint(double x, double y, double z)
    {
        components = new double[3];
        components[0] = x;
        components[1] = y;
        components[2] = z;
    }

    /**
     * Get the component requested at that index
     * @param component Component requested, i.e. 0 = x, 1 = y, 2 = z
     * @return The value of the component
     */
    public double get(int component)
    {
        if ((component <= this.components.length) && (component >= 0))
        {
            return components[component];

        }
        return 0.0;
    }

    /**
     * String representation of an EpPoint
     * @return String representation of an EpPoint in the form of (x, y, z)
     */
    @Override
    public String toString() {
        String retval;
        retval = String.format("(%f, %f, %f)", components[0], components[1], components[2]);
        return retval;
    }

    /**
     * Add the EpPoint u to this EpPoint
     * @param u EpPoint to add to this EpPoint
     */
    public void add(EpPoint u)
    {
        components[0] += u.get(0);
        components[1] += u.get(1);
        components[2] += u.get(2);
    }

    /**
     * Subtract the EpPoint u from this EpPoint
     * @param u EpPoint to subtract from this EpPoint
     */
    public void subtract(EpPoint u)
    {
        components[0] -= u.get(0);
        components[1] -= u.get(1);
        components[2] -= u.get(2);
    }

    /**
     * Calculate the distance between two EpPoints
     * @param u First EpPoint
     * @param v Second EpPoint
     * @return Distance between two EpPoints
     */
    public static double distanceBetweenPoints(EpPoint u, EpPoint v)
    {
        double retval;
        double xDelta = u.get(0) - v.get(0);
        double yDelta = u.get(1) - v.get(1);
        double zDelta = u.get(2) - v.get(2);
        retval = Math.sqrt(xDelta*xDelta + yDelta*yDelta + zDelta*zDelta);

        return retval;
    }



}
