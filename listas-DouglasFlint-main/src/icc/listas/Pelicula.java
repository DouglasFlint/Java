/* -------------------------------------------------------------------
 * Pelicula.java
 * version 1.0
 * Copyright (C) 2020  Manuel Alcantara Juarez,
 * Facultad de Ciencias,
 * Universidad Nacional Autonoma de Mexico, Mexico.
 *
 * Esta interfaz es software libre; se puede redistribuir
 * y/o modificar en los terminos establecidos por la
 * Licencia Publica General de GNU tal como fue publicada
 * por la Free Software Foundation en la version 2 o
 * superior. 
 *
 * Esta interfaz es distribuida con la esperanza de que
 * resulte de utilidad, pero SIN GARANTIA ALGUNA; de hecho
 * sin la garantia implicita de COMERCIALIZACION o
 * ADECUACION PARA PROPOSITOS PARTICULARES. Vease la
 * Licencia Publica General de GNU para mayores detalles.
 * -------------------------------------------------------------------
 */
package icc.listas;

/**
 * Clase para representar una Pelicula.
 * @author Manuel Alcantara Juarez
 * @version 1.0<br>
 * Noviembre 2020
 */
public class Pelicula {
	private String nombre;
    private String categoria;
	/*
	 *Constructor: inicializa una pelicula.
	 */
	public Pelicula() {  
	}
	public Pelicula(String nombre, String categoria) {
		this.nombre = nombre;
        this.categoria = categoria;
	}

	/*
	*Comparador entre dos peliculas.
	* Regresa verdadero si ambas peliculas tienen el mismo nombre.
	*/
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	/*
	*Regresa una cadena con la representacion de la pelicula.
	*/
	@Override
	public String toString() {
		return "";
	}
}