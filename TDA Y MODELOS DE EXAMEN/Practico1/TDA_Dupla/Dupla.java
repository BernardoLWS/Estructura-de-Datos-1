package TDA_Dupla;
    public class Dupla {
    // Atributos de la dupla
    int primero,segundo;

    // Constructor para inicializar la dupla
    public Dupla(int primero, int segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }
    public int getPrimero(){
        return primero;
    }
    public int getSegundo(){
        return segundo;
    }
    public void setPrimero(int primero){
     this.primero = primero;
    }
    public void setSegundo(int segundo){
        this.segundo = segundo;
    }
    // Método para crear una nueva dupla
    public static Dupla crear(int primero, int segundo) {
        return new Dupla(primero, segundo);
    }

    // Método para obtener el primer elemento
    public int primero() {
        return this.primero;
    }

    // Método para obtener el segundo elemento
    public int segundo() {
        return this.segundo;
    }

    // Método para multiplicar ambos valores de la dupla por un múltiplo
    public static Dupla multiplicar(Dupla d, int multiplo) {
        return new Dupla(d.primero * multiplo, d.segundo * multiplo);
    }

    // Método para adicionar un valor a ambos elementos de la dupla
    public static Dupla adicionar(Dupla dupla, int adicion) {
        return new Dupla(dupla.primero + adicion, dupla.segundo + adicion);
    }

    // Método para sumar dos duplas
    public static Dupla sumar(Dupla a, Dupla b) {
        return new Dupla(a.primero + b.primero, a.segundo + b.segundo);
    }

    // Método para restar dos duplas
    public static Dupla restar(Dupla a, Dupla b) {
        return new Dupla(a.primero - b.primero, a.segundo - b.segundo);
    }

    // Método para mostrar los valores de la dupla (útil para depuración)
    public String toString() {
        return "Dupla [primero=" + primero + ", segundo=" + segundo + "]";
    }
    
    public static void main(String[] args) {
    Dupla d1 = Dupla.crear(2,3);
    Dupla d2 = Dupla.crear(5,7);
    System.out.println("d1: "+d1);     System.out.println("d2: "+d2);
    d1 = multiplicar(d1, 2);
    System.out.println("Multiplo en d1: "+d1);
    d1 = adicionar(d1, 5);
    System.out.println("Adicion en d1: "+d1);
    d1= sumar(d1, d2);
    System.out.println("Suma d1 + d2: "+d1);
    d1 = restar(d1, d2);
    System.out.println("Resta d1 - d2: "+d1);
    }
}//Fin class Dupla
