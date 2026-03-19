package TDA_Bolsa;
import java.util.HashMap;
import java.util.Map;

public class Bolsa<T> {
    private Map<T, Integer> elementos;

    // Constructor: Crea una bolsa vacía
    public Bolsa() {
        this.elementos = new HashMap<>();
    }

    // Añadir un elemento a la bolsa
    public void añadir(T elemento) {
        elementos.put(elemento, elementos.getOrDefault(elemento, 0) + 1);
    }

    // Verificar si la bolsa está vacía
    public boolean bolsaVacia() {
        return elementos.isEmpty();
    }

    // Verificar si un elemento pertenece a la bolsa
    public boolean dentro(T elemento) {
        return elementos.containsKey(elemento);
    }

    // Determinar el número de veces que un elemento está en la bolsa
    public int cuantos(T elemento) {
        return elementos.getOrDefault(elemento, 0);
    }

    // Unión de dos bolsas
    public void union(Bolsa<T> otraBolsa) {
        for (Map.Entry<T, Integer> entrada : otraBolsa.elementos.entrySet()) {
            elementos.put(entrada.getKey(), elementos.getOrDefault(entrada.getKey(), 0) + entrada.getValue());
        }
    }

    // Obtener el número total de elementos en la bolsa
    public int total() {
        int total = 0;
        for (int cantidad : elementos.values()) {
            total += cantidad;
        }
        return total;
    }

    // Mostrar los elementos de la bolsa
    public String toString() {
        return elementos.toString();
    }

    public static void main(String[] args) {
        Bolsa<String> bolsa = new Bolsa<>();
        bolsa.añadir("manzana");
        bolsa.añadir("pera");
        bolsa.añadir("manzana");

        System.out.println("Bolsa: " + bolsa);
        System.out.println("¿Bolsa vacía?: " + bolsa.bolsaVacia());
        System.out.println("¿Dentro 'manzana'?: " + bolsa.dentro("manzana"));
        System.out.println("Cuántas 'manzana': " + bolsa.cuantos("manzana"));
        System.out.println("Total elementos: " + bolsa.total());
    }
}
