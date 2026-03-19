/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.matriz;

/**
 *
 * @author Marco Alejandro
 */
public class Fraccion {
    
    // Se llama atributos en el modelado
    // Se llama campos en la implemantacion
    int numerador; // representa el numerador y el signo
    int denominador; 
    //No esta signo porque no guarda un dato importante

    // Constructor por defecto
    public Fraccion() { // 0/1
        this.numerador = 0;
        this.denominador = 1;
    }

    // Constructor sobrecargado
    public Fraccion(char signo, int numerador, int denominador) { //(-,2,3)
        if (denominador == 0) {
            System.out.println("Error::Racional:Denominador debe ser diferente de 0");
            System.exit(1);
        } else {
            if (signo == '+') {
                this.numerador = +Math.abs(numerador);
            } else {
                this.numerador = -Math.abs(numerador); //-2/3
            }
            this.denominador = Math.abs(denominador);
        }
    }

    // Modifica el numerador del racional
    public void setNumerador(int numerador) { //20/4 -> 5/1
        if (this.numerador >= 0) {
            this.numerador = +Math.abs(numerador);
        } else {
            this.numerador = -Math.abs(numerador);
        }
        Simplificar();
    }

    // Modifica el denominador del racional
    public void setDenominador(int denominador) {
        if (denominador == 0) {
            System.out.println("Error::SetDenominador:Denominador debe ser diferente de 0");
            System.exit(1);
        } else {
            this.denominador = Math.abs(denominador);
        }
      Simplificar();
    }

    // Modifica el signo del racional
    public void setSigno(char signo) { //- (+4) -> -4
        if (signo == '+') {
            this.numerador = +Math.abs(numerador);
        } else {
            this.numerador = -Math.abs(numerador);
        }
    }

    // Devuelve el numerador del racional
    public int getNumerador() {
        return Math.abs(numerador);
    }

    // Devuelve el denominador de racional
    public int getDenominador() {
        return this.denominador;
    }

    // Devuelve el signo del racional
    public char getSigno() { // 3 -> +    -3 -> -
        if (this.numerador >= 0) {
            return '+';
        } else {
            return '-';
        }
    }

    // Sumar racionales
    public void Suma(Fraccion A, Fraccion B) { //C.Suma(A,B) 1/4 - 1/2 
        this.denominador = A.denominador * B.denominador; //8
        this.numerador = (A.numerador * B.denominador) + (A.denominador * B.numerador); // 4/5+3/3= (2-4)/8 -> -4/8 -> -1/4
        Simplificar();
    }

    // Restar racionales
    public void Resta(Fraccion A, Fraccion B) {
        this.denominador = A.denominador * B.denominador;
        this.numerador = (A.numerador * B.denominador) - (A.denominador * B.numerador);// 4/5-3/3= (12-15)/15 -> 3/15 -> 1/5
        Simplificar();
    }

    // Multiplicar racionales
    public void Multiplicacion(Fraccion A, Fraccion B) {
        this.numerador = A.numerador * B.numerador; //4/5 * 3/2 = 12/10 -> 6/5
        this.denominador = A.denominador * B.denominador;
        Simplificar();
    }
    
    // Dividir racionales
    public void Division(Fraccion A, Fraccion B) { 
        this.numerador = A.numerador * B.denominador; //4/5 div -2/3 = 6/-10 -> -6/10   6/-10 == -6/10  -> -3/5
        this.denominador = A.denominador * B.numerador;
        if (this.denominador < 0) {
            this.numerador = this.numerador * -1;
            this.denominador = Math.abs(this.denominador); // Math.abs TRANSFORMA AL VALOR DE ABSOLUTO
        }
        Simplificar();
    }

    //Cálculo del máximo común divisor por el algoritmo de Euclides
    public int mcd() { //32/6-> 2
        int u = Math.abs(this.numerador); //valor absoluto del numerador
        int v = Math.abs(this.denominador); //valor absoluto del denominador //0.03 -> 0
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v; // 32 MOD 6 -> 2    6 MOD 2 -> 0
            u = v; //32 -> 6 -> 2
            v = r; //6 -> 2 -> 0
        }
        return u; //2
    }
    
    // Simplica un racional
    public void Simplificar() {
        int n = mcd(); //se calcula el mcd de la fracción
        //32/6
        this.numerador = this.numerador / n; //32 DIV 2 -> 16
        this.denominador = this.denominador / n; //6 DIV 2 -> 3
        //32/6 -> 16/3
    }
    
    @Override //toString() automaticamente solo colocando el nombre de la variable de la clase ya lo dibuja System.out.printl(C) == System.out.printl(C.toString)
    public String toString() {
        String c="F=";
        c ="     " + getNumerador() + "\n" + c + getSigno() + " ---" + "\n     " + getDenominador();
        return c;
    }
    public String AString(){
        String c=getSigno()+""+getNumerador()+"/"+getDenominador();
        return c;
    }
}