/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Marco Alejandro
 */
public class Monomio { //Es solo un dato 4X6
    // Atributos
    int coeficiente; // signo y coeficiente//4 5 65
    int exponente;
    // Costructor vacio
    public Monomio() {
        this.coeficiente = 0;
        this.exponente = 1;
    }

    // Constructor con argumentos
    public Monomio(char signo, int coeficiente, int exponente) {
        if (signo == '+') {
            this.coeficiente = +Math.abs(coeficiente);
        } else {
            this.coeficiente = -Math.abs(coeficiente);
        }
        this.exponente = exponente;
    }

    // Operaciones o metodos
    public int getCoeficiente() { //6x3
        return Math.abs(this.coeficiente);
        //->6
    }

    public void setCoeficiente(int coeficiente) {
        if (coeficiente == 0) {
            System.out.println("Error::Monomio:SetCoeficiente:Coeficiente igual a 0"); //0x3 -> 0
            System.exit(1);
        } else {
            if (coeficiente >= 0) {
                this.coeficiente = +Math.abs(coeficiente);
            } else {
                this.coeficiente = -Math.abs(coeficiente);
            }
        }
    }
    public void SetCoeficiente1(int coe){
        this.coeficiente=coe;
    }

    public int getExponente() { //6x3
        return this.exponente; //->3
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
    
    public char getSigno() {
        if (this.coeficiente >= 0) {
            return '+';
        } else {
            return '-'; 
        }
    }
    
    public void setSigno(char signo) {
        if (signo == '+') {
            this.coeficiente = +Math.abs(this.coeficiente);
        } else {
            this.coeficiente = -Math.abs(this.coeficiente);
        }
    }

    @Override
    public String toString() { //-4x7
        String S = "" + getSigno(); //S=-
        
        S = S + getCoeficiente(); //S=-4
        
        
        if (getExponente() == 1) {
            S = S + "x"; //-4x si el exp es 1 -4x1
        } else if (getExponente() != 0) {
            S = S + "x^" + getExponente(); //-4x^7 si el exp es 0 no pone x
        }
        return S;
    }
    
    public int Evaluar(int x){ //2
        int valor;
        if (x!=0) {
            valor=(int)(coeficiente*Math.pow(x, exponente)); //-4*2^7 ->-512
        }else{
            valor=0;
        }
        return valor;
    }
    public void Sumar(Monomio A, Monomio B){ 
        if (A.getExponente()==B.getExponente()) {
            coeficiente=A.coeficiente+B.coeficiente;
            exponente=A.exponente;
        }
    }
    public void Restar(Monomio A, Monomio B){
        if (A.getExponente()==B.getExponente()) {
            coeficiente=A.coeficiente-B.coeficiente;
            exponente=A.exponente;
        }
    }
    public void Multiplicar(Monomio A, Monomio B){
            coeficiente=A.coeficiente*B.coeficiente;
            exponente=A.getExponente()+B.exponente;
            
    }
    public void Division(Monomio A, Monomio B){
        if (A.getExponente()>=B.getExponente()) {
            coeficiente=A.coeficiente/B.coeficiente;
            exponente=A.exponente-B.exponente; 
        }
    }
    public void Derivar(){
        if (exponente==0) {
            coeficiente=0;
            exponente=1;
        }else{ //5x2
            coeficiente=coeficiente*exponente; //5*2 = 10
            exponente=exponente-1; //2 -> 1  -> 10x1
        }
    }
    public void Integral(){
        if (exponente==0) {
            coeficiente=0;
            exponente=1;
        }else{ //5x2
            exponente=exponente+1; //-> 3
            coeficiente=coeficiente/exponente; //5/3
            //->5/3x3
        }
    }
}
