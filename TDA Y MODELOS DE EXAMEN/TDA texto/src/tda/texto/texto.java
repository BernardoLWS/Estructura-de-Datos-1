/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.texto;

/**
 *
 * @author Marco Alejandro
 */
public class texto {//hola
    private char[] contenido; //[h,o,l,a]
    private int tamaño;
    
    public texto(){
        this.contenido = new char[128]; //[0..127]
        this.tamaño=0;
    }
    
    public int tamaño(){
        return this.tamaño;
    }
    
    public void destruir() {
        this.contenido = null;
        this.tamaño = 0;
    }

    public char caracterEn(int posicion) { //[h,o,l,a] 
        if (posicion < 0 || posicion >= this.tamaño) {
            //llamamos a una excepcion
            throw new IndexOutOfBoundsException("Posición inválida.");
        }
        return this.contenido[posicion]; //P0 -> h de [h,o,l,a]
    }

    public void añadirCaracter(char c) {
        if (this.tamaño < 128) {
            this.contenido[this.tamaño] = c;
            this.tamaño++;
        }else{
            throw new IndexOutOfBoundsException("Ya no hay espacio");
        }
    }

    @Override
    public String toString() {//[h,o,l,a] -> hola
        return new String(this.contenido, 0, this.tamaño);
    }
}

