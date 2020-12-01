package polyhedra;

import java.util.Scanner;

/**
 * Polyhedron representing a cylinder.
 */
public class Cylinder extends Polyhedron {
    /**
     * Height of the cylinder. It must be > 0.
     */
    private double height;

    /**
     * Radius of the cylinder. It must be > 0.
     */
    private double radius;

    /**
     * Default Constructor - set the radius and height to 1.
     */
    public Cylinder()
    {
        this(1, 1);
    }

    /**
     * Construct a cylinder with specified height and radius.
     *
     * @param r desired radius
     * @param h deisred height
     */
    public Cylinder(double r, double h)
    {
        super("Cylinder");

        this.radius = r;
        this.height = h;

        double d = this.getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, height);
    }

    /**
     * Retrieve the radius.
     *
     * @return current radius
     */
    public double getRadius()
    {
        return this.radius;
    }

    /**
     * Retrieve the height.
     *
     * @return current height
     */
    public double getHeight()
    {
        return this.height;
    }

    /**
     * Update the radius.
     *
     * @param r desired radius
     */
    public void setRadius(double r)
    {
        // Implement this function
        radius = r;
        double h = getHeight();
        double d = getDiameter();
        boundingBox.setUpperRightVertex(d, d, h);
    }

    /**
     * Update the height.
     *
     * @param h deisred height
     */
    public void setHeight(double h)
    {
        // Implement this function
        height = h;
        double d = getDiameter();
        boundingBox.setUpperRightVertex(d, d, h);
    }

    /**
     * Compute diameter.
     *
     * @return diameter
     */
    public final double getDiameter()
    {
        return this.radius * 2;
    }

    @Override
    public Polyhedron clone()
    {
        
        return new Cylinder(this.radius, this.height); // remove this line
        // Implement this function
    }

    @Override
    public void read(Scanner scanner)
    {
        // Implement this function

        height = scanner.nextDouble();
        radius = scanner.nextDouble();

        double d = getDiameter();
        boundingBox.setUpperRightVertex(d, d, height);

    }

    @Override
    public void scale(double scalingFactor)
    {
        // Implement this function
        radius *= scalingFactor;
        height *= scalingFactor;

        boundingBox.scale(scalingFactor);
    }

    @Override
    public String toString()
    {
        return super.toString()
              + "Radius: " + this.radius
              + " " 
              + "Height: " + this.height;
    }
}
