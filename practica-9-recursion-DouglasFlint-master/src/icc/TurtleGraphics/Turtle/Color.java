package icc.TurtleGraphics.Turtle;

public class Color {
    public static final Color BLACK = new Color(0.0, 0.0, 0.0);
    public static final Color BLUE = new Color(0.0, 0.0, 1.0);
    public static final Color GREEN = new Color(0.0, 1.0, 0.0);
    public static final Color RED = new Color(1.0, 0.0, 0.0);
    public static final Color WHITE = new Color(1.0, 1.0, 1.0);
    public static final Color TRANSPARENT = new Color(1.0, 1.0, 1.0, 0.0);

    private double red;
    private double green;
    private double blue;
    private double alpha;

    public Color(double red, double green, double blue, double alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Color(double red, double green, double blue) {
        this(red, green, blue, 1.0);
    }

    public Color() {
        this(0.0, 0.0, 0.0);
    }
    
    public double getRed() {
        return this.red;
    }
    
    public double getGreen() {
        return this.green;
    }
    
    public double getBlue() {
        return this.blue;
    }

    public double getAlpha() {
        return this.alpha;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setRGB(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    @Override
    public Color clone() {
        return new Color(this.getRed(), this.getGreen(), this.getBlue(), this.getAlpha());
    }
    
    @Override
    public String toString() {
        return String.format(
            "Color(r=%f, g=%f, b=%f, a=%f)",
            this.getRed(),
            this.getGreen(),
            this.getBlue(),
            this.getAlpha()
        );
    } 
}