/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.complejo;
import Negocio.Complejo;
import Presentacion.FComplejo;
/**
 *
 * @author Marco Alejandro
 */
public class TDAComplejo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Complejo A=new Complejo();
        A.setReal(2.87f);
        A.setImaginario(5); //->{+2+5i}
        Complejo B=new Complejo(4,-2); //->{+4-2i}
        Complejo C=new Complejo(); // {+0+0i}
        System.out.println(A);
        System.out.println(B);
        C.sumar(A, B);
        System.out.println(C);
        Complejo D=new Complejo();
        D.restar(A, B);
        System.out.println(D);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FComplejo().setVisible(true);
            }
        });
    }
    
}
