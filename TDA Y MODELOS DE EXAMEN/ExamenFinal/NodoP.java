package ExamenFinal;
public class NodoP {
    int Dato;   //valor que guarda el dato
    NodoP Enlace;    //referencia al siguiente nodo
    
    public NodoP(){
        this.Enlace=null; //declara que el enlace es el ultimo nodo vacio
    }
    public NodoP(int Dato,NodoP Enlace){
        this.Dato=Dato;
        this.Enlace=Enlace;
    }
    public void setDato(int Dato){
        this.Dato=Dato;
    }
    public void setEnlace(NodoP Enlace){
        this.Enlace=Enlace;
    }
    public int getDato(){
        return Dato;
    }
    public NodoP getEnlace(){
        return Enlace;
    } 
}
