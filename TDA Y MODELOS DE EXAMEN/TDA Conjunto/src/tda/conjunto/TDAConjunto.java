/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.conjunto;

import Negocio.Conjunto;
import Presentacion.FPrincipal;

/**
 *
 * @author Marco Alejandro
 */
public class TDAConjunto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Para llamar a nuestro formulario
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new FPrincipal().setVisible(true);
            }
        });
    }
    
}
