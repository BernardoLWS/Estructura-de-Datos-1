package TDA_Ave;
public class Piolin extends Canario {   
    //Atributos :
    int NroDePeliculas;
    
    //constructor :
    public Piolin(char Sexo,int Edad,float Tamaño,int NroDePeliculas){
        super(Sexo,Edad,Tamaño);
        this.NroDePeliculas = NroDePeliculas;
    }
      //Getters :
    public int getNroDePeliculas(){
        return NroDePeliculas;
    }
    //Setters :
    public void setNroDePeliculas(int NroDePeliculas){
        this.NroDePeliculas = NroDePeliculas;
    }
    
     public static void main(String[] args) {
        //1.- Instancias de piolin :
        Piolin p = new Piolin('m',2,3,5); // (sexo,edad,tamaño,NroDePeliculas)
        System.out.println("\nInformacion de piolin:");
        p.QuienSoy();
        //Instancia de Loro :
        Loro l = new Loro('h',3,'o',"rojo"); //(sexo,edad,regiom,color)
        System.out.println("\nInformacion de loro:");
        l.QuienSoy();
        //2.- Metodo altura de piolin :
        p.Altura();
        //3.- metodo DeDondeEres :
         l.DeDondeEres();
        //4.- modificar el tamaño piolin e invocar el metodo altura
        p.setTamaño(8);
        p.Altura();
        //5.- modificar la region del loro
        l.setRegion('s');
        l.DeDondeEres();
        //6.- mostrar el numero de aves creadas
        System.out.println("Nro de aves creadas: " + getNroAvesCreadas());
    }
}//Fin Piolin
