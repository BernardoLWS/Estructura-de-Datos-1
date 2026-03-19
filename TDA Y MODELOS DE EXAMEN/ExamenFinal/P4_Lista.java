
package ExamenFinal;
/**
 *
 * @author Bernardo
 */
public class P4_Lista {
     NodoL L;
    public P4_Lista() {
        L = null;
    }
    public boolean vacio() {
        return L == null;
    }
    public void insertar(int ele) {
    NodoL nuevo = new NodoL();
    nuevo.setDato(ele);
    if (vacio()) {              // caso lista vacía
        L = nuevo;              // el nuevo nodo pasa a ser la cabeza
    } else {
        NodoL aux = L;          // recorrer desde la cabeza
        while (aux.getEnlace() != null) {  // avanzar hasta el último nodo
            aux = aux.getEnlace();
        }
        aux.setEnlace(nuevo);   // enlazar el nuevo al final
    }
}
    public void intercalar() {
        if (vacio()) {  //L-> null
            System.out.println("sin elementos");  
        }else{
             NodoL p = L;
         if(p.getEnlace()==null){//L-> d->null
                System.out.println("hay 1 elemento");
         }else{
              p= p.getEnlace();
              if(p.getEnlace()==null){  
                  System.out.println("hay 2 elemento");
              }else{
                  
                NodoL aux = L;  //1
                NodoL ant = null; //null
             
                int cont = 0;
                int n = 2;
                while (aux != null && cont < n) {
                     ant = aux;  //ant = 1,2
                     aux = aux.getEnlace();  //aux =2,3
                     cont++;    //1,2
                }
                  
                    NodoL temp = L;
                    NodoL a =new NodoL();
                    a = aux;
                    aux.setEnlace(ant);
                    ant.setEnlace(temp);
                    temp.setEnlace(null);
                    L = a;
            
              }
        
         
         }
        }
    }
   

  @Override
   public String toString(){
       String S = "L <  ";
       NodoL aux = L;
       while (aux != null){
          S = S + aux.getDato() +" ,";
          aux = aux.getEnlace();
       }
       S = S+" >";
       return S; 
   }
 
    public static void main(String[] args) {
        P4_Lista lista = new P4_Lista();
         lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        System.out.println("Lista"+lista.toString());
        lista.intercalar();
        System.out.println("Lista"+lista.toString());
        
}
}
