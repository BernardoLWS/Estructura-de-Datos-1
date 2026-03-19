package domino;
import java.util.Random;
public class ListaD {
    NodoD inicio, fin, mesa;
    int cont;
    // atributos para extremos
     int nIzq;
     int nDer;
    public ListaD() {
        this.cont = 0;
        this.nIzq = -1;
        this.nDer = -1;
    }
    public boolean vacio() {
        return inicio == null;
    }
    public void crearFichas(ListaD mesa){ //crea las 55 fichas en la mesa
        for (int i=0;i<=9;i++){  //crea valor izq de la ficha
            for (int j=i;j<=9;j++){ //crea valor der de la ficha
             NodoD ficha = new NodoD(i,j); // nueva ficha creada
             mesa.insertar(ficha);       // inserta en mesa
             cont++;                    //cant de fichas en mesa
            }
        } 
    }  //crea las 55 fichas en mesa
    public void repartirAleatorio(ListaD jugador1, ListaD jugador2, ListaD mesa) {
    Random rand = new Random(); //objeto random 
    for (int i = 0; i < 27; i++) {  //reparte aleatoriamente 27 fichas al jugador
        NodoD ficha = mesa.obtenerFichaAleatoria(rand);//ciclo para entregar fichas al jugador1
        jugador1.insertar(new NodoD(ficha.getN1(), ficha.getN2()));
        mesa.eliminar(ficha);
        jugador1.cont++;
    }
    for (int i = 0; i < 27; i++) { //ciclo para entregar fichas a la maquina
        NodoD ficha = mesa.obtenerFichaAleatoria(rand);
        jugador2.insertar(new NodoD(ficha.getN1(), ficha.getN2()));
        mesa.eliminar(ficha);
        jugador2.cont++;
    } //una vez entregadas mesa se queda con una ficha
}
    public NodoD obtenerFichaAleatoria(Random rand) {
       //System.out.println(cont);
       int size = cont;
       int index = rand.nextInt(size); // índice aleatorio
         NodoD actual = inicio;        // comienza desde el inicio (nodo 0)
         for (int i = 0; i < index; i++) {  //busca la posicion del nodo
             actual = actual.getEnlaceD();  //devuelve el siguiente nodo
         }
       return actual;                       //devuelve el nodo actual
     }
    public void eliminar(NodoD ficha) {
    if(ficha == inicio){ // ficha esta en el inicio?
        inicio = inicio.getEnlaceD(); //inicio que sea el siguiente
        if (inicio != null) //el siguiente no es nulo?
            inicio.setEnlaceI(null);  //pone en nulo el nodo izq
    }else if(ficha == fin){
          fin = fin.getEnlaceI();
          if (fin != null) fin.setEnlaceD(null);
          }else{
             //CONECTA EL NODO IZQ CON EL DERECHO :
             ficha.getEnlaceI().setEnlaceD(ficha.getEnlaceD());
             //conecta el nodo der con el izq :
             ficha.getEnlaceD().setEnlaceI(ficha.getEnlaceI());
          
          }
    cont--;  //al eliminar un nodo se decrementa el contador
}
    public void insertar(NodoD ficha){
        if(inicio==null){
            inicio=fin=ficha;  // vacio se agrega el nodo ficha
        }else {//A<>B  queremos insertar C
            fin.setEnlaceD(ficha);  //A<>B<>(null)
            ficha.setEnlaceI(fin);  //A<>(B)<>null
            fin = ficha;            //A<>B<>(C)
        } 
    }
    public int getNIzq(){ //devuelve el valor de N1 sino existe es null
    return inicio != null ? inicio.getN1() : -1;
}
    public int getNDer() {//devuelve el valor de N2 sino existe es null
    return fin != null ? fin.getN2() : -1;
}
    public void setNIzq(int valor) {
        this.nIzq = valor;
    }
    public void setNDer(int valor) {
        this.nDer = valor;
    }
    public NodoD buscarFicha(ListaD jugador, int extremoIzq,int extremoDer){
        NodoD actual = jugador.inicio; //comienza la primera ficha
        while (actual != null) {  //no esta vacia [|]?
          int n1 = actual.getN1(); //[n1|]
          int n2 = actual.getN2(); //[n1|n2]
          if(n1 == extremoIzq || n2 == extremoIzq || n1 == extremoDer || n2 == extremoDer) {
            return actual; // utilizara esa ficha par ajugar
          }
        actual = actual.getEnlaceD(); //toma la siguente ficha para verificar
        }
    return null;
}
    public boolean jugarTurno(ListaD jugador, ListaD mesa) {
      int extremoIzq = mesa.getNIzq(); //utiliza el valor izq de la ficha
      int extremoDer = mesa.getNDer(); //utiliza el valor der
      NodoD ficha = buscarFicha(jugador,extremoIzq,extremoDer);
      if (ficha != null) {
         //Eliminar ficha del jugador
           jugador.eliminar(ficha);
           NodoD fichaMesa = new NodoD(ficha.getN1(), ficha.getN2());   
        // Insertar en mesa según el extremo
        if (fichaMesa.getN1() == extremoIzq || fichaMesa.getN2() == extremoIzq) {
            // Insertar al inicio
            fichaMesa = ajustarFichaI(fichaMesa,extremoIzq); //ajusta la ficha para agregar a la mesa
            fichaMesa.setEnlaceD(mesa.inicio);          
            mesa.inicio.setEnlaceI(fichaMesa);
            mesa.inicio = fichaMesa;
        } else {
            // Insertar al final
            System.out.println("["+fichaMesa.getN1()+"|"+fichaMesa.getN2()+"]");
            fichaMesa = ajustarFichaD(fichaMesa,extremoDer);
            System.out.println("["+fichaMesa.getN1()+"|"+fichaMesa.getN2()+"]");
            fichaMesa.setEnlaceI(mesa.fin);
            mesa.fin.setEnlaceD(fichaMesa);
            mesa.fin = fichaMesa;
        }
        mesa.cont++;   
        return true;
    }
      return false;
}
    public NodoD ajustarFichaI(NodoD ficha, int extremo) {
    if (ficha.getN2() == extremo ) { //f[2|3]  <-> fm[2|5]
        // ya está bien              //f[n1|n2]
        return ficha;   //NodoD nueva = ficha;
    } else {
        // intercambiar valores
        int temp = ficha.getN1();  //temp = 2
        ficha.setN1(ficha.getN2()); //n1 = 3   [3|n2]
        ficha.setN2(temp);          //n2 = 2    [3|2]
        //nueva= ficha
    }
     return ficha;  //return nueva
}
    public NodoD ajustarFichaD(NodoD ficha, int extremo) {
    if (ficha.getN1() != extremo){    //f[5|2]  fm[3|4][4|5]([5|2])
         // Girar la ficha
        int temp = ficha.getN1();
        ficha.setN1(ficha.getN2());
        ficha.setN2(temp);
    }
    return ficha;
}
    public String mostrar() {
    NodoD actual = inicio;
    String S = "";
    while (actual != null) {
        S += " [" + actual.getN1() + "|" + actual.getN2() + "] ";
        actual = actual.getEnlaceD();
    }
    return S;
}
    public static void main(String[] args) {
    // jugador 1:
    ListaD user1 = new ListaD();
    //jugador2 : 
    ListaD user2 = new ListaD();
    //mesa : 
    ListaD mesa = new ListaD();
    //crea todas las fichas en mesa :
    mesa.crearFichas(mesa);
    //reparte las ficha cada jugador y sobra en mesa 
    mesa.repartirAleatorio(user1, user2, mesa);
    //muestar fichas en mesa:
    System.out.println("mesa : ");
    mesa.mostrar();
    //muestra fichas del jugador 1:
    System.out.println("jugador1 : ");
    user1.mostrar();
    //muestra fichas del jugador 2:
    System.out.println("jugador 2 :");
    user2.mostrar();
    System.out.println("mesa : ");
    mesa.mostrar();
}
}    