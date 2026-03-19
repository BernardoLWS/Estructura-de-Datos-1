package TDA_Punto;
import java.awt.Color;

public class Punto {
    // Atributos del punto
    int x, y, tamaño;
    Color color;
    boolean visible;
    // Constructor
    public Punto(int x, int y, Color color, int tamaño, boolean visible) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.tamaño = tamaño;
        this.visible = visible;
    }
    // Métodos
    // Método para crear un punto (puede ser un constructor o inicialización)
    public static Punto crearPunto(int x, int y, Color color, int tamaño, boolean visible) {
        return new Punto(x, y, color, tamaño, visible);
    }
    // Método para mover el punto a nuevas coordenadas
    public void moverPunto(int nuevoX, int nuevoY) {
        this.x = nuevoX;
        this.y = nuevoY;
    }
    // Método para cambiar el color del punto
    public void ponerColor(Color nuevoColor) {
        this.color = nuevoColor;
    }
    // Método para cambiar el tamaño del punto
    public void cambiarTamaño(int nuevoTamaño) {
        this.tamaño = nuevoTamaño;
    }
    // Método para hacer visible o invisible el punto
    public void cambiarVisibilidad(boolean visibilidad) {
        this.visible = visibilidad;
    }
    // Método para obtener información del punto
    public String toString() {
        return "Punto [x=" + x + ", y=" + y + ", color=" + color + ", tamaño=" + tamaño + ", visible=" + visible + "]";
    }
    public static void main(String[] args) {
        Punto p = Punto.crearPunto(0,0,Color.BLACK,0,false);
        System.out.println("nuevoPunto -> "+p);
        p.moverPunto(5, 8);
        System.out.println("moverPunto -> "+p);
        p.ponerColor(Color.yellow);
        System.out.println("cambiarColor -> "+p);
        p.cambiarTamaño(10);
        System.out.println("cambiarTamaño -> "+p);
        p.cambiarVisibilidad(true);
        System.out.println("cambiarVisibilidad -> "+p);
    
    }
}//Fin class punto
