/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Marco Alejandro
 */
public class Polinomio {
    Monomio P[]; //[4X3,8X3,]
    int dim;

    public Polinomio() {
        this.P = new Monomio[5]; //maximo[4X3,8X3,9X7,8X1,4x2]
        this.dim = -1; //[]
    }
    public Polinomio(int cant){ //4
        dim=-1;
        P=new Monomio[cant];
        for (int i = 0; i < cant; i++) {
            P[i]=new Monomio('+',0,0);//[0x0,0x0,0x0,0x0]
        } //[+0x0,+0x0]
    }

    public void Insertar(Monomio A) { //2X8
        if (vacia()) {
            dim++; //0
            P[dim] = A; //0 ->A
        } else {
            int aux = 0;
            while ((aux <= dim) && (P[aux].getExponente() < A.getExponente())) {
                aux++;
            } //pone en orden de exponente [1x2,-2X5,0x0,0x0]
            if (aux <= dim) {
                if (P[aux].getExponente() != A.getExponente()) {
                    Redimensionar();
                    for (int i = dim; i >= aux; i--) {
                        P[i + 1] = P[i];   
                    }
                    P[aux] = A;
                    dim++;
                } else {
                    int suma = A.coeficiente + P[aux].coeficiente; //4x6 -> -2x6 -> 2x6
                     //[1x2,-2X5,0x0,0x0]
                    if (suma != 0) {
                        P[aux].coeficiente = suma; //[1x2,0X5,0x0,0x0]
                    } else {
                        for (int j = aux; j < dim; j++) {
                            P[j] = P[j + 1];   //[1x2,0X0,0x0,0x0]
                        }
                        dim--;
                    }
                } 
            } else {
                Redimensionar(); //aumentar los maximos[1x2,3X5,0X0]
                dim++; 
                P[dim] = A; //[1x2,3X5,2X8]
            }
        }
    }

    private boolean vacia() {
        return (dim == -1);
    }
    public int cantidad(){
        return dim + 1;
    }
    
    private void Redimensionar() {
        if (P.length - 1 == dim) {
            Monomio Copia[] = new Monomio[P.length];
            System.arraycopy(P, 0, Copia, 0, P.length);
            P = new Monomio[P.length + 10];
            System.arraycopy(Copia, 0, P, 0, Copia.length);
        }
    }
    
    public void Eliminar(int exp){
        if (!vacia()){
            int i = 0;
            while ((i <= dim) && (exp != P[i].getExponente())) {
                i++;
            }
            if (i < dim){
                for (int j = i; j < dim; j++){
                    P[j] = P[j+1]; //6,5,4,3 -> 6,4,3  [4X9,9X7,8X1,4x2]
                }
                dim--;
            } else if (i == dim){
                this.P[i] = null;
                dim--;
            }
        }
    }
    
    public double Evaluar(int x){ ///X=2 [1x2,3X5]
        double suma = 0;
        for (int i = 0; i <= dim; i++){
            suma = suma + P[i].coeficiente * Math.pow(x, P[i].getExponente()); //SUMA 4 + 66
        }
        return suma; //100
    }
    
    public Monomio getMonomio(int Exp) {
        int i = 0;
        while (P[i].getExponente() != Exp && i<=dim) {
            i++;
        }
        return P[i];
    } 
    
    private int posGrado(int x){//[1x2,3X5]
        int i=0;
        while(P[i].exponente!=x && i<=dim){
            i++;
        }
        if (i<=dim) {
            return i;
        }else{
            return -1;
        }
    }

    public void Sumar(Polinomio A, Polinomio B){ //C.sumar(a,b)
        for (int i = 0; i <= A.dim; i++){
            this.Insertar(A.P[i]);
        }
        for (int i = 0; i <= B.dim; i++){
            this.Insertar(B.P[i]);
        }
    }
    
    public void Restar(Polinomio A, Polinomio B){
        for (int i = 0; i <= A.dim; i++) {
            Insertar(A.P[i]);
        }
        for (int j = 0; j <= B.dim; j++) {
            if (B.P[j].getSigno()=='+') {
                B.P[j].setSigno('-');
                Insertar(B.P[j]);
            }else{
                B.P[j].setSigno('+');
                Insertar(B.P[j]);
            }
        }
    }
        
    public void Multiplicar(Polinomio A, Polinomio B){     //7x2+4x3 * x3                                                       
        Monomio M = new Monomio();
        for (int i = 0; i <= A.dim; i++){ 
            for (int j = 0; j <= B.dim; j++){
                M.coeficiente = A.P[i].coeficiente * B.P[j].coeficiente;
                M.exponente = A.P[i].exponente + B.P[j].exponente;
                this.Insertar(M);
            }
        }
    }
    
    @Override
    public String toString() {
        String S = "P(x)=";
        for (int i = 0; i <= dim; i++) {
            S = S + P[i] + " ";
        }
        return S;
    }
    public String toString2(){
        String S="P(x)=";
        for (int i = 0; i <= dim; i++) {
            S=S+P[i];
        }
        return S;
    }
}
