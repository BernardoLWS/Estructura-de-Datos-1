/*
 implementar un metodo para cabiar extremos:
Ej:  
   P[(1),2,3,4,(5)]         -> P[10,2,3,4,6]
   Q[(6),7,8,9,(10)]        -> Q[5,7,8,9,1]
 */
package examen3;
public class P2_Cola {
    NodoC frente,atras;
    int cant;
    public boolean vacio(){
    return (frente == null && atras==null);}
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
    public void cambiar(P2_Cola P,P2_Cola Q){
    //obtener extemos :
    int p1 = P.descolar();      // p1 = 1  -> P[2,3,4,5]  
    int q1 = Q.descolar();      // q1 = 6  -> Q[7,8,9,10] 
    int p2,q2;
    for(int i = 1; i<cant;i++){ //avanza hasta el otro extremo
        P.encolar(P.descolar());  //[3,4,5,2]->[4,5,2,3]->[5,2,3,4]
        Q.encolar(Q.descolar());  // lo mismo en Q
    } 
    p2 = P.descolar();  // p2 = 5  -> P[2,3,4]
    q2 = Q.descolar();  // q2 = 10 -> Q[7,8,9]
    P.encolar(q1);      //  P[2,3,4,6]  
    Q.encolar(p1);      //  Q[7,8,9,1] 
    P.encolar(q2);      //  P[2,3,4,6,10]
    Q.encolar(p2);      //  Q[7,8,9,1,5]
    for(int i = 1;i<cant;i++){
         P.encolar(P.descolar());
         Q.encolar(Q.descolar());
    }
    }   
 
    public String toStringC2() {
       String S=" C->";
       NodoC aux = frente;
       while(aux!=null){
           S = S+aux.getDato()+"->";
           aux =aux.getEnlace();
       }
       return S;
    }
    public static void main(String[] args){
     P2_Cola P = new P2_Cola();
     P2_Cola Q = new P2_Cola();
      P.encolar(1); Q.encolar(6);
      P.encolar(2); Q.encolar(7);
      P.encolar(3); Q.encolar(8); 
      P.encolar(4); Q.encolar(9); 
      P.encolar(5); Q.encolar(10);
      P.cambiar(P,Q);
      System.out.println("Cola P :\n"+P.toString());
      System.out.println("Cola Q :\n"+Q.toString());
    }
}
