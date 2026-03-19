/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Negocio.Nodo;
/**
 *
 * @author Marco Alejandro
 */
public class Lista {
    Nodo L; //Primer Nodo 
    int cant;
    
    public Lista(){
        this.L=null;
        this.cant=0;
    }
    public boolean vacia(){
        return (L==null); //cant == 0
    }
    
    public void insertar(int ele){
        if (vacia()) {
            Nodo p=new Nodo();
            p.setDato(ele);
            L=p;
            cant++;
        }else{ //Si no esta vacia
            Nodo Aux=L;
            Nodo Ant=null;
            while((Aux !=null)&&(Aux.getDato()<=ele)){
                Ant=Aux;
                Aux=Aux.getEnlace();
            }
            if (Ant==null) { //Si el numero es menor al de la cabeza
               Nodo p=new Nodo();
               p.setDato(ele);
               p.setEnlace(L);
               L=p;
               cant++;
            }else{ //2->3->-1   ----------- 4
                if (Ant.getDato()!=ele) {
                    Nodo p=new Nodo();
                    p.setDato(ele);
                    Ant.setEnlace(p);
                    p.setEnlace(Aux);
                    cant++;
                }
            }
        }
    }
    
    public void Eliminar(int ele){
        if (!vacia()) {
            Nodo Aux=L;
            Nodo Ant=null;
            
            while((Aux !=null)&&(Aux.getDato()!=ele)){
                Ant=Aux;
                Aux=Aux.getEnlace();
            }
            if (Aux!=null) {
                if (Ant==null) {
                    L=L.getEnlace();
                    cant--;
                }else{
                    Ant.setEnlace(Aux.getEnlace());
                    cant--;
                }
            }
        }
    }
    
    public boolean Existe(int ele){
        boolean x=false;
        if (!vacia()) {
            Nodo Aux = L;
            while((Aux!=null)&&(Aux.getDato()!=ele)){
                Aux=Aux.getEnlace();
            }
            if (Aux!=null) {
                x=true;
            }
        }
        return x;
    }
    public int getDato(int pos){
        if (pos<=cant) {
            Nodo Aux=L;
            for (int i = 1; i < pos; i++) {
                Aux=Aux.getEnlace();
            }
            return (Aux.getDato());
        }else{
            return -1;
        }
    }
    
    @Override
    public String toString(){
        String S="L-> <";
        Nodo Aux=L;
        while (Aux!=null){
            S=S+Aux.getDato();
            if (Aux.getEnlace()!=null) {
                S=S+",";
            }
            Aux=Aux.getEnlace();
        }
        S=S+">";
        return S;
    }
    
    public void invertirR(){
        invertirR(L);
    }
    private void invertirR(Nodo p){
        if (p==null){ 
            //NO HACEMOS NADA
            return;
        }else{
            if (p.getEnlace()==null) {
                L=p;
            }else{
                invertirR(p.getEnlace());
                p.getEnlace().setEnlace(p);
                p.setEnlace(null);
            }
        }
    }
}
