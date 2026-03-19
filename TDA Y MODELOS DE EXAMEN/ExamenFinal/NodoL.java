package ExamenFinal;
 public class NodoL{
    int Dato;
    NodoL Enlace;
    
    public NodoL(){
        
        this.Enlace=null;
    }
    public NodoL(int Dato,NodoL Enlace){
        this.Dato=Dato;
        this.Enlace=Enlace;
    }
    
    public void setDato(int Dato){
        this.Dato=Dato;
    }
    public void setEnlace(NodoL Enlace){
        this.Enlace=Enlace;
    }
    
    public int getDato(){
        return Dato;
    }
    public NodoL getEnlace(){
        return Enlace;
    }
}
