package ed.complejidad;

public class Complejidad implements IComplejidad {

    private long contador;

    public long leeContador(){
        return contador;
    }

    public void escribeOperaciones(){}

    public void escribeLineaVacia(){}

    public int tPascalRec(int ren, int col){
        contador = 1;
        if(ren < 0 || col < 0) throw new IndexOutOfBoundsException();
        return auxPascal(ren, col);
    }

    public int tPascalIt(int ren, int col){
        if(ren < 0 || col < 0) throw new IndexOutOfBoundsException();
        int C[][] = new int[ren+1][col+1];
        int i,j;
        int min;
        contador = 1;

        for(i = 0; i <= ren; i++){
            min = (i<col)? i: col;
            for(j = 0; j <= min; j++){
                if(j == 0 || j == i){
                    contador++;
                    C[i][j] = 1;
                }
                else {
                    contador++;
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }
        System.out.print(leeContador());
        return C[ren][col];
    }

    
    public int fibonacciRec(int n){
        contador = 1;
        if(n < 0) throw new IndexOutOfBoundsException();
        return auxFibo(n);
        
    }

    public int fibonacciIt(int n){
        if(n < 0) throw new IndexOutOfBoundsException();
        int f[] = new int[n+2];
        int i;
        contador = 1;
        
        
        f[0] = 0;
        f[1] = 1;

        for(i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
            contador++;
        }
        System.out.print(leeContador());
        return f[n];

    }

    private int auxFibo(int n){
        contador++;
        if(n <= 1) return n;
        return auxFibo(n-1) + auxFibo(n-2);
    }

    private int auxPascal(int ren, int col){
        contador++;
        if (ren == col || ren == 0 || col == 0)
            return 1;
        else {
            return auxPascal(ren - 1, col - 1) + auxPascal(ren - 1, col);
        }
    }


}
