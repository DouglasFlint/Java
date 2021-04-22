package icc.TurtleGraphics.Turtle;

import java.util.ArrayList;

public class Turtle {
    public static final int MAX_SEGMENTS = 100000;
    private Point2D position;
    private Color tailColor;
    private boolean isPenUP;
    private double angle_rad;
    private final ArrayList<TurtleSegment> turtleSegments;

    public Turtle() {
        this.position = new Point2D(0.0, 0.0);
        this.angle_rad = 0.0;
        this.isPenUP = true;
        this.tailColor = Color.BLACK;
        this.turtleSegments = new ArrayList<TurtleSegment>();
    }
    
    public Point2D getPosition() {
        return this.position;
    }
    
    public Color getTailColor() {
        return this.tailColor;
    }
    
    public void forward(double distance) {
        if (this.turtleSegments.size() > Turtle.MAX_SEGMENTS) {
            throw new RuntimeException("Donatelo no puede manejar tantas instrucciones.");
        }

        double x_d = Math.sin(this.angle_rad) * distance;
        double y_d = Math.cos(this.angle_rad) * distance;
        Point2D end = new Point2D(this.getPosition().getX() + x_d, this.getPosition().getY() + y_d);
        
        ColoredSegment2D segment;
        if (!this.isPenUP) {
            segment = new ColoredSegment2D(this.getPosition(), end, this.getTailColor());
        } else {
            segment = new ColoredSegment2D(this.getPosition(), end, Color.TRANSPARENT);
        }

        this.turtleSegments.add(new TurtleSegment(this.angle_rad, segment));
        this.position = end;
    }
     
    public void turn(double angle) {
        this.angle_rad += (Math.PI * (angle % 360)) / 180;
    }
     
    public void penUp() {
        this.isPenUP = true;
    }
    
    public void penDown() {
        this.isPenUP = false;
    }
    
    public void setTailColor(Color color) {
        this.tailColor = color;
    }
    
    public ArrayList<TurtleSegment> getTurtleSegments() {
        ColoredSegment2D lastTurn = new ColoredSegment2D(this.getPosition(), this.getPosition(), Color.TRANSPARENT);
        this.turtleSegments.add(new TurtleSegment(this.angle_rad, lastTurn));
        
        return this.turtleSegments;
    }

    public static Triangle getTurtleTriangle(Point2D center) {
        Point2D a = new Point2D(center.getX() - 1, center.getY() - 1);
        Point2D b = new Point2D(center.getX() + 1, center.getY() - 1);
        Point2D c = new Point2D(center.getX(), center.getY() + 1);

        return new Triangle(a, b, c);
    }

    public static Square getTurtleSquare(Point2D center) {
        Point2D a = new Point2D(center.getX() - 3.8, center.getY() + 0.2);
        Point2D b = new Point2D(center.getX() + 6.2, center.getY() + 0.2);
        Point2D c = new Point2D(center.getX() + 6.2, center.getY() + 10.2);
        Point2D d = new Point2D(center.getX() - 3.8, center.getY() + 10.2);

        return new Square(a, b, c, d);
    }
}