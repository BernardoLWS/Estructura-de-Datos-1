package TDA_ComplejoReal;
public class ComplejoReal {
     double real, imaginario;
     
    // Constructor por defecto
    public ComplejoReal() {
        this.real = 0.0;
        this.imaginario = 0.0;
    }

    // Método para establecer valores
    public void establecer(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    // Método para imprimir el número complejo
    public void imprimir() {
        System.out.println(this.real + " + " + this.imaginario + "i");
    }

    // Método sobrecargado para agregar otro número complejo
    public void agregar(ComplejoReal otro) {
        this.real += otro.real;
        this.imaginario += otro.imaginario;
    }

    // Método sobrecargado para agregar dos valores dobles
    public void agregar(double real, double imaginario) {
        this.real += real;
        this.imaginario += imaginario;
    }

    public static void main(String[] args) {
        // Creación de números complejos
        ComplejoReal c1 = new ComplejoReal();
        c1.establecer(2.5, 3.5);
        System.out.print("Número complejo 1: ");
        c1.imprimir();

        ComplejoReal c2 = new ComplejoReal();
        c2.establecer(1.5, -2.0);
        System.out.print("Número complejo 2: ");
        c2.imprimir();

        // Agregación de otro número complejo
        c1.agregar(c2);
        System.out.print("Después de agregar c2 a c1: ");
        c1.imprimir();

        // Agregación de valores dobles
        c1.agregar(3.0, 1.0);
        System.out.print("Después de agregar (3.0, 1.0) a c1: ");
        c1.imprimir();
        }
}
