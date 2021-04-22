package icc.TurtleGraphics.Turtle;

public class Square {
    private Point2D a;
    private Point2D b;
    private Point2D c;
    private Point2D d;

    public Square(Point2D a, Point2D b, Point2D c, Point2D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point2D getD() {
        return this.d;
    }

    public Square rotate(double angle_rads, Point2D center) {
        Point2D a = this.getA().rotate(angle_rads, center);
        Point2D b = this.getB().rotate(angle_rads, center);
        Point2D c = this.getC().rotate(angle_rads, center);
        Point2D d = this.getD().rotate(angle_rads, center);

        return new Square(a, b, c, d);
    }
}