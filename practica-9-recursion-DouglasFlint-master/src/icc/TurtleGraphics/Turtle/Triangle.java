package icc.TurtleGraphics.Turtle;

import java.util.ArrayList;

public class Triangle {
    private Point2D a;
    private Point2D b;
    private Point2D c;

    public Triangle(Point2D a, Point2D b, Point2D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle rotate(double angle_rads, Point2D center) {
        Point2D a = this.getA().rotate(angle_rads, center);
        Point2D b = this.getB().rotate(angle_rads, center);
        Point2D c = this.getC().rotate(angle_rads, center);

        return new Triangle(a, b, c);
    }

    public Point2D getA() {
        return this.a;
    }

    public Point2D getB() {
        return this.b;
    }

    public Point2D getC() {
        return this.c;
    }

    public void setA(Point2D a) {
        this.a = a;
    }

    public void setB(Point2D b) {
        this.b = b;
    }

    public void setC(Point2D c) {
        this.c = c;
    }

    public ArrayList<Point2D> getPoints() {
        ArrayList points = new ArrayList();
        points.add(this.getA());
        points.add(this.getB());
        points.add(this.getC());

        return points;
    }

    @Override
    public String toString() {
        return String.format(
            "Triangle[%s, %s, %s]",
            this.getA().toString(),
            this.getB().toString(),
            this.getC().toString()
        );
    }
}