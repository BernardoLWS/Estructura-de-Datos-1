/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.texto;

/**
 *
 * @author Marco Alejandro
 */
public class TDATexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        texto Texto = new texto();
        Texto.añadirCaracter('H'); //[H]
        Texto.añadirCaracter('o'); //[H,o]
        Texto.añadirCaracter('l'); //[H,o,l]
        Texto.añadirCaracter('a'); //[H,o,l,a]

        System.out.println("Texto: " + Texto.toString());
        System.out.println("Tamanio: " + Texto.tamaño());
        System.out.println("Caracter en posicion 0: " + Texto.caracterEn(0));
        System.out.println(Texto);
        Texto.destruir();
        System.out.println("Texto destruido. Tamanio: " + Texto);
        
    }
    
}
