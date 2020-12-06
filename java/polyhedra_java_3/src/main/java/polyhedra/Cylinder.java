package polyhedra;

/**
 * Polyhedron representing a cylinder.
 */
public class Cylinder
    implements Polyhedron, TraitFromDimensions
{
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
        // Something is missing here...
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
        this.radius = r;
        this.height = h;
    }

    @Override
    public String getType()
    {
        return "Cylinder";
    }

    @Override
    public BoundingBox getBoundingBox()
    {
        // null is not a bounding box...

        final double h = this.getHeight();
        final double d = this.getDiameter();

        return new BoundingBox(d, d, h);
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
        this.radius = r;
    }

    /**
     * Update the height.
     *
     * @param h deisred height
     */
    public void setHeight(double h)
    {
        this.height = h;
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
        // null is not a Cylinder...
        return new Cylinder(this.radius, this.height);
    }

    @Override
    public void scale(double scalingFactor)
    {
        // Where is the scaling logic?
        radius *= scalingFactor;
        height *= scalingFactor;

    }

    @Override
    public boolean equals(Object rhs)
    {
        // This is a placeholder...
        return false;
    }

    @Override
    public int hashCode()
    {
        // This is a placeholder...
        return -1;
    }

    @Override
    public String toString()
    {
        return Polyhedron.super.toStringHelper()
             + "Radius: " + this.radius + " "
             + "Height: " + this.height;
    }

    // TraitFromDimensions Overrides
    @Override
    public int numberOfDimensions()
    {
        // Zero... I think the Cylinder has more than zero dimensions.
        return 0;
    }

    @Override
    public void fromDimensions(double[] theDims)
    {
        // Something is missing...
    }
}
