package examen2;
  public class Lista_C {
    Nodo_LC Primero;   //Nodo cabeza
    int N;              //contador
    public Lista_C(){
        Primero = null;
        N = 0;
    }
    public void insertar(Object e){
        Nodo_LC nuevo = new Nodo_LC();
        nuevo.setElem(e);
        if (Primero == null) {
            Primero = nuevo;
            Primero.setRS(Primero);
        }else{
            Nodo_LC aux = new Nodo_LC();
            aux = Primero;
            while (aux.getRS() != Primero){
                aux = aux.getRS();
            }
            aux.setRS(nuevo);
            nuevo.setRS(Primero);
        }
        N++;
    }
    public void insertarInicio(Object e){
        Nodo_LC nuevo = new Nodo_LC();
        nuevo.setElem(e);
        if (Primero == null) {
            Primero = nuevo;
            Primero.setRS(Primero);
        }else{
            Nodo_LC aux = new Nodo_LC();
            aux = Primero;
            while (aux.getRS() != Primero){
                aux = aux.getRS();
            }
            aux.setRS(nuevo);
            nuevo.setRS(Primero);
            Primero = nuevo;
        }
        N++;
    }
    public void insertar(Object e, int pos){
        Nodo_LC nuevo = new Nodo_LC();
        nuevo.setElem(e);
        if (Primero == null || pos <= 0) {
            insertarInicio(e);
        }else{
            if (pos >= N) {
                insertar(e);
            }else{
                Nodo_LC aux = new Nodo_LC();
                aux = Primero;
                pos--;
                while(pos > 0){
                    aux = aux.getRS();
                    pos--;
                }
                nuevo.setRS(aux.getRS());
                aux.setRS(nuevo);
                 N++;
            }
        }
    }
    public Object consultarInicio(){
        return Primero.getElem();
    }
    public Object consultar(){
        Nodo_LC aux = new Nodo_LC();
        aux = Primero;
        while (aux.getRS() != Primero){
            aux = aux.getRS();
        }
        return aux.getElem();
    }
    public Object consultar(int pos){
        Nodo_LC aux = new Nodo_LC();
        aux = Primero;
        if (pos >= N-1) {
            return consultar();
        }else{
            if (pos <= 0) {
                return consultarInicio();
            }else{
                while (pos > 0){
                    aux = aux.getRS();
                    pos--;
                }
            }
        }
        return aux.getElem();
    }
    public void eliminarInicio(){
        if (N == 1) {
            Primero = null;
        }else{
            Nodo_LC aux = new Nodo_LC();
            aux = Primero;
            while (aux.getRS() != Primero){
                aux = aux.getRS();
            }
            aux.setRS(Primero.getRS());
            Primero = aux.getRS();
        }
        N--;
    }
    public void eliminar(){
        if (N == 1) {
            Primero = null;
        }else{
            Nodo_LC aux = new Nodo_LC();
            aux = Primero;
            int i = N - 2;
            while (i > 0){
                aux = aux.getRS();
                i--;
            }
            aux.setRS(aux.getRS().getRS());
        }
        N--;
    }
    public void eliminar(int pos){
        if (pos <= 0 || N == 1) {
            eliminarInicio();
        }else{
            if (pos >= N-1) {
                eliminar();
            }else{
                Nodo_LC aux = new Nodo_LC();
                aux = Primero;
                pos--;
                while (pos > 0){
                    aux = aux.getRS();
                    pos--;
                }
                aux.setRS(aux.getRS().getRS());
            }
        }
        N--;
    }
    public int getLongitud(){
        return N;
    }
    
    @Override
    public String toString(){
        if (Primero == null) {
            System.out.println("La lista esta vacia.");
            return "C->null";
        }else{
            String S = "C->";
            Nodo_LC p = Primero;
            do{
                S = S + p.getElem() + "->";
                p = p.getRS();
            }while (p != Primero);
            return S + "Primero...";
        }
    }
    
}