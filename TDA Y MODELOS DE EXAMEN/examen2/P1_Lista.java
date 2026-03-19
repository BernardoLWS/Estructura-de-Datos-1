package examen2;
/*
Dada una lista circular implementar :
1.- metodo de l class lista circular que me permita insertar bajo la sighuenteforma : 
* si es par se inserta por la 1ra posicion
* si es impar se insertapor la ultimaposicion
Ej :  
    insertar (3)        L -> [3] (fin ->[3])
    insertar (10)       L -> [10]->[3] (fin->[10])
    insertar (7)        L -> [10]->[3]->[7] (fin->[10])
*/
public class P1_Lista {
    Nodo_LC Primero;   //Nodo cabeza
    int N;              //contador
    public P1_Lista(){
        Primero = null;
        N = 0;
    } 
    public void insertarFinal(Object e){
        Nodo_LC nuevo = new Nodo_LC();
        nuevo.setElem(e);
        if (Primero == null) {
            Primero = nuevo;
            Primero.setRS(Primero);
        }else{
            Nodo_LC aux = new Nodo_LC();
            aux = Primero;
            while (aux.getRS() != Primero){
                aux = aux.getRS();
            }
            aux.setRS(nuevo);
            nuevo.setRS(Primero);
        }
        N++;
    }
    public void insertarInicio(Object e){
        Nodo_LC nuevo = new Nodo_LC();
        nuevo.setElem(e);
        if (Primero == null) {
            Primero = nuevo;
            Primero.setRS(Primero);
        }else{
            Nodo_LC aux = new Nodo_LC();
            aux = Primero;
            while (aux.getRS() != Primero){
                aux = aux.getRS();
            }
            aux.setRS(nuevo);
            nuevo.setRS(Primero);
            Primero = nuevo;
        }
        N++;
    }
    public void insertarPI(Object e){
        Nodo_LC nuevo = new Nodo_LC();
        nuevo.setElem(e);
        int x = (int)e;
        if(x%2 == 0){
            insertarInicio(e);
        }else{
            insertarFinal(e);
        }
    }
    public String toString(){
        if (Primero == null) {
            System.out.println("La lista esta vacia.");
            return "C->null";
        }else{
            String S = "C->";
            Nodo_LC p = Primero;
            do{
                S = S + p.getElem() + "->";
                p = p.getRS();
            }while (p != Primero);
            return S + "Primero...";
        }
    }
    public static void main(String[] args){
         P1_Lista c=new P1_Lista();
         c.insertarPI(10);
          c.insertarPI(1);
           c.insertarPI(8);
            c.insertarPI(11);
         System.out.println(c.toString());
    }
}
