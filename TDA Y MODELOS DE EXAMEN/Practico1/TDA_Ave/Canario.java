package TDA_Ave;

public class Canario extends Ave {  //extends vincula canario con clase padre ave
    //Atributos : 
    float Tamaño ; //float = 7 decimales , double = 15-16 decimales 
    //constructores :
    public Canario(char Sexo,int Edad){ //constructor de parametros: sexo y edad
          super(Sexo,Edad); //super envia esos parametros al contructor de la clase padre (ave)
    }
    public Canario(char Sexo,int Edad,float Tamaño){  //constructor de parametros: sexo,edad y tamaño
          super(Sexo,Edad);
          this.Tamaño = Tamaño;
    }
    //getthers :
    public float getTamaño(){
     return Tamaño;
    }
     //Setters :
     public void setTamaño(float Tamaño){
        this.Tamaño = Tamaño;
    }
    //Metodos :
    public void Altura(){
        if(Tamaño>30)
            System.out.println("Altura : alto");
        else
            if(Tamaño >= 15 && Tamaño <= 30)
                System.out.println("Altura : mediano");
            else
                if(Tamaño>0 && Tamaño<15)
                    System.out.println("Altura : bajo");
                else
                    System.err.println("La altura debe de ser mayor a 0");
    }
}// Fin Canario
