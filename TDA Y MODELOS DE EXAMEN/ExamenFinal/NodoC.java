
package ExamenFinal;

public class NodoC{
     int dato;
     NodoC enlace;

    public NodoC(int dato) {
        this.dato = dato;
        this.enlace = null;
    }

    public NodoC() {
        this.dato = 0;
        this.enlace = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoC getEnlace() {
        return enlace;
    }

    public void setEnlace(NodoC enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return String.valueOf(dato);
    }
}
