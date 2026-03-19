/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda.matriz;

/**
 *
 * @author Marco Alejandro
 */
public class Sparce4 {
    char VDS[];
    int VDN[];
    int VDD[];
    int VFC[];
    int dim;
    int m;
    int n;
    int e; 
    public Sparce4(int nf,int nc){
        VFC=new int[10];
        VDS=new char[10];
        VDD=new int[10];
        VDN=new int[10];
        n=nc;
        m=nf;
        dim=-1;
        e=0;
    }
    public void setDato(int f, int c, char signo,int num, int deno){
        if (num>=0 && num<=9 && deno>=1 && deno<=9 && (signo=='+' || signo=='-')) {
            if ((f>0)&&(c>0)&&(f<=m)&&(c<=n)) {
                Fraccion naux=new Fraccion(signo,num,deno);
                int fc=(f-1)*n+c;
                int pos=buscar(fc);
                if (pos != -1) {
                    if (naux.numerador==e) {
                        dim--;
                        for (int i = pos; i < dim; i++) {
                            VFC[i]=VFC[i+1];
                            VDS[i]=VDS[i+1];
                            VDN[i]=VDN[i+1];
                            VDD[i]=VDD[i+1];
                        }
                    }else{
                        VDS[pos]=signo;
                        VDN[pos]=num;
                        VDD[pos]=deno;
                    }
                }else{
                    if (naux.numerador!=e) {
                        Redimensionar();
                        dim++;
                        VDS[dim]=signo;
                        VDN[dim]=num;
                        VDD[dim]=deno;
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
            char vfc2[]=new char[dim+10];
            System.arraycopy(VDS, 0, vfc2, 0, dim+1);
            VDS=new char[dim+10];
            System.arraycopy(vfc2, 0, VDS, 0, dim+1);
            
            int vfc3[]=new int[dim+10];
            System.arraycopy(VDN, 0, vfc3, 0, dim+1);
            VDN=new int[dim+10];
            System.arraycopy(vfc3, 0, VDN, 0, dim+1);
            
             int vfc4[]=new int[dim+10];
            System.arraycopy(VDD, 0, vfc4, 0, dim+1);
            VDD=new int[dim+10];
            System.arraycopy(vfc4, 0, VDD, 0, dim+1);
            
            int vfc5[]=new int[dim+10];
            System.arraycopy(VFC, 0, vfc5, 0, dim+1);
            VFC=new int[dim+10];
            System.arraycopy(vfc5, 0, VFC, 0, dim+1);
        }
    }
    
    public String getDato(int f, int c){
        String valor=String.valueOf(e);
        if ((f>0)&&(c>0)&&(f<=m)&&(c<=n)) {
            int pos = buscar((f-1)*n+c);
            if (pos!=-1) {
                valor=VDS[pos]+""+VDN[pos]+"/"+VDD[pos];
                //System.out.println(VD[pos].getSigno()+" "+VD[pos].getNumerador()+"/"+VD[pos].);
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
