package TDA_Cinta;

public class Cinta {
    private String cinta;
    private int cabezal;
    private boolean enPausa;

    // Constructor que inicializa la cinta y el cabezal en la primera posición
    public Cinta(String contenido) {
        this.cinta = contenido;
        this.cabezal = 0;
        this.enPausa = false;
    }

    // Método para avanzar el cabezal a la siguiente posición
    public void avanzar() {
        if (!enPausa && cabezal < cinta.length() - 1) {
            cabezal++;
        }
    }

    // Método para retroceder el cabezal a la posición anterior
    public void retroceder() {
        if (!enPausa && cabezal > 0) {
            cabezal--;
        }
    }

    // Método para obtener el carácter actual al que apunta el cabezal
    public char cc() {
        return cinta.charAt(cabezal);
    }

    // Método para registrar un carácter en la posición actual
    public void REG(char nuevoCaracter) {
        StringBuilder sb = new StringBuilder(cinta);
        sb.setCharAt(cabezal, nuevoCaracter);
        cinta = sb.toString();
    }

    // Método para mover el cabezal a la siguiente palabra (salta hasta el próximo espacio)
    public void siguientePalabra() {
        while (cabezal < cinta.length() - 1 && cinta.charAt(cabezal) != ' ') {
            avanzar();
        }
        avanzar(); // Para saltar el espacio
    }

    // Método para retroceder hasta el espacio anterior
    public void retrocederPalabra() {
        while (cabezal > 0 && cinta.charAt(cabezal) != ' ') {
            retroceder();
        }
        if (cabezal > 0) {
            retroceder(); // Para llegar antes del espacio
        }
    }

    // Método para pausar el avance del cabezal
    public void pausa() {
        enPausa = true;
    }

    // Método para reanudar el movimiento del cabezal
    public void reanudar() {
        enPausa = false;
    }

    // Método para reiniciar el cabezal a la primera posición
    public void stop() {
        cabezal = 0;
        enPausa = false;
    }

    // Método para imprimir el estado actual de la cinta
    public void imprimir() {
        System.out.println("Cinta: " + cinta);
        System.out.println("Cabezal en posición: " + cabezal + " ('" + cc() + "')");
    }

    public static void main(String[] args) {
        Cinta cinta = new Cinta("Hola mundo desde Java");
        cinta.imprimir();

        cinta.avanzar();
        cinta.imprimir();

        cinta.siguientePalabra();
        cinta.imprimir();

        cinta.retrocederPalabra();
        cinta.imprimir();

        cinta.REG('X');
        cinta.imprimir();

        cinta.pausa();
        cinta.avanzar(); // No avanzará porque está en pausa
        cinta.imprimir();

        cinta.reanudar();
        cinta.avanzar();
        cinta.imprimir();

        cinta.stop();
        cinta.imprimir();
    }
}
