package TDA_Ave;

public class Ave {
    //Atributos :
        char Sexo ;   //M -> Macho  ,  H -> Hembra
        int Edad ;
        static int NroAvesCreadas = 0 ;
    //Constructor :
    public Ave(char Sexo,int Edad){
        this.Sexo = Sexo;
        this.Edad = Edad;
        NroAvesCreadas++;  //incrementa al crear nuevas aves
    }
    //Getters :
    public char getSexo(){
        return Character.toUpperCase(Sexo); //transformamos el caracter en mayuscula
    }
    public int getEdad(){
        return Edad;
    }
    public static int getNroAvesCreadas(){
        return NroAvesCreadas;
    }
    //Setters :
    public void setSexo(char Sexo){
        this.Sexo=Sexo;
    }
    public void setEdad(int Edad){
        this.Edad=Edad;
    }
    public void QuienSoy(){
        String sexo;
        if (getSexo() == 'M'){
            sexo = "Macho";
        }else{
            sexo= "Hembra"; 
        }
        
        System.out.println("sexo: "+ sexo + "\nEdad: "+getEdad()+" años");
    }
}//Fin Ave
