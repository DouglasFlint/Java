package icc.TurtleGraphics.Turtle;

import java.util.Iterator;

/** 
* This class could be a subclass of Segment2D but I can not
* override the iterator method.
*/
public class ColoredSegment2D implements Iterable<ColoredSegment2D> {
    private Segment2D segment;
    private Color color;
    
    public ColoredSegment2D() {
        this.segment = new Segment2D();
        this.color = Color.BLACK;
    }
    
    public ColoredSegment2D(Point2D begin, Point2D end, Color color) {
        this.segment = new Segment2D(begin, end);
        this.color = color;
    }
    
    public ColoredSegment2D(Point2D begin, Point2D end) {
        this(begin, end, Color.BLACK);
    }

    public ColoredSegment2D(Segment2D segment, Color color) {
        this.segment = segment;
        this.color = color;
    }

    public Segment2D getSegment() {
        return this.segment;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return String.format(
            "ColoredSegment[%s, %s]",
            this.getSegment().toString(),
            this.getColor().toString()
        );
    }

    @Override
    public Iterator<ColoredSegment2D> iterator() {
        return new ColoredSegment2DIterator(this);
    }

    private class ColoredSegment2DIterator implements Iterator<ColoredSegment2D> {
        private Iterator<Segment2D> segmentIterator;
        private Color color;

        public ColoredSegment2DIterator(ColoredSegment2D segment) {
            this.segmentIterator = segment.getSegment().iterator();
            this.color = segment.getColor();
        }

        public boolean hasNext() {
            return this.segmentIterator.hasNext();
        }

        public ColoredSegment2D next() {
            return new ColoredSegment2D(this.segmentIterator.next(), this.color);
        }
    }
}