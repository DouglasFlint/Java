package icc.TurtleGraphics.Turtle;

import icc.TurtleGraphics.gui.TurtleCanvas;

public class Main {

    public static void main(String[] args) {
        Donatelo turtle = new Donatelo();
        turtle.draw();
        
        TurtleCanvas canvas = new TurtleCanvas(turtle);
        canvas.display();
    }
}
