package icc.clases;

/**
 * Clase para ejemplificar el uso de la clase <code>Ciudadano</code>.
 * @author 
 */
public class UsoCiudadano {

    public static void main(String[] args) {
	
	  Ciudadano carmen = new Ciudadano("Carmen Elizabeth Juanita", "de Costa Brava", "Cortez", "30/03/2001");
	  System.out.println("RFC: " + carmen.calculaRFC());
	  System.out.println(carmen.toString());

	  Ciudadano siqueiros = new Ciudadano("David", "Alfaro", "Siqueiros", "29/12/1896");
	  System.out.println("RFC: " + siqueiros.calculaRFC());
	  System.out.println(siqueiros.toString());

	  Ciudadano cantinflas = new Ciudadano("Mario Fortino Alfonso", "Moreno", "Reyes", "12/08/1911");
	  System.out.println("RFC: " + cantinflas.calculaRFC());
	  System.out.println(cantinflas.toString());
	
    }
}
