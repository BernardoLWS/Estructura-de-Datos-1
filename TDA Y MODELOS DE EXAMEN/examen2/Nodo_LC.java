package examen2;

public class Nodo_LC {
   public Object Elem; //Object Puede aceptar cualquier tipo de dato
    private Nodo_LC RS;  //Siguiente Nodo
    
    public Nodo_LC(){
        Elem = null; 
        RS = null;
    }
    
    void setElem(Object ele){
        Elem = ele;
    }
    
    Object getElem(){
        return Elem;
    }
    
    void setRS(Nodo_LC RSaux){
        RS = RSaux;
    }
    
    Nodo_LC getRS(){
        return RS;
    }
}
