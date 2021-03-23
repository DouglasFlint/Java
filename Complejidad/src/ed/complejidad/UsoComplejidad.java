package ed.complejidad;


public class UsoComplejidad {

    public static void main(String[] args){

        IComplejidad c = new Complejidad();
        
        for(int i = 0; i < 20; i++){
            c.fibonacciRec(i);
            try{IComplejidad.escribeOperaciones("fibonacciRec.dat",i,c.leeContador());}
            catch(Exception e){
                System.out.println("Something went wrong.");
            }
        }
        for(int i = 0; i < 20; i++){
            c.fibonacciIt(i);
            try{IComplejidad.escribeOperaciones("fibonacciIt.dat",i,c.leeContador());}
            catch(Exception e){
                System.out.println("Something went wrong.");
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                c.tPascalRec(i, j);
                try{IComplejidad.escribeOperaciones("tPascalRec.dat",i,j,c.leeContador());}
                catch(Exception e){
                System.out.println("Something went wrong.");
                
            }
        }  
        try{IComplejidad.escribeLineaVacia("tPascalRec.dat");}
            catch(Exception e){
                System.out.println("Something went wrong.");
                
            } 
    }

    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 10; j++){
            c.tPascalIt(i, j);
            try{IComplejidad.escribeOperaciones("tPascalIt.dat",i,j,c.leeContador());}
            catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }   
    try{IComplejidad.escribeLineaVacia("tPascalIt.dat");}
            catch(Exception e){
                System.out.println("Something went wrong.");
                
            } 
}
    
}
}
