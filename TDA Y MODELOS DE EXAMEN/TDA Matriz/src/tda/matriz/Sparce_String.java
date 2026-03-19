/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda.matriz;

/**
 *
 * @author Marco Alejandro
 */
public class Sparce_String {
    char VD[];
    int dim;
    int m; //numero de filas
    int n; //numero de columnas
    char e; //Elemento dominante
    
    public Sparce_String(){
        VD=new char[10]; //float == real
        dim=-1;
        e=' ';
    } 
    
    public void setDato(String Cad){
        //sout
        int tamaño=Cad.length();
        n=(int)Math.sqrt(tamaño); //4.34534 -> 4
        m=(int)Math.sqrt(tamaño)+2;
        for (int i = 0; i < n*m; i++) {
            Redimensionar();
            if (i<tamaño) {  
                VD[i]=Cad.charAt(i);
            }else{
                VD[i]=e;
            }
            
            dim++;
        }
    }
    
//    private int buscar(int fc){
//        int i=0;
//        while ((i<=dim)&&(VFC[i]!=fc)){
//            i++;
//        }  
//        if (i>dim) {
//            return -1;
//        }else{
//            return i;
//        }
//    }
    
    private void Redimensionar(){
        if ((dim%9==0)&&(dim!=0)) {
            char vaux[]=new char[dim+10];
            System.arraycopy(VD, 0, vaux, 0, dim+1);
            VD=new char[dim+10];
            System.arraycopy(vaux, 0, VD, 0, dim+1);
        }
    }
    
    public String toStringFila(int fila){
        String s="";
        if ((fila>=0)&&(fila<m)) {
            if (fila==0) {
              for (int i = 0; i < n; i++) {
                s=s+"["+VD[i]+"]";
                }  
            }else{
                for (int i = fila*n; i < (fila*n)+n; i++) {
                    s=s+"["+VD[i]+"]";
                }
            }
        }
        return s;
    }
}