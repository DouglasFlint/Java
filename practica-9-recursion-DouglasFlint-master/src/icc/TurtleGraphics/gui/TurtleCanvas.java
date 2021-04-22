package icc.TurtleGraphics.gui;

import java.io.IOException;
import java.util.Iterator;
import icc.TurtleGraphics.Turtle.*;
import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TurtleCanvas {
    // Whether to enable VSync in hardware.
    public static final boolean VSYNC = true;
    // Width and Height of our window
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    // Whether to use fullscreen mode
    public static final boolean FULLSCREEN = false;

    protected boolean isRunning;
    private final ArrayList<TurtleSegment> turtleSegments;
    private int currentTurtleSegmentIndex;
    private Iterator<ColoredSegment2D> currentTurtleSegmentIterator;
    private Point2D[] boundingBox;
    private float scale;
    private float translate_x;
    private float translate_y;
    private Texture texture;

    public TurtleCanvas(Turtle turtle) {
        this.isRunning = false;
        this.scale = 1.0f;
        this.translate_x = 0.0f;
        this.translate_y = 0.0f;
        // Note: turtleSegments contains always at least one value. The last turn
        this.turtleSegments = turtle.getTurtleSegments();
        this.currentTurtleSegmentIndex = 0;
        this.currentTurtleSegmentIterator = this.turtleSegments.get(0).getSegment().iterator();
        this.boundingBox = this.computeBoundingBox();
    }

    public void texture() {
        try {
            // Load texture from PNG file
            this.texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("imgs/turtle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isRunning() {
        return this.isRunning;
    }
    
    public void display() {
        if (!this.isRunning()) {
            this.start();
        }
    }
    
    protected void dispose() {
        this.isRunning = false;
    }
    
    protected void resize() {
        GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
    }
    
    private void setGLColor(Color color) {
        //GL11.glColor3f((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue());
        GL11.glColor4f((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue(), (float) color.getAlpha());
    }
    
    private void setGLVertex(Point2D point) {
        GL11.glVertex3f((float) point.getX(), (float) point.getY(), 0.0f);
    }

    private void drawGLSegment(Segment2D segment) {
        GL11.glBegin(GL11.GL_LINES);
        this.setGLVertex(segment.getBegin());
        this.setGLVertex(segment.getEnd());
        GL11.glEnd();
    }

    private void drawFilledTriangle(Triangle triangle) { 
        GL11.glBegin(GL11.GL_TRIANGLES);
        this.setGLVertex(triangle.getA());
        this.setGLVertex(triangle.getB());
        this.setGLVertex(triangle.getC());
        GL11.glEnd();
    }

    private void drawTriangle(Triangle triangle) { 
        GL11.glBegin(GL11.GL_LINE_LOOP);
        this.setGLVertex(triangle.getA());
        this.setGLVertex(triangle.getB());
        this.setGLVertex(triangle.getC());
        GL11.glEnd();
    }

    private void initGL() {
        Display.setTitle("Graficos Tortuga");
        Display.setResizable(true);
        Display.setVSyncEnabled(TurtleCanvas.VSYNC);
        Display.setInitialBackground(1f, 1f, 1f);

        try {
            Display.setDisplayMode(new DisplayMode(TurtleCanvas.WIDTH, TurtleCanvas.HEIGHT));
            Display.setFullscreen(TurtleCanvas.FULLSCREEN);

            //create and show our display
            Display.create();
        } catch(LWJGLException e) {
            e.printStackTrace();
	    }

        // 2D games generally won't require depth testing 
	    GL11.glDisable(GL11.GL_DEPTH_TEST);

        // Set clear to transparent black
        GL11.glClearColor(1f, 1f, 1f, 0f);

        // Enable blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        // Set init viewport
        GL11.glViewport(0, 0, TurtleCanvas.WIDTH, TurtleCanvas.HEIGHT);

        GL11.glLineWidth(2.0f);

        //Set modelview to identity
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
    }

    private void start(){
        // Set up our display 
        this.isRunning = true;
        // Create our OpenGL context and initialize any resources
        this.initGL();
        // Load texture
        this.texture();
 
        // While we're still running and the user hasn't closed the window... 
        while(!Display.isCloseRequested()) {
            // If the game was resized, we need to update our projection
            if (Display.wasResized()){
                this.resize();
            }

            // Render the game
            this.render();
                
            // Flip the buffers and sync to 60 FPS
            Display.update();
            Display.sync(40);
        }
    
        // Dispose any resources and destroy our window
        Display.destroy();
        this.dispose();        
    }

    private void keyActions() {
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
            this.translate_x -= 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            this.translate_x += 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            this.translate_y += 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            this.translate_y -= 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_I)) {
            this.scale += 0.01;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_O)) {
            if (this.scale - 0.01 > 0) {
                this.scale -= 0.01;
            } else {
                this.scale = 0;
            }
        }

        GL11.glTranslatef(this.translate_x, this.translate_y, 0);
        GL11.glScalef(this.scale, this.scale, 1f);
    }

    protected void render() {
        // Clear the screen
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        // Define projection type with scale and translations
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        if (this.boundingBox != null) {
            // Add Turtle length
            double turtleSize = 10;
            double x_min = this.boundingBox[0].getX() - turtleSize;
            double y_min = this.boundingBox[0].getY() - turtleSize;
            double x_max = this.boundingBox[1].getX() + turtleSize;
            double y_max = this.boundingBox[1].getY() + turtleSize;
            double dx = Math.abs(x_max - x_min);
            double dy = Math.abs(y_max - y_min);
            // Minimum size = 50
            double view_length = Math.max(50, Math.max(dx, dy));

            GL11.glOrtho(x_min, x_min + view_length, y_min, y_min + view_length, 0, 1);
        }

        this.keyActions();

        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        // Draw previous segments
        this.drawPreviousSegments();

        ColoredSegment2D partialCurrentSegment = this.getPartialCurrentSegment();
        // Draw current Turtle Segment
        this.setGLColor(partialCurrentSegment.getColor());
        this.drawGLSegment(partialCurrentSegment.getSegment());

        //Draw Turtle
        this.drawTurtle(partialCurrentSegment.getSegment().getEnd());

        // Render now
        GL11.glFlush(); 
    }

    private Point2D[] computeBoundingBox() {
        ArrayList<Point2D> points = new ArrayList();
        Iterator<TurtleSegment> it = this.turtleSegments.iterator();
        while(it.hasNext()) {
            ColoredSegment2D segment = it.next().getSegment();
            points.add(segment.getSegment().getBegin());
            points.add(segment.getSegment().getEnd());
        }

        return Point2D.computeBoundingBox(points);
    }

    protected void drawTurtle(Point2D center) {
        // Rotate it around ended point of current segment
        double angle_rad;
        if (this.currentTurtleSegmentIndex < this.turtleSegments.size()) {
            angle_rad = this.turtleSegments.get(this.currentTurtleSegmentIndex).getAngleRad();
        } else {
            angle_rad = this.turtleSegments.get(this.turtleSegments.size() - 1).getAngleRad();
        }

        // Note: Uncommend these lines to draw the turtle as triangle
        // Triangle turtle = Turtle.getTurtleTriangle(center);
        // this.setGLColor(Color.BLACK);
        // this.drawTriangle(turtle);
        Square turtle = Turtle.getTurtleSquare(center);
        turtle = turtle.rotate(2 * Math.PI - angle_rad, center);

        // Enable texturing
        this.setGLColor(Color.WHITE);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        texture.bind();
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            this.setGLVertex(turtle.getA());

            GL11.glTexCoord2f(1, 0);
            this.setGLVertex(turtle.getB());

            GL11.glTexCoord2f(1, 1);
            this.setGLVertex(turtle.getC());

            GL11.glTexCoord2f(0, 1);
            this.setGLVertex(turtle.getD());
        GL11.glEnd();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    protected void drawPreviousSegments() {
        for (int i = 0; i < this.currentTurtleSegmentIndex; i++) {
            ColoredSegment2D segment = this.turtleSegments.get(i).getSegment();
            this.setGLColor(segment.getColor());
            this.drawGLSegment(segment.getSegment());
        }
    }

    protected ColoredSegment2D getPartialCurrentSegment() {
        ColoredSegment2D currentSegment = this.currentTurtleSegmentIterator.next();
        // If turtle has traveled all the segment then move to the next one
        if (
            this.currentTurtleSegmentIndex < this.turtleSegments.size()
            && !this.currentTurtleSegmentIterator.hasNext()
        ) {
            // If segments has not ended. Start traveling it
            this.currentTurtleSegmentIndex++;
            if (this.currentTurtleSegmentIndex < this.turtleSegments.size()) {
                this.currentTurtleSegmentIterator = this.turtleSegments.get(
                    this.currentTurtleSegmentIndex
                ).getSegment().iterator();
            }
        }

        return currentSegment;
    }
}