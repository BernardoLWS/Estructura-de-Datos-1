package modeloexamen;
public class ConjuntoFraccion {
    Racional C[];
    int dim;
    int num; int den;
    // Constructor
    public ConjuntoFraccion() {
        this.C = new Racional[100];
        this.dim = -1;
    }
    // Método para verificar si el conjunto está vacío
    public boolean vacia() {
        return dim == -1;
    }
    // Método para insertar fracciones evitando duplicados
    public void insertar(int num, int deno,char signo) {
        if (deno == 0) return; // Evita fracciones inválidas

        Racional nueva = new Racional(num, deno,signo);
        if (vacia()) {
            dim++;
            C[dim] = nueva;
        } else {
            if (!pertenece(nueva)) {
                redimensionar();
                dim++;
                C[dim] = nueva;
            }
        }
    }
    // Método para verificar pertenencia de una fracción
    public boolean pertenece(Racional f) {
        for (int i = 0; i <= dim; i++) {
            if (C[i].equals(f)) return true;
        }
        return false;
    }
    // Método para aumentar el tamaño del arreglo
    private void redimensionar() {
        if (dim == C.length - 1) {
            Racional C1[] = new Racional[C.length];
            System.arraycopy(C, 0, C1, 0, C.length);
            C = new Racional[C1.length + 1];
            System.arraycopy(C1, 0, C, 0, C1.length);
        }
    }
    // Método para mostrar el conjunto de fracciones
    @Override
    public String toString() {
       String S = "S={ ";
        for(int i = 0; i<=dim;i++){
            S += C[i].getSigno()+""+C[i].getNume()+"/"+C[i].getDeno()+ ", ";
        }    
        S = S+" }";
        return S;
    }
    public static void main(String[] args) {
        ConjuntoFraccion C  = new ConjuntoFraccion();
        C.insertar(5, 3,'+');
        C.insertar(1, 1,'-');
        C.insertar(4, 7,'+');
        C.insertar(4, 7,'+');
        System.out.println(C.toString());
    }
}//fin 
