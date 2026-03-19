package TDA_Matriz;

public class Matriz {
    private int filas, columnas;
    private double[][] elementos;

    // Constructor: Crear matriz vacía
    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        elementos = new double[filas][columnas];
    }

    // Asignar valor a una celda
    public void asignar(int i, int j, double valor) {
        if (i >= 0 && i < filas && j >= 0 && j < columnas) {
            elementos[i][j] = valor;
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Obtener valor de una celda
    public double obtenerElemento(int i, int j) {
        if (i >= 0 && i < filas && j >= 0 && j < columnas) {
            return elementos[i][j];
        } else {
            System.out.println("Índice fuera de rango.");
            return Double.NaN;
        }
    }

    // Suma de dos matrices
    public Matriz sumar(Matriz otra) {
        if (this.filas != otra.filas || this.columnas != otra.columnas) {
            System.out.println("Las matrices deben tener las mismas dimensiones.");
            return null;
        }
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.asignar(i, j, this.obtenerElemento(i, j) + otra.obtenerElemento(i, j));
            }
        }
        return resultado;
    }

    // Producto escalar
    public Matriz productoEscalar(double escalar) {
        Matriz resultado = new Matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.asignar(i, j, this.obtenerElemento(i, j) * escalar);
            }
        }
        return resultado;
    }

    // Imprimir matriz
    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(elementos[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método de prueba
    public static void main(String[] args) {
        Matriz m1 = new Matriz(2, 2);
        m1.asignar(0, 0, 1);
        m1.asignar(0, 1, 2);
        m1.asignar(1, 0, 3);
        m1.asignar(1, 1, 4);
        
        System.out.println("Matriz 1:");
        m1.imprimir();

        Matriz m2 = new Matriz(2, 2);
        m2.asignar(0, 0, 5);
        m2.asignar(0, 1, 6);
        m2.asignar(1, 0, 7);
        m2.asignar(1, 1, 8);

        System.out.println("Matriz 2:");
        m2.imprimir();

        Matriz suma = m1.sumar(m2);
        System.out.println("Suma de Matriz 1 y 2:");
        if (suma != null) suma.imprimir();

        Matriz producto = m1.productoEscalar(2);
        System.out.println("Matriz 1 multiplicada por 2:");
        producto.imprimir();
    }
}
