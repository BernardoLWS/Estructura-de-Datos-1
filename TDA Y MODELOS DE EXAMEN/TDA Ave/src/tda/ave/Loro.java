/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.ave;

/**
 *
 * @author Marco Alejandro
 */
public class Loro extends Ave {
    private char region;
    private String Color;

    public Loro(char sexo, int edad, char region, String Color) {
        super(sexo, edad);
        this.region = region;
        this.Color=Color;
    }

    public void deDondeEres() {
        //Al colocar un string en java podemos usar el .toUppercase para que sea mayuscula
        //minuscula es .toLowerCase() //n
        switch (Character.toUpperCase(region)) { 
            case 'N':
                System.out.println("Norte");
                break;
            case 'S':
                System.out.println("Sur");
                break;
            case 'E':
                System.out.println("Este");
                break;
            case 'O':
                System.out.println("Oeste");
                break;
            default:
                System.out.println("Región desconocida");
        }
    }

    public void setRegion(char region) {
        this.region = region;
    }
}
