/* -------------------------------------------------------------------
 * Listable.java
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
 * Interfaz que puede implementar una Lista.
 * @author Manuel Alcantara Juarez
 * @version 1.0<br>
 * Noviembre 2020
 */
public interface Listable {
   /*
	*Borra un elemento de la Lista.
	*@param dato Object que se quiera borrar de la Lista.
	*/
	public void borrar(Object o);
   /*
	*Busca un elemento en la Lista.
	*@param dato Objeto a buscar en la Lista.
	*@return object que contiene el elemento buscado. 
	*/
	public boolean buscar(Object o);
   /*
	*Dice si una Lista esta vacia es decir si no contiene elementos.
	*@return un boolean indicando si la Lista contiene elementos.
	*/
	public boolean estaVacia();
   /*
	*Inserta un elemento al principio de la Lista.
	*@param o Object que se quiera insertar en la Lista.
	*/
	public void insertar(Object o);
   /*
	*Imprime todos los elementos de la Lista.
	*/
	public void imprimir();
   /*
	*Limpia la lista es decir quita todos los elementos en ella.
	*/
	public void limpiar();
   /*
	*Regresa el primer elemento de la Lista.
	*@return un Object que es el primero en la Lista. 
	*/
	public Object getPrimerElemento();
}