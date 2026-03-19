package ExamenFinal;
public class TDA_Cola {
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
    }
}
