package TDA_Ave;
public class Loro extends Ave {
    //Atributos :
    char Region;
    String Color ;
    //Constructor :
    public Loro(char Sexo,int Edad,char Region,String Color){
        super(Sexo,Edad);
        this.Region = Region;
        this.Color = Color;
    }
    //Getters :
    public char getRegion(){
        return Region;
    }
    public String getColor(){
        return Color;
    }
    //Setters :
    public void setRegion(char Region){
        this.Region=Region;
    }
    public void setColor(String Color){
        this.Color=Color;
    }
    //Metodo :
    public void DeDondeEres(){
        switch (Character.toUpperCase(getRegion())){ //toUpperCase tranforma de minuscula a mayuscula
            case 'N': System.out.println("Region: Norte");break;
            case 'S': System.out.println("Region: Sur");break;
            case 'E': System.out.println("Region: Este");break;
            case 'O': System.out.println("Region: Oeste");break;
            default : System.out.println("no existe esa region");break;
        }
    }
    public void CambiarRegion(char NuevaRegion){
        setRegion(NuevaRegion);
        System.out.print("Cambiamos la region a -> ");
        DeDondeEres();
    }
}//Fin Loro
