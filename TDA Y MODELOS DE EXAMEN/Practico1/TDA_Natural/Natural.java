package TDA_Natural;
public class Natural {
    //atributos :
    int valor;

    // Constructor para cero : 
    public Natural() {
        this.valor = 0;
    }
    //Getters : 
    public int getValor(){
        return  valor;
    }
    //Setters :
    public void setValor(int nuevoValor){
        this.valor= nuevoValor;
    }

    // Constructor para sucesor
    public Natural(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Los números naturales deben ser no negativos.");
        }
        this.valor = valor;
    }

    // Método para obtener el cero
    public static Natural cero() {
        return new Natural(0);
    }

    // Método para obtener el sucesor
    public Natural sucesor() {
        return new Natural(valor + 1);
    }

    // Método para verificar si es cero
    public boolean esCero() {
        return valor == 0;
    }

    // Método para comparar dos números naturales
    public boolean igual(Natural otro) {
        return this.valor == otro.valor;
    }

    // Método para sumar dos números naturales
    public Natural suma(Natural otro) {
        return new Natural(this.valor + otro.valor);
    }

    // Método para obtener el antecesor (manejo especial para 0)
    public Natural antecesor() {
        if (valor == 0) {
            throw new UnsupportedOperationException("Cero no tiene antecesor en los números naturales.");
        }
        return new Natural(valor - 1);
    }

    // Método para obtener la diferencia entre dos naturales
    public Natural diferencia(Natural otro) {
        if (this.valor < otro.valor) {
            throw new IllegalArgumentException("La diferencia no puede ser negativa en los números naturales.");
        }
        return new Natural(this.valor - otro.valor);
    }

    // Método para verificar si un número es menor que otro
    public boolean menor(Natural otro) {
        return this.valor < otro.valor;
    }

    // Método para imprimir el valor
    public void imprimir() {
        System.out.println(valor);
    }

    public static void main(String[] args) {
        Natural n1 = new Natural(3);
        Natural n2 = new Natural(5);

        System.out.print("Número 1: ");
        n1.imprimir();
        
        System.out.print("Número 2: ");
        n2.imprimir();

        System.out.println("¿Es cero?: " + n1.esCero());
        System.out.println("Sucesor de " + n1.valor + ": " + n1.sucesor().valor);
        System.out.println("Suma de " + n1.valor + " y " + n2.valor + ": " + n1.suma(n2).valor);
        System.out.println("Diferencia entre " + n2.valor + " y " + n1.valor + ": " + n2.diferencia(n1).valor);
        System.out.println(n1.valor + " es menor que " + n2.valor + ": " + n1.menor(n2));
    }
}