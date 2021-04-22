package icc.ordenamientos;

/* import sun.awt.geom.AreaOp; */

/**
 * Clase donde se encuentran los algoritmos para
 * ordenar arreglos. 
 */
public class OrdenamientosII {
    
    /**
     * Método auxiliar. Dado un arreglo y dos índices 
     * (se asumen no negativos y menores a la longitud del arreglo) 
     * intercambia los elementos en esos índices.
     * @param a el arreglo en el que se haran los intercambios.
     * @param i el primer índice.
     * @param j el segundo índice.
     */
    public static void intercambia(int[] a, int i, int j) {
        // Implemente la función
        int x = a[i];
        int y = a[j];
        a[j] = x;
        a[i] = y;

    }
    
    /**
     * Ordena el arreglo recibido usando QuickSort.
     * @param arreglo el arreglo a ordenar.
     */
    public static void quickSort(int[] arreglo) {
        // Ordenamos el arreglo completo (de 0 a length-1)
        quickSort(arreglo, 0, arreglo.length-1);
    }
    
    
    /**
     * Método auxiliar para implementar quicksort de forma recursiva, 
     * usando parámetros extra para indicar el inicio y fin del subarreglo.
     * @param arreglo el arreglo de donde se obtiene el subarreglo a ordenar.
     * @param inicio el índice de inicio del subarreglo a ordenar.
     * @param fin el índice del final del subarreglo a ordenar.
     */
    private static void quickSort(int[] arreglo, int inicio, int fin){
        // Implemente la función 
        int pivote = arreglo[0];

        int i = inicio;
        int j = fin;
        
            while(i < j){
                while(arreglo[i] <= pivote && i < j){
                    i++;
                }
                while(arreglo[j] > pivote){
                    j--;
                }
                if(i < j){
                    intercambia(arreglo, i, j);
                }
            }
            arreglo[inicio] = arreglo[j];
            arreglo[j] = pivote;

            if(inicio < j-1){
                quickSort(arreglo, inicio, j-1);
            }
            if(j+1 < fin){
                quickSort(arreglo, j+1, fin);
            }
    } 
    
    
    /**
     * Busca un elemento en un arreglo mediante búsqueda binaria.
     * @param arreglo el arreglo donde se hará la búsqueda
     * @param elemento el número que se buscará.
     * @return El índice de n en el arreglo o -1 si no se encuentra.
     */
    public static int busquedaBinaria(int[] arreglo, int elemento){
        // Implementa la función. 
        /* No te debe tomar más de tres líneas. Toma como ejemplo 
           El método quickSort que ya se te entregó implementado.*/ 
           return busquedaBinariaRecursiva(arreglo, 0, arreglo.length -1, elemento);
    }
    
    /* Crea tu función recursiva auxiliar para búsqueda Binaria. 
       Usa los parámetros que creas necesarios. Documenta tu función.*/
    
       public static int busquedaBinariaRecursiva(int[] arreglo, int primero, int ultimo,   int elemento){
           int m = (primero + ultimo)/2;
           if(ultimo < primero){
               return -1;
           }
           if(elemento == arreglo[m]){
               return m;
           } else if(elemento < arreglo[m]){
               return busquedaBinariaRecursiva(arreglo, primero, m-1, elemento);
           } else {
               return busquedaBinariaRecursiva(arreglo, m+1, ultimo, elemento);
           }
       }
}
