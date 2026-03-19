/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Negocio.Racional;

/**
 *
 * @author Marco Alejandro
 */
public class Monomio_Real {
    // Atributos
    int coef;
    int exp;
    // Costructor vacio
    public Monomio_Real() {
        this.coef = 0;
        this.exp = 0;
    }

    // Constructor con argumentos
    public Monomio_Real(char CC,int NC,int DC, char CE,int NE,int DE) {
        int mask,mask1;
        if (CC=='+') {
            mask=1;
        }else{
            mask=0;
        }
        mask=mask<<4;
        mask=mask|NC;
        mask=mask<<4;
        mask=mask|DC;
        if (CE=='+') {
            mask1=1;
        }else{
            mask1=0;
        }
        mask1=mask1<<4;
        mask1=mask1|NE;
        mask1=mask1<<4;
        mask1=mask1|DE;
        this.coef=mask;
        this.exp=mask1;
    }

    // Operaciones o metodos
    public String getCoeficiente() { //6x3
        String s="";
        int mask=this.coef;
        s=s+(mask&15);
        mask=mask>>4;
        s=s+"/"+(mask&15);
        mask=mask>>4;
        mask=mask&1;
        if (mask==1) {
            s="+"+s;
        }else{
            s="-"+s;
        }
        return s;
    }

    public void setCoeficiente(char CC,int NC,int DC) {
        if (NC== 0) {
            System.out.println("Error::Monomio:SetCoeficiente:Coeficiente igual a 0"); //0x3 -> 0
            System.exit(1);
        } else {
                int mask;
           if (CC=='+') {
               mask=1;
           }else{
               mask=0;
           }
           mask=mask<<4;
           mask=mask|NC;
           mask=mask<<4;
           mask=mask|DC;
           this.coef=mask;
        }
    }

    public String getExponente() { //6x3
        String s="";
        int mask=this.exp;
        s=s+(mask&15);
        mask=mask>>4;
        s=s+"/"+(mask&15);
        mask=mask>>4;
        mask=mask&1;
        if (mask==1) {
            s="+"+s;
        }else{
            s="-"+s;
        }
        return s; //->3
    }

    public void setExponente( char CE,int NE,int DE) {
        int mask1;
        if (CE=='+') {
            mask1=1;
        }else{
            mask1=0;
        }
        mask1=mask1<<4;
        mask1=mask1|NE;
        mask1=mask1<<4;
        mask1=mask1|DE;
        this.exp=mask1;
    }
    
    public void setSigno(char signo) {
        int mask;
        if (signo == '+') {
            mask=1;
            mask=mask<<8;
            this.coef=this.coef|mask;
        } else {
            mask=0;
            mask=mask<<8;
            this.coef=this.coef&mask;
        }
    }

    @Override
    public String toString() { //-4x7
        String S = "";
        int auxN=(this.coef>>4)&15;
        int auxD=this.coef&15;
//        if (auxN == 0) {
//            S = S + getCoeficiente(); //S=-4
//        } else {
//            S = S + getCoeficiente(); //S=-4
//        }
        S = S + getCoeficiente(); 
        S = S + "x^" + getExponente();
//        if (getExponente().getNumerador() == 1) {
//            S = S + "x"; //-4x si el exp es 1 -4x1
//        } else if (getExponente().getNumerador()!= 0 && getExponente().getDenominador()!= 0) {
//            .AString(); //-4x^7 si el exp es 0 no pone x
//        }
        return S;
    }
//    public int Evaluar(int x){ //2
//        int valor;
//        if (x!=0) {
//            valor=(int)(coeficiente*Math.pow(x, exponente)); //-4*2^7 ->-512
//        }else{
//            valor=0;
//        }
//        return valor;
//    }
//    public void Sumar(Monomio A, Monomio B){ 
//        if (A.getExponente()==B.getExponente()) {
//            coeficiente=A.getCoeficiente()+B.getCoeficiente();
//            exponente=A.exponente;
//        }
//    }
//    public void Restar(Monomio A, Monomio B){
//        if (A.getExponente()==B.getExponente()) {
//            coeficiente=A.getCoeficiente()-B.getCoeficiente();
//            exponente=A.exponente;
//        }
//    }
//    public void Multiplicar(Monomio A, Monomio B){
//            coeficiente=A.getCoeficiente()*B.getCoeficiente();
//            exponente=A.getExponente()+B.exponente;
//            
//    }
//    public void Division(Monomio A, Monomio B){
//        if (A.getExponente()>=B.getExponente()) {
//            coeficiente=A.getCoeficiente()/B.getCoeficiente();
//            exponente=A.exponente-B.exponente; 
//        }
//    }
//    public void Derivar(){
//        if (exponente==0) {
//            coeficiente=0;
//            exponente=1;
//        }else{ //5x2
//            coeficiente=coeficiente*exponente; //5*2 = 10
//            exponente=exponente-1; //2 -> 1  -> 10x1
//        }
//    }
//    public void Integral(){
//        if (exponente==0) {
//            coeficiente=0;
//            exponente=1;
//        }else{ //5x2
//            exponente=exponente+1; //-> 3
//            coeficiente=coeficiente/exponente; //5/3
//            //->5/3x3
//        }
//    }
}
