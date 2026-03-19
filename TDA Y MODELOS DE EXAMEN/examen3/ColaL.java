package examen3;
public class ColaL {
    NodoC frente;
    NodoC atras;
    int cant;
    
    public ColaL(){
        this.frente=null;
        this.atras=null;
        this.cant=0;
    }
    public boolean vacia(){
        return frente==null;
    }
    public void Encolar(int e){
        NodoC p = new NodoC();
        p.setDato(e);
        if(vacia()){
            frente=p;
            atras=p;
            cant++;
        }else{
            atras.setEnlace(p);
            atras=p;
            cant++;
        }
    }
    public int Decolar(){
        int x=atras.getDato();
        if(frente==atras){
            frente=null;
            atras=null;
            cant--;
        }else{
            frente=frente.getEnlace();
            cant--;
        }
        return(x);
    }
    public int get(){
        return atras.getDato();
    }
   
    
}
