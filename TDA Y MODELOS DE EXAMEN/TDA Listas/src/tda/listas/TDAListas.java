/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.listas;
import Negocio.Lista;
import Negocio.ListaEnlazadaBasadaEnVectores;
/**
 *
 * @author Marco Alejandro
 */
public class TDAListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //TODO code application logic here
//        ListaEnlazadaBasadaEnVectores lista=new ListaEnlazadaBasadaEnVectores();
//        lista.agregarElemento(10);
//        lista.agregarElemento(20);
//        lista.agregarElemento(30);
//        lista.agregarElemento(40);
//        lista.imprimirLista();
        
        Lista L1=new Lista();
        L1.insertar(10);
        L1.insertar(2);
        L1.insertar(1);
        L1.insertar(10);
        L1.insertar(5);
        L1.insertar(8);
        L1.insertar(8);
        L1.insertar(3);
        L1.insertar(2);
        System.out.println(L1);
        L1.invertirR();
        System.out.println(L1);
    }
    
}
