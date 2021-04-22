public class Prueba{
    public static void main(String[] args){
        System.out.println("\n");
        // Actividad 2.1
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        String maxBin = Integer.toBinaryString(max);
        System.out.println(maxBin);
        int maxx = max + 1;
        System.out.println(maxx);
        String maxxBin = Integer.toBinaryString(maxx);
        System.out.println(maxxBin);
        System.out.println("\n");

        //Actividad 2.2
        double nan = Double.NaN;
        double minf = Double.NEGATIVE_INFINITY;
        double pinf = Double.POSITIVE_INFINITY;
        double cero = 0.0;
        double mcero = -0.0;

        ImpresoraBinario p = new ImpresoraBinario();
        p.imprime(nan);
        p.imprime(minf);
        p.imprime(pinf);
        p.imprime(cero);
        p.imprime(mcero);
        System.out.println("\n");

        //Actividad 2.3
        short permisos;
        permisos = 0754;
        String permisosBin = Integer.toBinaryString(permisos);
        System.out.println(permisosBin);
        System.out.println(permisos); // imprime en base 10
        System.out.println("\n");

        //Actividad 2.4
        int num = 345;
        System.out.println(Integer.toBinaryString(num));
        int resultado1 = num << 1;
        System.out.println(resultado1);
        System.out.println(Integer.toBinaryString(resultado1));
        int resultado2 = num << 3;
        System.out.println(resultado2);
        System.out.println(Integer.toBinaryString(resultado2));
        System.out.println("\n");

        int resultado3 = num >> 1;
        System.out.println(resultado3);
        System.out.println(Integer.toBinaryString(resultado3));
        int resultado4 = num >> 3;
        System.out.println(resultado4);
        System.out.println(Integer.toBinaryString(resultado4));
        System.out.println("\n");

        int resultado5 = num >>> 1;
        System.out.println(resultado5);
        System.out.println(Integer.toBinaryString(resultado5));
        int resultado6 = num >>> 3;
        System.out.println(resultado6);
        System.out.println(Integer.toBinaryString(resultado6));
        System.out.println("\n");

        //Actividiad 2.5
        int permisos1 = permisos >> 2;
        int permisos2 = permisos1 | permisos;
        String permisos3 = Integer.toBinaryString(permisos2);
        System.out.println(permisos3);
        System.out.println("\n");

    }
}