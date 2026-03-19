package examen2;
public class PilaL {
   NodoP Cima;
    int cant; //Cantidad de elementos
    
    public PilaL(){
        Cima = null;
        cant = 0;
    }
    
    public boolean Vacia(){
        return Cima == null; //(cant == 0)
    }
    
    public void Push(int ele){
        NodoP p = new NodoP();
        p.setDato(ele);
        p.setEnlace(Cima);
        Cima = p;
        cant++;
    }
    
    public int Pop(){
        if (!Vacia()) {
            int x = Cima.getDato();
            Cima = Cima.getEnlace();
            cant--;
            return x;
        }else{
            return -1;
        }  
    }
    
    public int Get(){
        return Cima.getDato();
    }

    @Override
    public String toString() {
        String S = "";
        NodoP Aux = Cima;
        while (Aux != null){
            S = S + Aux.getDato()+"\n";
            Aux = Aux.getEnlace();
        }
        return S;
    }
     
}
