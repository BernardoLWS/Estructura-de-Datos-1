/*
 dad 2 colas : P[1,2,3,4,5]    Q[6,7,8,9,10,11]
 intercambiar elementos :
  P[6,7,8,9,10,10]   Q[1,2,3,4,5]
sin uso de ninguna estructura auxiliar
 */
package ExamenFinal;
public class P1_Cola {
    NodoC frente,atras;
    int cant,max;
    public P1_Cola(){
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
    
    public void IntercambiarPQ(P1_Cola Q){
       int cont  = Q.cant;
        while(!vacio()){
            int dato = this.descolar();
            Q.encolar(dato);
        }
        for(int i = 0;i<cont;i++){
            int dato = Q.descolar();
            this.encolar(dato);
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
        P1_Cola p = new P1_Cola();
        P1_Cola q = new P1_Cola();
        p.encolar(1);  q.encolar(6);
        p.encolar(2);  q.encolar(7);
        p.encolar(3);  q.encolar(8);
        p.encolar(4);  q.encolar(9);
        p.encolar(5);  q.encolar(10); q.encolar(11);
        p.IntercambiarPQ(q);
        System.out.println("P: "+p.toString());
         System.out.println("Q: "+q.toString());
    }
}
