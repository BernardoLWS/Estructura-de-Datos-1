package examen3;
//dada 2 colas implementar un metodo para intercambiar metodos:
//P[(1,2,3),4,5,6]          ->  P[(7,8,9),4,5,6]
//Q[(7,8,9),10,11,12]       ->  Q[(1,2,3),10,11,12]
public class P1_Cola {
    NodoC frente,atras;
    int cant,max;
    public P1_Cola(){
        this.frente = null;
        this.atras = null;
        this.max = 6;
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
    public void intercambiar(P1_Cola P,P1_Cola Q){
    int mitad = cant/2;  
    
    //intercambiar p<>q los primeros 3 datos    
    for(int i=0;i<mitad;i++){
        int p = P.descolar();
        int q = Q.descolar();
        P.encolar(q);
        Q.encolar(p);
    }    
    //ordenar los elementos
    for(int i=0;i<mitad;i++){
        int p = P.descolar();
        int q = Q.descolar();
        P.encolar(p);
        Q.encolar(q);
    }   
    }
     public String toStringC1() {
       String S=" C->";
       NodoC aux = frente;
       while(aux!=null){
           S = S+aux.getDato()+"->";
           aux =aux.getEnlace();
       }
       return S;
    }
    public static void main(String[] args) {
      P1_Cola P = new P1_Cola();
      P1_Cola Q = new P1_Cola();
      P.encolar(1); Q.encolar(7);
      P.encolar(2); Q.encolar(8);
      P.encolar(3); Q.encolar(9); 
      P.encolar(4); Q.encolar(10); 
      P.encolar(5); Q.encolar(11); 
      P.encolar(6); Q.encolar(12); 
        
      P.intercambiar(P, Q);
      System.out.println(P.toStringC1());
      System.out.println(Q.toStringC1());
    }
}
