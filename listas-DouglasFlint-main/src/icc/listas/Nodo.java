/* -------------------------------------------------------------------
 * Nodo.java
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
 * Programa base para Listas que guarda un valor y una referencia.
 * @author Manuel Alcantara Juarez
 * @version 1.0<br>
 * Noviembre 2020
 */
 
public class Nodo {
	private Object valor;
	private Nodo siguiente;

	/*
	*Constructor crea un nuevo Nodo
	*@param o Objeto que se quiera poner en el nodo.
	*/
	public Nodo(Object o) {	
			this.valor = o;	
	}
	

   /*
	*Constructor crea un nuevo Nodo.
	*@param valor: que se quiera poner en el nodo.
	*@param siguiente: representa el siguiente nodo. 
	*/
	
	public Nodo(Object valor, Nodo siguiente) {
		this.valor = valor;
		this.siguiente = siguiente;
	}

	Nodo getSiguiente() { return siguiente;}

	void setSiguiente(Nodo siguiente){ this.siguiente = siguiente;}
	

	public Object getDato(){
		return valor;
	}
	public void setDato(Object valor){
		this.valor = valor;
	}
}