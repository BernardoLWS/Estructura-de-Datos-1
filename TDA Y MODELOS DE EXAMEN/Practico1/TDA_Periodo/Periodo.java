package TDA_Periodo;
public class Periodo {
    //atributos:
    int DiaInicio , DiaFin;
    int MesInicio , MesFin;
    int AñoInicio , AñoFin;
    //costructor:
    public Periodo(int DiaInicio,int DiaFin,int MesInicio,int MesFin,int AñoInicio,int AñoFin){
        this.DiaInicio=DiaInicio;   this.DiaFin=DiaFin;
        this.MesInicio=MesInicio;   this.MesFin=MesFin;
        this.AñoInicio=AñoInicio;   this.AñoFin=AñoFin;
    }
    //Getter:
    public int getDiaFin(){
        return DiaFin;
    }
    public int getMesFin(){
        return MesFin;
    }
    public int getAñoFin(){
        return AñoFin;
    }
    //Setters:
    public void setDiaFin(int DiaFin){
        this.DiaFin = DiaFin;
    }
    public void setMesFin(int MesFin){
        this.MesFin = MesFin;
    }
    public void setAño(int AñoFin){
        this.AñoFin = AñoFin;
    }
    //metodos:
    public void Mostrar(){
        System.out.println("Inicio: "+DiaInicio+"/"+MesInicio+"/"+AñoInicio+" ->  Hasta :"+DiaFin+"/"+MesFin+"/"+AñoFin);
    }
    public void CrearDia(int dias){
        while(dias>30){
            dias -=30;
            this.MesFin+=1;
            if(this.MesFin>12){
                this.AñoFin+=1;
                this.MesFin=1;
            }    
        }
         this.DiaFin= dias;
    }
    public void CrearMesDia(int dias,int meses){
     CrearDia(dias);
     while(meses>12){
         meses-=12;
         this.AñoFin+=1;
     }
     this.DiaFin = dias;
     this.MesFin = meses;
    }
    public void CrearAñoMesDia(int dias,int meses,int años){
    CrearMesDia(dias,meses);
    this.AñoFin += años;
    }
    public static int TraducirADias(Periodo p){
        int DiasTotales = 0;
       DiasTotales += p.getDiaFin();
       DiasTotales += p.MesFin*30;
       DiasTotales += (p.AñoFin-p.AñoInicio)*365; 
       return DiasTotales;
    }
    public static void main(String[] args) {
      Periodo p = new Periodo(1,1,1,1,2025,2025);
       p.CrearDia(120); 
       p.Mostrar();
       p.CrearMesDia(30,13);
       p.Mostrar();
       p.CrearAñoMesDia(15,5,5);
       p.Mostrar();
       System.out.println(TraducirADias(p));
    }
}//Fin class periodo
