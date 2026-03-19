package examen2;
public class NodoP {
     int Dato;
    NodoP Enlace;
    
    public NodoP(){
        this.Enlace=null;
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
