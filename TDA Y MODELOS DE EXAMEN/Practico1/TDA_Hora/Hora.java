package TDA_Hora;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    // Constructor para inicializar la hora
    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        ajustarHora(); // Ajustar posibles valores incorrectos
    }

    // Métodos de acceso
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    // Método para imprimir la hora
    public void imprimir() {
        System.out.printf("%02d:%02d:%02d\n", horas, minutos, segundos);
    }

    // Método para adelantar la hora
    public void adelantar(int h, int m, int s) {
        this.horas += h;
        this.minutos += m;
        this.segundos += s;
        ajustarHora();
    }

    // Método para reiniciar la hora
    public void reiniciar(int h, int m, int s) {
        this.horas = h;
        this.minutos = m;
        this.segundos = s;
        ajustarHora();
    }

    // Método privado para ajustar valores incorrectos
    private void ajustarHora() {
        if (segundos >= 60) {
            minutos += segundos / 60;
            segundos %= 60;
        }
        if (minutos >= 60) {
            horas += minutos / 60;
            minutos %= 60;
        }
        if (horas >= 24) {
            horas %= 24; // Se asume un reloj de 24 horas
        }
    }

    public static void main(String[] args) {
        // Creación de objetos de hora
        Hora hora = new Hora(23, 59, 50);
        System.out.print("Hora inicial: ");
        hora.imprimir();

        // Adelantar la hora
        hora.adelantar(0, 0, 15);
        System.out.print("Después de adelantar 15 segundos: ");
        hora.imprimir();

        // Reiniciar la hora
        hora.reiniciar(12, 30, 45);
        System.out.print("Después de reiniciar: ");
        hora.imprimir();
    }
}