package icc.ordenamientos;

/**
 * Clase donde se encuentran los algoritmos para
 * ordenar arreglos. 
 */
public class Ordenamientos {

    /**
     * Ordena el arreglo recibido usando BucketSort.
     * @param arreglo el arreglo a ordenar.
     * @param m minimo valor en el arreglo.
     * @param M maximo valor en el arreglo.
     */
    public static void bucketSort(int[] arreglo, int m, int M) {
        // Implemente la función
        int auxSize = M - m +1;
        int [] aux = new int[auxSize];
        for(int i = 0; i < arreglo.length; i++){
            aux[arreglo[i] - m]++;
        }
        int index = 0;
        for(int i = 0; i < aux.length; i++){
            for(int j = 0; j < aux[i]; j++){
                arreglo[index++] = m;
            }
            m++;
        }
        
    }

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
        int mi = a[i];
        int mj = a[j];
        a[i] = mj;
        a[j] = mi;
        

    }
    
    
    /**
     * Ordena el arreglo recibido usando SelectionSort.
     * @param arreglo el arreglo a ordenar.
     */
    public static void selectionSort(int[] arreglo) {
        // Implemente la función 
        
        int n = arreglo.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arreglo[j] < arreglo[min])
                intercambia(arreglo, min, j);
            }
        }

   }
}
