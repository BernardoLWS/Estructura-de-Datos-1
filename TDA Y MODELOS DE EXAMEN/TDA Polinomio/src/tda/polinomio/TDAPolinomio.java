/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.polinomio;
import Negocio.Monomio;
import Negocio.Polinomio;
import Negocio.Monomio_Real;
import Negocio.Polinomio_Real;
import Negocio.Racional;
/**
 *
 * @author Marco Alejandro
 */
public class TDAPolinomio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Monomio M = new Monomio('+',5,4);
        Monomio M1 = new Monomio('+',5,1);
        Monomio M2 = new Monomio('+',5,3);
        System.out.println(M.toString());
        Polinomio P = new Polinomio(4);
        P.Insertar(M);
         P.Insertar(M1);
          P.Insertar(M2);
        System.out.println(P.toString());
//          Polinomio P=new Polinomio(4);
//          Monomio B=new Monomio('-',5,8);
//          P.Insertar(B);
//          Monomio C=new Monomio('+',1,4);
//          P.Insertar(C);
//          Monomio D=new Monomio('+',3,0);
//          P.Insertar(D);
//          System.out.println(P.toString());
//          System.out.println(P.Evaluar(3));
//          Polinomio Q=new Polinomio(4);
//          Monomio B1=new Monomio('+',5,2);
//          Q.Insertar(B1);
//          Monomio C1=new Monomio('+',1,4);
//          Q.Insertar(C1);
//          Monomio D1=new Monomio('-',3,0);
//          Q.Insertar(D1);
//          System.out.println(Q.toString2());
//          Polinomio R=new Polinomio(4);
//          R.Sumar(P, Q);
//          System.out.println(R.toString());
    }
    
}
