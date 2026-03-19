/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Marco Alejandro
 */
public class Bitwise {
    int x; //Unico atributo
    public Bitwise(){
        this.x = 0;
    }
    
    public void SetBit1(int pos){
        if (pos<=32) {
            int mask=1;
            mask=mask<<pos-1;
            x=x|mask;
        }
    }
    
    public void SetBit0(int pos){
        if (pos<=32) {
            int mask=1;
            mask=mask<<pos-1;
            mask=~mask;
            x=x&mask;
        }
    }
    
    public int GetBit(int pos){
        int mask=1;
        mask=mask<<pos-1;//P1
        mask=mask&x;//P2
        mask=mask>>>pos-1;//P3    
        return mask;
    }
    
    @Override
    public String toString(){
        String S="X=";
        for (int i = 32; i >= 1; i--) {
            S=S+""+GetBit(i);
        }
        System.out.println(x);
        return S;
    }
}
