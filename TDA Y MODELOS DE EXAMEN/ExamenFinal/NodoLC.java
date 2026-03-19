package ExamenFinal;

public class NodoLC {
   public Object Elem; //Object Puede aceptar cualquier tipo de dato
    private NodoLC RS;  //Siguiente Nodo
    
    public NodoLC(){
        Elem = null; 
        RS = null;
    }
    
    void setElem(Object ele){
        Elem = ele;
    }
    
    Object getElem(){
        return Elem;
    }
    
    void setRS(NodoLC RSaux){
        RS = RSaux;
    }
    
    NodoLC getRS(){
        return RS;
    }
}
