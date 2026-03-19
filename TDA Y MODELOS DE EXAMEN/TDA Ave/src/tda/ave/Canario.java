/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.ave;

/**
 *
 * @author Marco Alejandro
 */
public class Canario extends Ave {
    
    private double tamaño;

    public Canario(char sexo, int edad) {
        super(sexo, edad); //super lo que hace es llamar al constructor de la clase padre
        //public Ave(char sexo, int edad)
    }

    public Canario(char sexo, int edad, double tamaño) {
        super(sexo, edad);
        this.tamaño = tamaño;
    }

    public void altura() {
        if (this.tamaño > 30) { //[30..Infinito positivos]
            System.out.println("Alto"); //[15..30]
        } else if (this.tamaño >= 15 && this.tamaño <= 30) {
            System.out.println("Mediano");
        } else { //[Infinitos negativos .. 14]
            System.out.println("Bajo");
        }
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }
}