package examen2;

/**
 * dado una pila implementar 1 metodo de la clase pila para apilar elementos por
 * la base es decir : apilarE (7) p[7] -> cima apilarE (10) p[10 7 ] -> cima
 * apilarE (1) p[1 10 7] -> cima apilar (4) p[4 1 10 7] -> cima
 */
public class P2_Pila {

    NodoP cima;
    int cant; //Cantidad de elementos

    public P2_Pila() {
        cima = null;
        cant = 0;
    }

    public boolean Vacia() {
        return cima == null; //(cant == 0)
    }

    public void Push(int ele) {
        NodoP p = new NodoP();
      
            p.setDato(ele);
            p.setEnlace(cima);
            cima = p;
            cant++;
       
    }

    public int Pop() {
        if (!Vacia()) {
            int x = cima.getDato();
            cima = cima.getEnlace();
            cant--;
            return x;
        } else {
            return -1;
        }
    }

   public void apilarE(int e) {
    // Creamos una pila auxiliar interna
    P2_Pila destino = new P2_Pila();

    if (this.Vacia()) {
        // Primera inserción: se agrega directo
        this.Push(e);
    } else {
        // Mover todo a destino
        while (!this.Vacia()) {
            destino.Push(this.Pop());  
        }
        // Agregar el nuevo elemento
        this.Push(e);
        // Devolver todo lo de destino
        while (!destino.Vacia()) {
            this.Push(destino.Pop());
        }
    }
}

    public String toString() {
        String S = "";
        NodoP Aux = cima;
        while (Aux != null) {
            S = S + Aux.getDato() + "\n";
            Aux = Aux.getEnlace();
        }
        return S;
    }

  
}
