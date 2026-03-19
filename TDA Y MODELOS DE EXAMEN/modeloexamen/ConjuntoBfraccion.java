package modeloexamen;
public class ConjuntoBfraccion {
    int[] C; // Arreglo de fracciones codificadas
    int dim;

    // Constructor: inicializa con espacio para 10 fracciones
    public ConjuntoBfraccion() {
        this.C = new int[10];
        this.dim = -1;
    }

    // Método para verificar si el conjunto está vacío
    public boolean vacia() {
        return dim == -1;
    }

    // Método para insertar una fracción empaquetada en 8 bits
    public void insertar(int num, int den,boolean signo) {
        if (num>=0 && num<=9 && den>0 && den<=9){  // Validacion
            int fraccionX = 0;
            int sig = signo?1:0;
            fraccionX = fraccionX|(sig<<7);
            fraccionX = fraccionX | (num<<3);
            fraccionX = fraccionX | den;
            if (!pertenece(fraccionX)) {
                redimensionar();
                dim++;
                C[dim] = fraccionX;
            }
        }
    }
    //GETTERS :
     public String getsigno(int dim){
        int fx = C[dim];
        fx = fx>>>7;
        if(fx == 1){
            return "+";
        }
        return "-";
    }
    public int getnum(int dim){
        int fx = C[dim];
        fx = fx<<25;
        fx = fx>>>25;
        return fx;
    }
    public int getden(int dim){
        int fx = C[dim];
        fx = fx<<29;
        fx = fx>>>29;
        return fx;
    }
   
    // Método para verificar si una fracción pertenece al conjunto
    public boolean pertenece(int fraccionX) {
        for (int i = 0; i <= dim; i++) {
            if (C[i] == fraccionX) return true;
        }
        return false;
    }
    // Método para aumentar el tamaño del conjunto dinámicamente
    private void redimensionar() {
        if (dim == C.length - 1) {
            int[] C1 = new int[C.length + 1];
            System.arraycopy(C, 0, C1, 0, C.length);
            C = C1;
        }
    }
    // Método para eliminar una fracción
    public void eliminar(int num, int den) {
        int fraccionCodificada = (num << 3) | den;
        if (!vacia()) {
            int i = 0;
            while (i <= dim && C[i] != fraccionCodificada) {
                i++;
            }
            if (i <= dim) {
                for (int j = i; j < dim; j++) {
                    C[j] = C[j + 1];
                }
                dim--;
            }
        }
    }

    // Método para mostrar el conjunto de fracciones decodificadas
    @Override
    public String toString() {
        String S = "S={ ";
        for(int i = 0;i<=dim;i++){
            S +=getsigno(i)+ getnum(i)+"/"+getden(i)+", ";
        }
        S = S+" }";
        return S;
    }
   
    public static void main(String[] args) {
        ConjuntoBfraccion f = new ConjuntoBfraccion();
        f.insertar(3, 4,true);
        f.insertar(0, 2,false);
        f.insertar(5, 6,true);
        f.insertar(5, 0,false);
        f.insertar(5, 6,true);
        System.err.println(f.toString());
    }
}//fin

