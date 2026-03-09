package polygon;

import java.awt.geom.*; // for Point2D.Double

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();

        myPolygon.add(new Point2D.Double(0, 0));
        myPolygon.add(new Point2D.Double(0, 170));
        myPolygon.add(new Point2D.Double(170, 170));
        myPolygon.add(new Point2D.Double(170, 0));

        // myPolygon.draw();

        System.out.println("Perimeter: " + myPolygon.perimeter());
        System.out.println("Area: " + myPolygon.area());

        TestSuite.run();
    }
}