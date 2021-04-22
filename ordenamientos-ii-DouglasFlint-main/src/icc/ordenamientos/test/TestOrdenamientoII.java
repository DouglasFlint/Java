package icc.ordenamientos.test;

import java.util.Random;
import icc.ordenamientos.OrdenamientosII;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Clase de pruebas para ordenamientos.
 */
public class TestOrdenamientoII {

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
    
    private int[] arregloAleatorio(int total) {
        int[] arr = new int[total];
        for (int i = 0; i<total; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
    
    private int[] arregloOrdenado(int total) {
        int[] arr = new int[total];
        for (int i = 0; i<total; i++) {
            arr[i] = i;
        }
        return arr;
    }
    
    private int[] arregloOrdenadoExcluye(int total, int excluido) {
        int[] arr = new int[total];
        int j = 0;
        for (int i = 0; i<total; i++) {
            if (j==excluido)
                j++;
            arr[i] = j++;
        }
        return arr;
    }

    /**
     * Crea un generador de números aleatorios para cada prueba, un
     * número total de elementos para nuestro arreglo, y un arreglo.
     */
    public TestOrdenamientoII() {
        random = new Random();
    }
    
    /**
     * Prueba unitaria para quickSort con un arreglo aleatorio.
     */
    @Test public void testQuickSort() {
        // Arreglo de longitud entre 100 y 1000.
        int total = 100 + random.nextInt(900);
        int[] arreglo = arregloAleatorio(total);
        // Nos aseguramos que el arreglo no está ordenado.
        arreglo[0] = 42;
        arreglo[1] = 41;
        Assert.assertFalse(ordenado(arreglo));
        OrdenamientosII.quickSort(arreglo);
        // Vemos si está ordenado.
        Assert.assertTrue(ordenado(arreglo));
    }
        
    /**
     * Prueba unitaria para verificar que BusquedaBinaria en efecto
     * encuentra un elemento del arreglo. 
     */
    @Test public void testBusquedaBinariaElemento() {
        // Arreglo de longitud entre 100 y 500
        int total = 100 + random.nextInt(400);
        int[] arreglo = arregloOrdenado(total);
        int busca = random.nextInt(total);
        for (int i = 0; i<total; i++){
            int indice = OrdenamientosII.busquedaBinaria(arreglo, arreglo[busca]);
            // El índice encontrado debe ser igual al del elemento que buscamos.
            Assert.assertTrue(indice==busca);
        }
    }
    
    /**
     * Prueba unitaria que verifica que BusquedaBinaria
     * tiene el comportamiento esperado con un elemento
     * que no está en el arreglo.
     */
    @Test public void testBusquedaBinariaNoElemento(){
        // Arreglo de longitud entre 100 y 500
        int total = 100 + random.nextInt(400);
        int excluye = random.nextInt(total);
        int[] arreglo = arregloOrdenadoExcluye(total, excluye);
        int indice = OrdenamientosII.busquedaBinaria(arreglo, excluye);
        Assert.assertTrue(indice==-1);
        indice = OrdenamientosII.busquedaBinaria(arreglo, -100);
        Assert.assertTrue(indice==-1);
        indice = OrdenamientosII.busquedaBinaria(arreglo, total+100);
        Assert.assertTrue(indice==-1);
        
    }
     
}
