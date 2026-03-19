package examen3;
/*
intecalar pila comp max 1 pila o cola aux
Ej: pila[6,5,4,3,2,1]  -> Pila[4,5,6,1,2,3]
*/
public class P1_Pila {
    NodoP cima ;
    int cant;
    int max;
    public P1_Pila(){
        cima = null; //apunta a null cima el el ultimo nodo
        cant = 0;   //sin elementos
        max =6;
    }
    public boolean vacio(){
        return cant==0;
    }
    public boolean llena(){
        return cant>=max;
    }
    public void apilar(int ele) {
        NodoP p = new NodoP();
        p.setDato(ele);
        p.setEnlace(cima);
        cima = p;
        cant++;
    }
    public int desapilar() {
        if (!vacio()) {
            int x = cima.getDato();
            cima = cima.getEnlace();
            cant--;
            return x;
        } else {
            return -1;
        }
    }
    public void IntercalarMitad(){
        P1_Pila aux = new P1_Pila();  //creando nueva pila
        int mitad = cant/2; //trabaje hasta la mitad
        for (int i = 0; i < mitad; i++) {  //recorre 
             aux.apilar(this.desapilar()); //agrega a pila aux ->(4,5,6)->null
             this.cant--;
        }  
        // System.out.println("aux\n"+aux);   //aux[4,5,6] , pila[3,2,1]
        
         //ciclo para intercalar la pila
         NodoP prev = null;
         NodoP actual = cima;  //pila[(3),2,1]
         NodoP sig;
        while (actual != null) {    // si actual hay datos
             sig = actual.getEnlace();   // sig = [2]           |[1]               |null
             actual.setEnlace(prev);     // actual = [3]->null  |[2]->[3]->null    |[1]->[2]-[3]->null
             prev = actual;              // prev = [3]          |[2]               |[1]
             actual = sig;               // actual = [2]        |[1]               |null
        }                               
        cima = prev; //cima -> [1]   Resultado: cima → [1] → [2] → [3] → null
        
        //ciclo para invertir la otra mitad (aux) 
         NodoP anterior = null;
         NodoP presente = aux.cima; 
         NodoP posterior;
        while (presente != null) {   
             posterior = presente.getEnlace();   
             presente.setEnlace(anterior);     
             anterior = presente;             
             presente = posterior;              
        } 
        aux.cima = anterior;
        
        //ahora agraremos la aux a pila
        for(int i = 0;i<mitad;i++){
            this.apilar(aux.desapilar());
        }
    }
   
    public String toStringP1() {
        String S = "cima\n";
        NodoP aux = cima;
        while (aux != null) {
            S += "["+aux.getDato();
            if (aux.getEnlace() != null){
                S +="]\n";
            }
            aux = aux.getEnlace();
        }
        S += "]\n";
        return S;
    }
     public static void main(String[] args) {
        P1_Pila p = new P1_Pila();
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
         p.apilar(4);
          p.apilar(5);
           p.apilar(6);
         System.out.println(p.toStringP1());
        p.IntercalarMitad();
        System.out.println(p.toStringP1());
    }
}
