/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Marco Alejandro
 */
public class Conjuntobits {
    Bitwise C[];
    int cant; //MAXIMO ELEMENTO A COLOCAR
    public Conjuntobits(int NEle){
        int Nbw=NEle/32;
        if (NEle%32!=0) {
            Nbw++;
        }
        this.C=new Bitwise[Nbw];
        cant=NEle;
        for (int i = 0; i <= Nbw-1; i++) {
            C[i]=new Bitwise();
        }
    }
    
    public void insertar(int ele){ //45
        if (ele<=cant) {
            int NBW=CalcNBW(ele); //1
            int Nbit=CalcNbit(ele);//13
            C[NBW].SetBit1(Nbit);
        }else{
            System.out.println("Error::ConjuntoBit:Insertar:Elemento fuero de rango");
            System.exit(1);
        }
    }
    
    public void Eliminar(int ele){
        if (ele<=cant) {
            int NBW=CalcNBW(ele);
            int Nbit=CalcNbit(ele);
            C[NBW].SetBit0(Nbit);
            System.out.println(C[NBW].toString());
        }else{
            System.out.println("Error::ConjuntoBit:Eliminar:Elemento fuero de rango");
            System.exit(1);
        }
    }
    
    private int CalcNBW(int ele){
        return((ele-1)/32); //32
    }
    
    private int CalcNbit(int ele){ //45
        return((ele-1)%32)+1; //13
    }
    
    public boolean Pertenece(int ele){
        int NBW=CalcNBW(ele);
        int Nbit=CalcNbit(ele);
        return(C[NBW].GetBit(Nbit)==1);
    }
    
    public void Union(Conjuntobits A,Conjuntobits B){
        for (int i = 0; i <= A.cant; i++) {
            if (A.Pertenece(i)) {
                insertar(i);
            }    
        }
        for (int j = 0; j <= B.cant; j++) {
            if (B.Pertenece(j)) {
                insertar(j);
            }    
        }
    }
    
    public void interseccion(Conjuntobits A,Conjuntobits B){
        for (int i = 0; i <= A.cant; i++) {
            if (B.Pertenece(i)&& A.Pertenece(i)) {
                insertar(i);
            }
        }
    }
    
    @Override
    public String toString(){
        String S="C={";
        for (int i = 0; i <= cant; i++) {
            if (Pertenece(i)) {
                S=S+i+" ";
            }
        }
        S=S+"}";
        return S;
    }
}
