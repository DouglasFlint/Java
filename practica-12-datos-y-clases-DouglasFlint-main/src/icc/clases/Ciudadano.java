package icc.clases;

public class Ciudadano {

    //Nuestro ciudadano constará de nombre, apellido parteno, materno y día de nacimiento.
    //Con estos datos construiremos el RFC.
    // los Ponemos private porque no queremos que nadie modifique los valores.
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cumple;


    //Aquí construimos el constructor, inicializando las variables del objeto con los valores que s ele asignnen. 
    public Ciudadano(String nombre, String apellidoPaterno, String apellidoMaterno, String cumple){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.cumple = cumple;
    }
    
    // Con este metodo construimos el RFC de acuerdo a los valores de cada ciudadano. 
    // Cuidamos el upperCase y construimos con substrings.
    public String calculaRFC(){
        String ap = apellidoPaterno.substring(0, 2);
        String ap1 = ap.toUpperCase();
        String am = apellidoMaterno.substring(0,1);
        String am1 = am.toUpperCase();
        String nom = nombre.substring(0,1);
        String nom1 = nom.toUpperCase();

        String ano = cumple.substring(8, 10);
        String mes = cumple.substring(3, 5);
        String dia = cumple.substring(0, 2);

        return ap1 + am1 + nom1 + ano + mes + dia;

        
    }

    //Este ultimo metodo solo regresa datos sin modificar.

    public String toString(){
        return nombre + ' ' + cumple + ' ' + calculaRFC();
    }


}
