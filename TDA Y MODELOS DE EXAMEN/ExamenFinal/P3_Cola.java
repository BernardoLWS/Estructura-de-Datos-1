
package ExamenFinal;
public class P3_Cola {
    NodoC frente,atras;
    int cant;
    public boolean vacio(){
    return (frente == null && atras==null);}
    public void encolar(int e) {
    NodoC p = new NodoC();
    p.setDato(e);
    p.setEnlace(null); 

    if (vacio()) {
        frente = p;
        atras = p;
    } else {
        atras.setEnlace(p); 
        atras = p;          
    }
    cant++;
}
    public int descolar() {
    if (vacio()) {         
        return -1;          
    }
    int x = frente.getDato();
    if (frente == atras) {  
        frente = null;
        atras = null;
    } else {                
        frente = frente.getEnlace();
    }
    cant--;
    return x;
}
    //Q[1,2,3,4]
    //P[5,6,7,8]
    public void IntercalarExtremos(P3_Cola P,P3_Cola Q){  
    //obtener extemos :
    int p1 = P.descolar();      // p1 = 5  
    int q1 = Q.descolar();      // q1 = 1
    int p2,q2;
    for(int i = 1; i<cant;i++){ //avanza hasta el otro extremo
        P.encolar(P.descolar());  
        Q.encolar(Q.descolar());  
    } 
    p2 = P.descolar();  // p2 = 8
    q2 = Q.descolar();  // q2 = 4
    P.encolar(q2);      //P[6,7,4]
    Q.encolar(p2);      //Q[2,3,8] 
    P.encolar(q1);      //P[6,7,4,1]
    Q.encolar(p1);      //Q[2,3,8,5]
    for(int i = 1;i<cant;i++){  // for para ordenar
         P.encolar(P.descolar());
         Q.encolar(Q.descolar());
    }
    }   
    public String toString() {
       String S=" C->";
       NodoC aux = frente;
       while(aux!=null){
           S = S+aux.getDato()+"->";
           aux =aux.getEnlace();
       }
       return S;
    }
    public static void main(String[] args){
     P3_Cola P = new P3_Cola();
     P3_Cola Q = new P3_Cola();
      P.encolar(1); Q.encolar(5);
      P.encolar(2); Q.encolar(6);
      P.encolar(3); Q.encolar(7); 
      P.encolar(4); Q.encolar(8);
    
      P.IntercalarExtremos(P,Q);
      System.out.println("Cola P :\n"+P.toString());
      System.out.println("Cola Q :\n"+Q.toString());
    }
}
