/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.matriz;

/**
 *
 * @author Marco Alejandro
 */
public class Sparce {
    float VD[];
    int VFC[];
    int dim;
    int m; //numero de filas
    int n; //numero de columnas
    int e; //Elemento dominante
    
    public Sparce(int nf,int nc,int ele){
        VFC=new int[10];
        VD=new float[10]; //float == real == Decimales
        n=nc;
        m=nf;
        dim=-1;
        e=ele;
    }

    public int getM() {
        return m; //Fila
    }

    public int getN() {
        return n; //Columna
    }
    
    public void setDato(int f, int c, float dato){
        if ((f>0)&&(c>0)&&(f<=m)&&(c<=n)) {
            int fc=(f-1)*n+c;
            int pos=buscar(fc);
            if (pos != -1) { //SI PILLO LA POSICION EXISTE FILA Y COLUMNA CON DATO
                if (dato==e) {
                    dim--;
                    for (int i = pos; i < dim; i++) {
                        VFC[i]=VFC[i+1];
                        VD[i]=VD[i+1];
                    }
                }else{
                    VD[pos]=dato;
                }
            }else{ //NO PILLO LA POSICION EXISTE EL ELEMENTO DOMINANTE EN LA FILA Y LA COLUMNA
                if (dato != e) {
                    Redimensionar();
                    dim++;
                    VD[dim]=dato;
                    VFC[dim]=(f-1)*n+c;
                }
            }
        }else{
            System.out.println("Error:la Fila o Columna este fuera de rango");
        }
    }
    
    private int buscar(int fc){
        int i=0;
        while ((i<=dim)&&(VFC[i]!=fc)){
            i++;
        }  
        if (i>dim) {
            return -1;
        }else{
            return i;
        }
    }
    
    private void Redimensionar(){
        if ((dim%9==0)&&(dim!=0)) {
            float vaux[]=new float[dim+10];
            System.arraycopy(VD, 0, vaux, 0, dim+1);
            VD=new float[dim+10];
            System.arraycopy(vaux, 0, VD, 0, dim+1);
            int vfc2[]=new int[dim+10];
            System.arraycopy(VFC, 0, vfc2, 0, dim+1);
            VFC=new int[dim+10];
            System.arraycopy(vfc2, 0, VFC, 0, dim+1);
        }
    }
    
    public float getDato(int f, int c){
        float valor=e; //0
        if ((f>0)&&(c>0)&&(f<=m)&&(c<=n)) {
            int pos = buscar((f-1)*n+c);//-1
            if (pos!=-1) {
                valor=VD[pos];
            }
        }else{
            System.out.println("Error: Fila o Columna fuera de rango"); 
        }
        return valor;
    }
    
    public void MostrarVectores(){
        for (int i = 0; i <= dim; i++) {
            System.out.println(VD[i]+" "+VFC[i]);
        }
    }
    public String toStringFila(int fila){
        String s="";
        if ((fila>0)&&(fila<=m)) {
            for (int i = 1; i <= n; i++) {
                s=s+"["+getDato(fila,i)+"]";
            }
        }
        return s;
    }
}
