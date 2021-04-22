package icc.ordenamientos.test;

import java.util.Random;
import icc.ordenamientos.Ordenamientos;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Clase de pruebas para ordenamientos.
 */
public class TestOrdenamiento {

    /** Expiración para que los tests tarden a lo más 5 segundos.
        (A menos de que su computadora sea muy lenta, si 
        se activa el timeout es probable que se haya ciclado su 
        programa). 
     */
    @Rule public Timeout expiracion = Timeout.seconds(5);

    /* Generador de números aleatorios. */
    private Random random;

    /* Función que nos regresa si un arreglo está ordenado */
    private static boolean ordenado(int[] arreglo) {
        boolean ordenado = true;
        for (int i = 0; i < arreglo.length-1; i++)
            if (arreglo[i] > arreglo[i+1]){
                ordenado = false;
                break;
            }    
        return ordenado;
    }
    
    /* Función que crea un arreglo aleatorio*/
    private int[] arregloAleatorio(int total) {
        int[] arr = new int[total];
        for (int i = 0; i<total; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    /**
     * Crea un generador de números aleatorios para cada prueba, un
     * número total de elementos para nuestro arreglo, y un arreglo.
     */
    public TestOrdenamiento() {
        random = new Random();
    }
    
    /**
     * Prueba unitaria para Selection Sort con arreglo aleatorio.
     */
    @Test public void testSelectionSort() {
        // Arreglo de longitud entre 100 y 500.
        int total = 100 + random.nextInt(400);
        int[] arreglo = arregloAleatorio(total);
        // Nos aseguramos que el arreglo no está ordenado.
        arreglo[0] = 42;
        arreglo[1] = 41;
        Assert.assertFalse(ordenado(arreglo));
        Ordenamientos.selectionSort(arreglo);
        // Vemos si está ordenado.
        Assert.assertTrue(ordenado(arreglo));
    }
    
    /**
     * Prueba unitaria para ver que BucketSort ordena.
     */
    @Test public void testBucketSort() {
        // Arreglo de longitud entre 100 y 500
        int total = 100 + random.nextInt(400);
        int[] arreglo = new int[total];
        // Valor mínimo entre -100 y 0
        int m = random.nextInt(100) - 100;
        // Valor máximo entre 0 y 100
        int M = random.nextInt(101);
        for (int i = 0; i<total; i++) {
            // Número aleatorio entre m y M.
            arreglo[i] = random.nextInt(M-m+1) +m;
        }
        arreglo[0] = M;
        arreglo[1] = m;
        Assert.assertFalse(ordenado(arreglo));
        Ordenamientos.bucketSort(arreglo, m, M);
        Assert.assertTrue(ordenado(arreglo));
    }
    
    /**
     * Prueba unitaria que verifica que BucketSort
     * falla si tiene números fuera de rango.
     */
    @Test public void testBucketRango(){
        int total = 100 + random.nextInt(400);
        int[] arreglo = arregloAleatorio(total);
        // Nos aseguramos que tenga un número fuera de rango.
        arreglo[100] = 420000;
        try {
            Ordenamientos.bucketSort(arreglo, -100, 100);
            Assert.fail("Bucket Sort no debe funcionar con números fuera del rango");
        } catch(Exception e) { }
    }
     
}
