/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.booleanox;

/**
 *
 * @author Marco Alejandro
 */
public class booleanoX {
     private int valor;

    public booleanoX(int valor) { //0 o 1
        this.valor = valor;
    }

    public int valor() {
        return valor;
    }

    public void Negado() {
        if (valor==0) {
            this.valor=1;
        }else{
            this.valor=0;
        }
    }

    public booleanoX y(booleanoX otro) { // y  and 1 * 0 = 0
        return new booleanoX(this.valor * otro.valor);
    }

    public booleanoX o(booleanoX otro) { // 0 o 0 = 0
        if (this.valor + otro.valor == 2) {
            return new booleanoX(1);
        }else{
            return new booleanoX(this.valor + otro.valor);
        }
    }
}
