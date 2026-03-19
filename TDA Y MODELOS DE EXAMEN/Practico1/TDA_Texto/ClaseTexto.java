package TDA_Texto;

//import jdk.javadoc.internal.tool.Main;

public class ClaseTexto {
  //Atributos :
     char[] Caracteres;
     int LongitudMax = 128;
     int TamañoActual;
   //Constructor CrearTexto:
     public ClaseTexto(){
         this.Caracteres = new char [LongitudMax];
         this.TamañoActual = 0;
     }  
    //Metodo destruir texto :
     public void Destruir(){
         this.Caracteres = null;
         this.TamañoActual = 0;
     }
     //mostrar tamaño actual:
     public int Tamaño(){
         return TamañoActual;
     }
     //buscar caracten :
     public char CaracterEn(int posicion){
         char x = ' ';
         if (posicion>0 && posicion<TamañoActual){
             x = Caracteres[posicion];
         }else{
             System.err.println("Error : Fuera de rango");
         }
         return x;
     }  
     //metodos adicionales :
        public void AgregarCaracter(char c){
            if (TamañoActual < LongitudMax){
                Caracteres[TamañoActual] = c;
                TamañoActual++;
                System.out.println(Caracteres);
            }else{
                System.err.println("Error : Imposible agregar caracter ,limite de 128 alcanzado");
            }
        }
       public String ComoCadena(){
       return new String(Caracteres,0,TamañoActual);
       } 
       
       //Main :
       public static void main(String[] args){
           //Mostrar Tamaño actual y longitud total:
           ClaseTexto Texto = new ClaseTexto(); 
           System.out.println("\nLongitud: " + Texto.LongitudMax + "\nTamaño:" + Texto.TamañoActual);
           
           //agregar texto :
           Texto.AgregarCaracter('y');
           Texto.AgregarCaracter('g');
           System.out.println("\nLongitud: " + Texto.LongitudMax + "\nTamaño:" + Texto.TamañoActual);
           Texto.ComoCadena();
           
           //Buscar Caracter :
           System.out.println(Texto.CaracterEn(1));
          
           //Destruir :
           Texto.Destruir();
           System.out.println("\nLongitud: " + Texto.LongitudMax + "\nTamaño:" + Texto.TamañoActual);
       
           
           
       }
                
}//Fin ClaseTexto
