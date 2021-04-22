package icc.listas;

public class Lista implements Listable{
    private Nodo cabeza;
    private int tamanio;


    public Lista() {
        cabeza = null;
        tamanio = 0;
    }

    public boolean estaVacia(){
        return cabeza == null;
    }

    public void insertar(Object o ){
        Nodo nuevo = new Nodo(o);
        nuevo.setDato(o);
        if(estaVacia()){
            cabeza = nuevo;
        } else{
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        }
        tamanio++;
    }

    public boolean buscar(Object o){
        Nodo temp = cabeza;
        boolean encontrado = false;
        while(temp != null && encontrado != true){
            if(o == temp.getDato()){
                encontrado = true;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return encontrado;
    } 

    public void borrar(Object o){
        if(buscar(o)){
            if(cabeza.getDato() == o){
                cabeza = cabeza.getSiguiente();
            } else {
                Nodo aux = cabeza;
                while(aux.getSiguiente().getDato() != o){
                    aux = aux.getSiguiente();
                }
                Nodo siguiente = aux.getSiguiente().getSiguiente();
                aux.setSiguiente(siguiente);
            }
            tamanio--;
        }
    } 



    public Object getPrimerElemento(){
        return cabeza.getDato();
    }

    public void imprimir(){
        if(!estaVacia()){
            Nodo temp = cabeza;
            int i = 0;
            while(temp != null){
                System.out.println(i+ " " + temp.getDato() );
                temp = temp.getSiguiente();
            i++;            }
        }
    }

    public void limpiar(){
        cabeza = null;
    }
    

    
}
