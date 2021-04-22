package icc.TurtleGraphics.Turtle;

public class TurtleSegment {
    private double angle_rad;
    private ColoredSegment2D segment;

    public TurtleSegment(double angle_rad, ColoredSegment2D segment) {
        this.angle_rad = angle_rad;
        this.segment = segment;
    }

    public ColoredSegment2D getSegment() {
        return this.segment;
    }

    public double getAngleRad() {
        return this.angle_rad;
    }

    @Override
    public String toString() {
        return String.format(
            "TurtleSegment[angle=%f, %s]",
            this.getAngleRad(),
            this.getSegment().toString()
        );
    }
}