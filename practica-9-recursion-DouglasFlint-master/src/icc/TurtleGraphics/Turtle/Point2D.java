package icc.TurtleGraphics.Turtle;

import java.util.Iterator;

public class Point2D {
    private double x;
    private double y;
    
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this(0.0, 0.0);
    }

    public Point2D(double scalar) {
        this(scalar, scalar);
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point2D rotate(double angle_rads, Point2D center) {
        double dx = this.getX() - center.getX();
        double dy = this.getY() - center.getY();

        double x_new = dx * Math.cos(angle_rads) - dy * Math.sin(angle_rads) + center.getX();
        double y_new = dy * Math.cos(angle_rads) + dx * Math.sin(angle_rads) + center.getY();

        return new Point2D(x_new, y_new);
    }
    
    @Override
    public Point2D clone() {
        return new Point2D(this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return String.format("Point(x=%f, y=%f)", this.getX(), this.getY());
    }

    public Point2D add(Point2D other) {
        return new Point2D(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public Point2D dotProd(Point2D other) {
        return new Point2D(this.getX() * other.getX(), this.getY() * other.getY());
    }

    public double distance2(Point2D other) {
        double dx = other.getX() - this.getX();
        double dy = other.getY() - this.getY();
        double distance2 = Math.pow(dx, 2) + Math.pow(dy, 2);

        return distance2;
    }
    
    public double radsBetweenPoints(Point2D end) {
        return Math.atan2(end.getY() - this.getY(), end.getX() - this.getX());
    }
    
    public double degreesBetweenPoints(Point2D end) {
        double angle_rads = this.radsBetweenPoints(end);
        return (angle_rads * 180) / Math.PI;
    }
    
    public static Point2D[] computeBoundingBox(Iterable<Point2D> points) {
        double x_min = Double.MAX_VALUE;
        double x_max = Double.MIN_VALUE;
        double y_min = Double.MAX_VALUE;
        double y_max = Double.MIN_VALUE;
            
        Iterator<Point2D> it = points.iterator();
        while (it.hasNext()) {
            Point2D point = it.next();
            x_min = Math.min(x_min, point.getX());
            x_max = Math.max(x_max, point.getX());

            y_min = Math.min(y_min, point.getY());
            y_max = Math.max(y_max, point.getY());
        }
        
        return new Point2D[]{new Point2D(x_min, y_min), new Point2D(x_max, y_max)};
    }
}