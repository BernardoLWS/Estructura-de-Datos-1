/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tda.fecha;

/**
 *
 * @author Marco Alejandro
 */
public class TDAFecha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Crear fecha directamente con números
        Fecha f1 = new Fecha(19, 4, 2025);
        System.out.println("Fecha creada con numeros: " + f1);
        System.out.println("Es bisiesto? " + f1.esBisiesto());
        System.out.println();

        // 2. Crear fecha usando texto con año de 2 dígitos (ddmmaa)
        char[] fechaCorta = {'0', '5', '0', '6', '2', '4'}; // 05/06/2024
        Fecha f2 = new Fecha(0, 0, 0); // Inicializamos vacía
        f2.TextoanioDosDigitos(fechaCorta);
        System.out.println("Fecha desde texto corto: " + f2);
        System.out.println("Es bisiesto? " + f2.esBisiesto());
        System.out.println();

        // 3. Crear fecha usando texto con año completo (ddmmaaaa)
        char[] fechaLarga = {'1', '0', '1', '2', '2', '0', '3', '0'}; // 10/12/2030
        Fecha f3 = new Fecha(0, 0, 0); // Inicializamos vacía
        f3.TextoanioCompleto(fechaLarga);
        System.out.println("Fecha desde texto largo: " + f3);
        System.out.println("Es bisiesto? " + f3.esBisiesto());
        int day=f3.dia();
        System.out.println("Fecha en numeros " + day);
    }
    
}
