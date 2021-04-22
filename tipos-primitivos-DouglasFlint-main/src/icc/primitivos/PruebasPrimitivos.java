public class PruebasPrimitivos{
    public static void main(String[] args) {

        System.out.println("\n");
        //Ejercicio 1
        int num = 456;
        long numlong = 456;
        float numfloat = 456;
        double numdouble = 456;

        ImpresoraBinario p = new ImpresoraBinario();
        p.imprime(num);
        p.imprime(numlong);
        p.imprime(numfloat);
        p.imprime(numdouble);

        System.out.println("\n");

        //Ejercicio 2
        int numNeg = -456;
        long numlongNeg = -456;
        float numfloatNeg = -456;
        double numdoubleNeg = -456;
        
        p.imprime(numNeg);
        p.imprime(numlongNeg);
        p.imprime(numfloatNeg);
        p.imprime(numdoubleNeg);

        System.out.println("\n");
        //Ejercicio 3
        int x = (int)-456.601;
        long x1 = (long)-456.601;
        float x2 = (float)-456.601;

        int numDec = x;
        long numlongDec = x1;
        float numfloatDec = x2;
        double numdoubleDec = -456.601;
        
        p.imprime(numDec);
        p.imprime(numlongDec);
        p.imprime(numfloatDec);
        p.imprime(numdoubleDec);

        System.out.println("\n");
        //Ejercicio4
        int mascara = 111;
        System.out.println(mascara);
        String mascaraBin = Integer.toBinaryString(mascara);
        System.out.println(mascaraBin);
        int mascara1 = mascara << 3;
        System.out.println(mascara1);
        String mascaraBin1 = Integer.toBinaryString(mascara1);
        System.out.println(mascaraBin1);

        System.out.println("\n");
        //Ejercicio5
        int xum = 1408;
        String xumBin = Integer.toBinaryString(xum);
        System.out.println(xumBin);
        System.out.println("\n");

        int xum1 = xum & mascara;
        String xum1Bin = Integer.toBinaryString(xum1);
        System.out.println(xum1);
        System.out.println(xum1Bin);
        System.out.println("\n");

        int xum2 = xum | mascara;
        String xum2Bin = Integer.toBinaryString(xum2);
        System.out.println(xum2);
        System.out.println(xum2Bin);
        System.out.println("\n");

        int xum3 = xum ^ mascara;
        String xum3Bin = Integer.toBinaryString(xum3);
        System.out.println(xum3);
        System.out.println(xum3Bin);
        System.out.println("\n");

        int xum4 = ~xum;
        String xum4Bin = Integer.toBinaryString(xum4);
        System.out.println(xum4);
        System.out.println(xum4Bin);
        System.out.println("\n");
    }
}