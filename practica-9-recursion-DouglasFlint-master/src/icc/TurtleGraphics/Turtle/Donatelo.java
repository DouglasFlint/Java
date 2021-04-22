package icc.TurtleGraphics.Turtle;

public class Donatelo extends Turtle {

    public void snowflake_side(int long_inicial, int nivel){
        penDown();
        if(nivel <= 0){
            forward(long_inicial);
        } else{
           
            snowflake_side(long_inicial/3, nivel-1);
            turn(-60);
            snowflake_side(long_inicial/3, nivel-1);
            turn(120);
            snowflake_side(long_inicial/3, nivel-1);
            turn(-60);
            snowflake(long_inicial/3, nivel-1);
        }
    }

    public void snowflake(int longitud, int nivel){

             snowflake_side(longitud, nivel);
    }

    public void triangulo(int longitud){
        penDown();
        turn(30);
        forward(longitud);
        turn(120);
        forward(longitud);
        turn(120);
        forward(longitud);
    }

    public void sierpinski(Point2D inicio, double longitud, int depth){
        sierpinski(inicio, longitud, depth);
    }

    public void draw() {
        // Insertar Instrucciones aqui.

    /*  snowflake(90, 3);
        turn(120);
        snowflake(90, 3);
        turn(120);
        snowflake(90, 3); */

        /* triangulo(90); */
        Point2D inicio = (0.0,0.0);
        
        sierpinski(inicio, 100, 3);

        
        
    }
}
