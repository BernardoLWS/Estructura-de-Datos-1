/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author Marco Alejandro
 */
class Nodos1{
    int valor;
    int siguiente;
    
    public Nodos1(int valor, int siguiente){
        this.valor=valor;
        this.siguiente=siguiente;
    }
}
public class ListaEnlazadaBasadaEnVectores {
    private ArrayList<Nodos1> nodos;
    private int primerElemento; //Indica en que indice el primer elemento
    private int ultimoElemento; //Indica en que indice esta el ultimo elemento
    public ListaEnlazadaBasadaEnVectores(){
        nodos=new ArrayList<>();
        nodos.add(new Nodos1(0,-1));
        primerElemento=-1;
        ultimoElemento=-1;
    }
    
    public void agregarElemento(int valor){
        int nuevoindice = nodos.size();
        nodos.add(new Nodos1(valor,-1));
        if (ultimoElemento==-1) {
            primerElemento = nuevoindice;
            ultimoElemento = nuevoindice;
        }else{
            nodos.get(ultimoElemento).siguiente = nuevoindice;
            ultimoElemento = nuevoindice;
        }
    }
    
    public void imprimirLista(){
        int actual = primerElemento;
        while (actual != -1){
            System.out.print(nodos.get(actual).valor+"->");
            actual = nodos.get(actual).siguiente;
        }
        System.out.println("null");
    }
}
