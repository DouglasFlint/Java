package icc.ordenamientos;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
/* import java.io.FileNotFoundException; */
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Clase principal de la práctica de ordenamientos.
 */
public class UsoOrdenamientos {

    /**
     * Método para crear arreglos aleatorios de una longitud dada.
     */
    private static int[] arregloAleatorio(int longitud) {
        Random r = new Random();
        int[] aleatorio = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            int llena = r.nextInt()/10000;
            aleatorio[i] = llena;
        }
        return aleatorio;
    }

    /**
     * Método principal. Ordena varios arreglos de diferentes longitudes
	 * con Selection Sort y reporta el tiempo que tardó en realizarlo. 
	 * Además escribe en un archivo los tiempos. Puede tardar
	 * varios minutos. Para probar su programa se recomienda mejor ant test.
	 * @param args Para acceder a los argumentos. 
	 */
    public static void main(String[] args) {
        int[] longitudes = new int[]{1000,10000,50000, 100000, 200000,
                                     400000};
        
        long startTime, endTime;
        try {
            FileOutputStream fos = new FileOutputStream("tiempos.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");
            BufferedWriter out = new BufferedWriter(osw);
        
        
            for (int l = 0; l<longitudes.length; l++) {
                int[] arregloSelection = arregloAleatorio(longitudes[l]); 
                startTime = System.currentTimeMillis();
                Ordenamientos.selectionSort(arregloSelection);
                endTime = System.currentTimeMillis();
                String reporte = String.format("SelectionSort con %d elementos: %d milisegundos\n", 
                                                longitudes[l], endTime-startTime);
                System.out.printf("%s", reporte);
                out.write(reporte);
            }
            out.close();
        } catch (IOException ioe) {
            System.out.printf("Error guardando la línea en tiempos.txt");
        }    
    }

}
