/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Marco Alejandro
 */
public class Complejo {
   // Atributos
    float Preal; 
    int Pimag; 
    
    // Constructor vacio
    public Complejo() { //C = new Complejo();
      Preal=0;
      Pimag=0;
    }
    
    // Constructor con argumentos
    public Complejo(float real, int imaginario) { //C = new Complejo(2.87,3);
        this.Preal = real;
        this.Pimag = imaginario;
    }
    
    // Operaciones o Metodos
    public float getReal() {
        return this.Preal; //->2.87
    }

    public void setReal(float real) {
        this.Preal = real;
    }

    public int getImaginario() {
        return this.Pimag;
    }

    public void setImaginario(int imaginario) {
        this.Pimag = imaginario;
    }
   
    public void sumar(Complejo A, Complejo B) {
        this.Preal=A.Preal+B.Preal;
        this.Pimag=A.getImaginario()+B.getImaginario();
    }
    
    public void restar(Complejo A, Complejo B) {
        this.Preal=A.Preal-B.Preal;
        this.Pimag=A.getImaginario()-B.getImaginario();
    }

    @Override
    public String toString() {
        String S="C{"; //C{-2.87,3i}
        if (Preal>0) {
            S=S+'+';
            S=S+Preal;
        }else if (Preal<0) {
            S=S+'-'; //C{-2.87
            S=S+(-Preal);
        }
        if (Pimag>0) {
            S=S+'+';
            S=S+Pimag+"i}";//C{-2.87,3i}
        }else if (Pimag<0) {
            S=S+'-';
            S=S+(-Pimag)+"i}";
        }
        return S;
    } 
}
