/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Marco Alejandro
 */
public class Nodo{
    int Dato;
    Nodo Enlace;
    
    public Nodo(){
        this.Enlace=null;
    }
    public Nodo(int Dato,Nodo Enlace){
        this.Dato=Dato;
        this.Enlace=Enlace;
    }
    
    public void setDato(int Dato){
        this.Dato=Dato;
    }
    public void setEnlace(Nodo Enlace){
        this.Enlace=Enlace;
    }
    
    public int getDato(){
        return Dato;
    }
    public Nodo getEnlace(){
        return Enlace;
    }
    //JAVA 17
    //JAVA 16
}
