    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.matriz;

import Presentacion.FPMatriz;

/**
 *
 * @author Marco Alejandro
 */
public class TDAMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FPMatriz().setVisible(true);
//            }
//        });
        Sparce3 MF = new Sparce3(3,4);
        MF.setDato(3, 1, '+', 5, 3);
        for (int i = 1; i <= MF.m; i++) {
            System.out.println(MF.toStringFila(i));
        }
//        Sparce_String a = new Sparce_String();
//        a.setDato("EL DIA DE HOY HAY EXAMEN PERO NO ESTUDIE");
//        for (int i = 0; i < a.m; i++) {
//            System.out.println(a.toStringFila(i));
//        }
    }
    
}
