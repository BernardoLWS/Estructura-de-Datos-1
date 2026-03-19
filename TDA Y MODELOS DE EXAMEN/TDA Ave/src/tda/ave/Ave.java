/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.ave;

/**
 *
 * @author Marco Alejandro
 */
public class Ave {
    
    //private solo se usa en su clase
    //public  se puede usar externamente con una import
    //protected solo se usa en su misma clases y en sus clases hijas
    
    protected char sexo; // 'M' o 'H'
    protected int edad;
    //ave null,null,0 M,43,1 ave2 null,null,1 H,12,2
    protected static int numeroAvesCreadas = 0;
    //EL STATIC es para que todas las clases usen el mismo elemento

    public Ave(char sexo, int edad) {
        this.sexo = sexo;
        //this. es para indicar que estamos usando los atributos de la clase
        this.edad = edad;
        numeroAvesCreadas++; //numeroAvesCreadas=numeroAvesCreadas+1;
    }

    public static int getNumeroAvesCreadas() {
        return numeroAvesCreadas;
    }

    public void quienSoy() {
        System.out.println("Sexo: " + sexo + ", Edad: " + edad);
    }
}
