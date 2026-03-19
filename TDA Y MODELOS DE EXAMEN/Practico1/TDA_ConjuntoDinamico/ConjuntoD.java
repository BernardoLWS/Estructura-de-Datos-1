package TDA_ConjuntoDinamico;
import java.util.BitSet;

public class ConjuntoD {
    private BitSet elementos;
    private int capacidad;

    // Constructor sin número de elementos (comienza vacío)
    public ConjuntoD() {
        this.elementos = new BitSet();
        this.capacidad = 0;
    }

    // Método para insertar un elemento en el conjunto
    public void insertar(int elemento) {
        elementos.set(elemento); // Marca el bit correspondiente al elemento
        capacidad = Math.max(capacidad, elemento + 1);
    }

    // Método para eliminar un elemento del conjunto
    public void eliminar(int elemento) {
        elementos.clear(elemento);
        ajustarCapacidad();
    }

    // Método para verificar si un elemento está en el conjunto
    public boolean contiene(int elemento) {
        return elementos.get(elemento);
    }

    // Método para ajustar la capacidad cuando se elimina un elemento
    private void ajustarCapacidad() {
        for (int i = capacidad - 1; i >= 0; i--) {
            if (elementos.get(i)) {
                capacidad = i + 1;
                return;
            }
        }
        capacidad = 0;
    }

    // Método para obtener el tamaño actual del conjunto
    public int tamaño() {
        return elementos.cardinality(); // Cuenta bits activos
    }

    // Método para imprimir el conjunto
    public void imprimir() {
        System.out.print("Conjunto: { ");
        for (int i = 0; i < capacidad; i++) {
            if (elementos.get(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("}");
    }

    // Programa de prueba
    public static void main(String[] args) {
        ConjuntoD conjunto = new ConjuntoD();

        // Insertando elementos
        conjunto.insertar(3);
        conjunto.insertar(7);
        conjunto.insertar(1);
        conjunto.insertar(5);

        conjunto.imprimir();
        System.out.println("Tamaño del conjunto: " + conjunto.tamaño());

        // Eliminando elementos
        conjunto.eliminar(7);
        conjunto.imprimir();
        System.out.println("Tamaño después de eliminar: " + conjunto.tamaño());

        // Verificando elementos
        System.out.println("¿Contiene 5? " + conjunto.contiene(5));
        System.out.println("¿Contiene 7? " + conjunto.contiene(7));

        // Eliminando más elementos y revisando el ajuste de capacidad
        conjunto.eliminar(3);
        conjunto.eliminar(5);
        conjunto.eliminar(1);
        conjunto.imprimir();
        System.out.println("Tamaño final: " + conjunto.tamaño());
    }
}