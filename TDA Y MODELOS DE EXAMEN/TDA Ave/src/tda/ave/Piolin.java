/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.ave;

/**
 *
 * @author Marco Alejandro
 */
public class Piolin extends Canario {
    private int numeroPeliculas; //AL DIBUJO ANIMADO DE PIOLIN 

    public Piolin(char sexo, int edad, double tamaño, int numeroPeliculas) {
        super(sexo, edad, tamaño);
        this.numeroPeliculas = numeroPeliculas;
    }
    public static void main(String[] args) {
            Piolin p = new Piolin('M', 2, 10, 5);
            Loro l = new Loro('F', 4, 'S',"Rojo");
            Canario C = new Canario('M', 3, 23);
            p.quienSoy();
            l.quienSoy();
            p.altura();
            p.setTamaño(31);
            p.altura();
            l.deDondeEres();
            l.setRegion('e');
            l.deDondeEres();
            System.out.println(Ave.numeroAvesCreadas + " Aves Creadas");
    }
}
