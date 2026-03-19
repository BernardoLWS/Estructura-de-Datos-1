/*
dada una cola Q[1,2,2,3,4,4,5]
eliminar repetidos  :   Q[1,2,3,4,5]
sin Extructura aux 
*/
package ExamenFinal;
public class P2_Cola {
    NodoC frente,atras;
    int cant,max;
    public P2_Cola(){
        frente = null;
        atras = null;
        cant = 0;
    }
    public boolean vacio(){
    return (frente == null && atras==null);
}    
    public boolean lleno(){
    return (cant>=max);
}
    public void encolar(int e) {
    NodoC p = new NodoC();
    p.setDato(e);
    p.setEnlace(null); // siempre será el último
    if (vacio()) {
        frente = p;
        atras = p;
    } else {
        atras.setEnlace(p); // el último apunta al nuevo
        atras = p;          // actualizo el puntero de fin
    }
    cant++;
}
    public int descolar() {
    if (vacio()) {          // caso cola vacía
        return -1;          // o lanzar excepción
    }
    int x = frente.getDato();
    if (frente == atras) {  // solo un nodo
        frente = null;
        atras = null;
    } else {                // más de un nodo
        frente = frente.getEnlace();
    }
    cant--;
    return x;
    }

    public void EliminarRepetidos(){        //Q[1,2,2,3,4,4,5]
        int anterior = -1;
        int n = this.cant;
        for(int i = 0;i<n;i++){
            int siguiente = this.descolar();  //sig = 1,2,2,3,4,4,5
            if(anterior == siguiente){        //0=1? ,1=2? , 2=2? , 2=3? ,3=4? 4=4? 4=5?
               anterior = siguiente;          //ante = 2,4
            }else{
                this.encolar(siguiente);       // Q[2,2..,5,1]->[2,..,5,1,2]->[4,4,5,1,2,3]->[4,5,1,2,3,4]->[1,2,3,4,5]
                anterior = siguiente;      //ante = 1,2,3,4,5
            }
        }
    }
    @Override
    public String toString() {
       String S=" C ";
       NodoC aux = frente;
       while(aux!=null){
           S = S+"->"+aux.getDato();
           aux =aux.getEnlace();
       }
       return S;
    }
    public static void main(String[] args) {
        P2_Cola q = new P2_Cola();
        q.encolar(1);
        q.encolar(2);
        q.encolar(2);
        q.encolar(3);
        q.encolar(4); 
        q.encolar(4);
        q.encolar(5);
        q.EliminarRepetidos();
        System.out.println("antes:\n"+q.toString());
        System.out.println("despues:\n"+q.toString());
}
}
