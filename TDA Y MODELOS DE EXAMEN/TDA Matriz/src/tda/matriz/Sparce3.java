/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.matriz;

/**
 *
 * @author Marco Alejandro
 */
public class Sparce3 {
    int VD[];
    int VFC[];
    int dim;
    int m;
    int n;
    int e; 
    public Sparce3(int nf,int nc){
        VFC=new int[10];
        VD=new int[10];
        n=nc;
        m=nf;
        dim=-1;
        e=0;
    }
    public void setDato(int f, int c, char signo,int num, int deno){
        if (num>=0 && num<=9 && deno>=1 && deno<=9 && (signo=='+' || signo=='-')) {
            if ((f>0)&&(c>0)&&(f<=m)&&(c<=n)) {
                int mask;
                if (signo=='+') {
                    mask=1; //1
                }else{
                    mask=0;
                }
                mask=mask<<4;//1 0000
                mask=mask|num;//1 1110
                mask=mask<<4;//1 1110 0000
                mask=mask|deno;//1 1110 0100
                int fc=(f-1)*n+c;
                int pos=buscar(fc);
                if (pos != -1) {
                    if (num==e) {
                        dim--;
                        for (int i = pos; i < dim; i++) {
                            VFC[i]=VFC[i+1];
                            VD[i]=VD[i+1];
                        }
                    }else{
                        VD[pos]=mask;
                    }
                }else{
                    if (num!=e) {
                        Redimensionar();
                        dim++;
                        VD[dim]=mask;
                        VFC[dim]=(f-1)*n+c;
                    }
                }
            }else{
                System.out.println("Error:la Fila o Columna este fuera de rango");
            }    
        }else{
            if (num<0 && num>9) {
                System.out.println("Error:El numerador no pertenece al rango [0..9]");
            }else if (deno<1 && deno>9) {
                System.out.println("Error:El Denominador no pertenece al rango [1..9]");
            }else if (signo !='+' || signo !='-') {
                System.out.println("Error:El signo no es un signo + O -");
            }
 
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
            int vaux[]=new int[dim+10];
            System.arraycopy(VD, 0, vaux, 0, dim+1);
            VD=new int[dim+10];
            System.arraycopy(vaux, 0, VD, 0, dim+1);
            int vfc2[]=new int[dim+10];
            System.arraycopy(VFC, 0, vfc2, 0, dim+1);
            VFC=new int[dim+10];
            System.arraycopy(vfc2, 0, VFC, 0, dim+1);
        }
    }
    
   private char getsigno(int p) {
        if (p != -1) {
            int mask = VD[p];
            int signo = (mask >>> 8) & 1; ////0 0000 0001 and 0 0000 0001 = 1
            if (signo == 1) {
                return '+';
            } else {
                return '-';
            }
        }
        return ' ';
    }
   private int getnum(int p) {
        if (p != -1) {
            int mask = VD[p];
            int numerador = (mask >>> 4) & 15;//0 0001 1110 and 0 0000 1111 = 1
            return numerador;
        }
        return -1; // error
    }

    private int getdeno(int p) {
        if (p != -1) {
            int mask = VD[p];
            int denominador = mask & 15;
            return denominador;
        }
        return -1; // error
    }
    
    public String getDato(int f, int c){
        String valor=String.valueOf(e);
        if ((f>0)&&(c>0)&&(f<=m)&&(c<=n)) {
            int pos = buscar((f-1)*n+c);
            if (pos!=-1) {
                valor=getsigno(pos)+""+getnum(pos)+"/"+getdeno(pos);              
            }
        }else{
            System.out.println("Error: Fila o Columna fuera de rango"); 
        }
        return valor;
    }
    
    private String repetirEspacios(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
        sb.append(" ");
    }
    return sb.toString();
}
   private String centrarTexto(String texto, int ancho) {
        int espacio = ancho - texto.length();
        int espacioIzquierda = espacio / 2;
        int espacioDerecha = espacio - espacioIzquierda;
        return repetirEspacios(espacioIzquierda) + texto + repetirEspacios(espacioDerecha);
   }
//    float peso = VD[pos] / 10.0f;
//            valor = String.format("%.1f", peso);
    public String toStringFila(int fila) {
        String s = "";
        if (fila > 0 && fila <= m) {
            for (int i = 0; i < n; i++) {
                String dato = getDato(fila, i + 1);
                s += "[" + centrarTexto(dato, 7) + "]";
            }
        }
        return s;
    }
}
