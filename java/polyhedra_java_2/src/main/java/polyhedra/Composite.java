package polyhedra;

import java.util.Scanner;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Composite Polyhedron. Polyhedra of this type are built from
 * other Polyhedra. This,in theory, can include Composite objects
 * composed of other (nested) Composite objects.
 *
 * @author Paul Rodriguez
 */
public class Composite extends Polyhedron
    implements Cloneable, Iterable<Polyhedron>
{

    /**
     * Collection of polyhedra of which this composite polyhedron is composed.
     */
    private List<Polyhedron> allPolyhedra;

    /**
     * Default Composite Constructor.
     */
    public Composite()
    {
        super("Composite");

        allPolyhedra = new Vector<Polyhedron>();
    }

    /**
     * Composite Copy Constructor.
     *
     * @param src source Composite object to copy
     *
     * @TODO complete this function
     */
    public Composite(Composite src)
    {
        super("Composite");

        allPolyhedra = new Vector<Polyhedron>();
        int origPolyHedrasize = src.allPolyhedra.size();

        for(int i = 0; i < origPolyHedrasize; i++)
        {
            Polyhedron poly = src.allPolyhedra.get(i).clone();
            this.allPolyhedra.add(poly);
        }
        this.boundingBox.merge(src.getBoundingBox());
    }

    /**
     * Add a cloned copy of a Polyhedron to the `Composite` collection.
     *
     * @param toAdd is cloned and the copy is added
     *
     * @TODO complete this function
     */
    public void add(Polyhedron toAdd)
    {
        Polyhedron poly = toAdd.clone();
        this.allPolyhedra.add(poly);
        this.boundingBox.merge(poly.getBoundingBox());
    }

    /**
     * Read all component polyhedra.
     *
     * @param scanner input source
     *
     * @TODO complete this function
     */
    public void read(Scanner scanner)
    {
        int numPolyhedra;
        numPolyhedra = scanner.nextInt();
        
        for(int i = 0; i < numPolyhedra; i++)
        {
            Polyhedron poly = PolyhedronFactory.createAndRead(scanner);
            this.allPolyhedra.add(poly);

            this.boundingBox.merge(poly.getBoundingBox());
        }
        
    }

    /**
     * Iterate through all sub-polyhedra, scale them, and update all
     * bounding boxes.
     *
     * @param scalingFactor scaling factor
     *
     * @TODO complete this function
     */
    public void scale(double scalingFactor)
    {
        for(Iterator<Polyhedron> iter = this.allPolyhedra.iterator(); iter.hasNext(); )
        {
            Polyhedron poly = iter.next();
            poly.scale(scalingFactor);
        }
        this.boundingBox.scale(scalingFactor);
    }

    /**
     * Retrive the number of Polyhedra.
     *
     * @return the number of Polyhedra that comprise this Composite object
     */
    public int size()
    {
        return allPolyhedra.size();
    }

    @Override
    public Iterator<Polyhedron> iterator()
    {
        return allPolyhedra.iterator();
    }

    @Override
    public Polyhedron clone()
    {
        return new Composite(this);
    }

    /**
     * "Print" all polyhedra.
     *
     * @return String containing all component _Polyhedra_ objects
     *
     * @TODO complete this function
     */
    @Override
    public String toString()
    {
        StringBuilder bld = new StringBuilder();

        bld.append(super.toString());
        bld.append(this.size() + " polyhedra" + "\n");

        for(Polyhedron poly : this.allPolyhedra)
        {
            bld.append("  " + poly.toString() + "\n");
        }
        
        return bld.toString();
    }
}

