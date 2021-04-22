package icc.TurtleGraphics.Turtle;

import java.applet.Applet;
import java.awt.*;
// import java.util.ArrayList;
import java.util.Iterator;

public class MainApplet extends Applet {
  public static final int WIDTH = 600;
  public static final int HEIGHT = 600;

  public void paint(Graphics g) {
      Donatelo turtle = new Donatelo();
      turtle.draw();

      Iterator<TurtleSegment> states = turtle.getTurtleSegments().iterator();
      while(states.hasNext()) {
        TurtleSegment state = states.next();
        ColoredSegment2D coloredSegment = state.getSegment();
        Segment2D segment = coloredSegment.getSegment();
        Color color = coloredSegment.getColor();
        Point2D begin = segment.getBegin();
        Point2D end = segment.getEnd();

        java.awt.Color awtColor = new java.awt.Color(
          (float) color.getRed(),
          (float) color.getGreen(),
          (float) color.getBlue(),
          (float) color.getAlpha()
        );

        g.setColor(awtColor);
        g.drawLine(
          (int) begin.getX() + MainApplet.WIDTH / 2,
          (int) begin.getY() + MainApplet.HEIGHT / 2,
          (int) end.getX() + MainApplet.WIDTH / 2,
          (int) end.getY() + MainApplet.HEIGHT /2
        );
      }
  }
}