package ExamenFinal;

public class NodoD {
    private int dato;
    private NodoD anterior;
    private NodoD siguiente;

    public NodoD(int dato) {
        this.dato = dato;
        this.anterior = null; //-1
        this.siguiente = null;//-1
    }
    public int getDato() {
        return dato;
    }
    public NodoD getAnterior() {
        return anterior;
    }
    public NodoD getSiguiente() {
        return siguiente;
    }
    public void setAnterior(NodoD anterior) {
        this.anterior = anterior;
    }
    public void setSiguiente(NodoD siguiente) {
        this.siguiente = siguiente;
    }
}
