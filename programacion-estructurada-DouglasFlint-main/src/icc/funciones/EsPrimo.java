//package icc.funciones;

/**
 * Imprime en la consola los argumentos que le fueron pasados a este programa.
 * Todo programa de Java se encuentra de una construcción llamada <code>class</code>.
 */
public class EsPrimo {

	/** 
	 * Esta función, esPrimo,  lee un número y determinará si es o no un primo con la 
	 * estructura de control for. El valor inicial será true para el 1 y usamos el restante
	 * del cociente % para leer los número qu venian atras de el y dividirlo entre todos ellos,
	 * Para esto usamos otra estructura, el if. Si algun restante da 0, no será primo por definición.
	 * Vemos que no tomamos en cuenta para dividir el 1 y el mismo numero.
	 * 
	 * 
	*/
	public static boolean esPrimo(int num){
		boolean primo = true; 
		for(int i = 2; i < num; i++) {
			if (num % i == 0) {
				primo = false;
				break;
			}
		}
		return primo;
	}
	/**
	 * Método principal, tú código comienza a ejecutarse aquí.
	 * @param args Esta variable permite acceder a cada argumento.
	 *             Los argumentos son cadenas de caracteres <code>String</code>.
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		boolean prime = esPrimo(n);

		if (prime)
		System.out.println("El numero es primo");
		else
			System.out.println("El numero no es primo");

		if(args.length == 0) {

			/* Para usar colores en una consola de Linux se usan
			 * códigos como '\033[35m' ('\003' ó '\e' son códigos para 'escape').
			 * Si quieres jugar con ellos consulta las opciones en:
			 * https://misc.flogisoft.com/bash/tip_colors_and_formatting */

			System.out.println("\033[31mNo se recibieron indicaciones.\033[0m");
		}

		/* Imprime el contenido de args. */
		for(int i = 0; i < args.length; i++) {

			// Solicitamos al sistema que envíe un mensaje a la salida estándar.
			System.out.println("\033[35mArgumento " + i + ": \033[0m" + args[i] );
		}

	}

}
