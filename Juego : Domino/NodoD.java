package domino;
public class NodoD {
     int N1;
     int N2;
    NodoD EnlaceD;
    NodoD EnlaceI;
    
    public NodoD(int N1,int N2){
      //  Random rand = new Random();
        this.N1=N1;
        this.N2=N2;
        this.EnlaceD = null;
        this.EnlaceI = null;
    }
    public void setN1(int N1){
        this.N1=N1;
    }
    public void setN2(int N2){
        this.N2=N2;
    }
    public int getN1(){
        return this.N1;
    }
     public int getN2(){
        return this.N2;
    }
    public void setEnlaceD(NodoD EnlaceD){
        this.EnlaceD = EnlaceD;
    }
    public void setEnlaceI(NodoD EnlaceI){
        this.EnlaceI = EnlaceI;
    }
    public NodoD getEnlaceD() {
        return EnlaceD;
    }
    public NodoD getEnlaceI() {
        return EnlaceI;
    }
}






















    /*public static void main(String[] args) {
        // Crear tres fichas de dominó aleatorias
        NodoD ficha1 = new NodoD();
        NodoD ficha2 = new NodoD();
        NodoD ficha3 = new NodoD();

        // Enlazar las fichas (como si fueran una lista doblemente enlazada)
        ficha1.setEnlaceD(ficha2);
        ficha2.setEnlaceI(ficha1);
        ficha2.setEnlaceD(ficha3);
        ficha3.setEnlaceI(ficha2);

        // Mostrar las fichas
        System.out.println("Ficha 1: [" + ficha1.getN1() + "|" + ficha1.getN2() + "]");
        System.out.println("Ficha 2: [" + ficha2.getN1() + "|" + ficha2.getN2() + "]");
        System.out.println("Ficha 3: [" + ficha3.getN1() + "|" + ficha3.getN2() + "]");

        // Recorrer hacia adelante
        System.out.println("\nRecorrido hacia adelante:");
        NodoD actual = ficha1;
        while (actual != null) {
            System.out.println("[" + actual.getN1() + "|" + actual.getN2() + "]");
            actual = actual.getEnlaceD();
        }

        // Recorrer hacia atrás
        System.out.println("\nRecorrido hacia atrás:");
        actual = ficha3;
        while (actual != null) {
            System.out.println("[" + actual.getN1() + "|" + actual.getN2() + "]");
            actual = actual.getEnlaceI();
        }
    }
}*/
