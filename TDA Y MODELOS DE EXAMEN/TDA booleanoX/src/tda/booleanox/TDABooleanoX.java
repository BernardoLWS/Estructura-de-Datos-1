/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.booleanox;

/**
 *
 * @author Marco Alejandro
 */
public class TDABooleanoX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        booleanoX b1 = new booleanoX(1);
        booleanoX b2 = new booleanoX(0);
        System.out.println("Valor b1: " + b1.valor());
        System.out.println("Valor b2: " + b2.valor());
        
   //b1.Negado();

      //b1.Negado();
      //b2.Negado();
      System.out.println("Valor b1: " + b1.valor());
      System.out.println("Valor b2: " + b2.valor());
      
      //System.out.println("b1 Y b2: " + b1.y(b2).valor());
      System.out.println("b1 O b2: " + b1.o(b2).valor());
    }
    
}
