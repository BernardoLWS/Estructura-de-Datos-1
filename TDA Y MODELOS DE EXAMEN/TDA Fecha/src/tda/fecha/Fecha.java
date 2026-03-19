/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.fecha;

/**
 *
 * @author Marco Alejandro
 */
public class Fecha {
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public void TextoanioDosDigitos(char[] fechaTexto) {
        this.dia = Integer.parseInt("" + fechaTexto[0] + fechaTexto[1]);
        this.mes = Integer.parseInt("" + fechaTexto[2] + fechaTexto[3]);
        this.año = 2000 + Integer.parseInt("" + fechaTexto[4] + fechaTexto[5]);
    }
    
    public void TextoanioCompleto(char[] fechaTexto) {
        this.dia = Integer.parseInt("" + fechaTexto[0] + fechaTexto[1]);
        this.mes = Integer.parseInt("" + fechaTexto[2] + fechaTexto[3]);
        this.año = Integer.parseInt("" + fechaTexto[4] + fechaTexto[5] + fechaTexto[6] + fechaTexto[7]);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    public boolean esBisiesto() {
//Regla para determinar si un año es bisiesto
//Si el año es divisible por 4, es bisiesto. 
//Si el año es divisible por 100, pero no por 400, no es bisiesto. 
//Si el año es divisible por 100 y por 400, es bisiesto. 
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }
    
    public int dia(){
        int day= Integer.parseInt("" + this.dia + this.mes + this.año);
        return day;
    }
}
