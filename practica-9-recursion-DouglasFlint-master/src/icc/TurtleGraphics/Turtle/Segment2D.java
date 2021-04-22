package icc.TurtleGraphics.Turtle;

import java.util.Iterator;

public class Segment2D implements Iterable<Segment2D> {
    private Point2D begin;
    private Point2D end;
    
    public Segment2D() {
        this.begin = new Point2D();
        this.end = new Point2D();
    }
    
    public Segment2D(Point2D begin, Point2D end) {
        this.begin = begin;
        this.end = end;
    }

    public Point2D getBegin() {
        return this.begin;
    }

    public Point2D getEnd() {
        return this.end;
    }
    
    public void setBegin(Point2D begin) {
        this.begin = begin;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Segment[begin=%s, end=%s]",
            this.getBegin().toString(),
            this.getEnd().toString()
        );
    }

    @Override
    public Iterator<Segment2D> iterator() {
        return new Segment2DIterator(this);
    }
    
    private class Segment2DIterator implements Iterator<Segment2D> {
        public static final int N_STEPS = 20;
        private final double angle_rad;
        private final double step_distance;
        private final Point2D begin;
        private Point2D current;
        private int current_step;

        public Segment2DIterator(Segment2D segment) {
            this.begin = segment.getBegin().clone();
            this.current = this.begin.clone();
            this.angle_rad = Math.PI / 2 - this.current.radsBetweenPoints(segment.getEnd());

            double magnitud = Math.sqrt(this.begin.distance2(segment.getEnd()));
            this.step_distance = magnitud / Segment2DIterator.N_STEPS;
            this.current_step = 0;
        }

        @Override
        public boolean hasNext() {
            return this.current_step < Segment2DIterator.N_STEPS;
        }

        @Override
        public Segment2D next() {
            if (this.hasNext()) {
                this.current_step++;
                double x_d = Math.sin(this.angle_rad) * step_distance;
                double y_d = Math.cos(this.angle_rad) * step_distance;

                this.current = this.current.add(new Point2D(x_d, y_d));
            }

            return new Segment2D(this.begin, this.current);
        }
    }
}
