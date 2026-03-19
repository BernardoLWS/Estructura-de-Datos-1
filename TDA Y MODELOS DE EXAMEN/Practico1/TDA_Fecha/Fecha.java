package TDA_Fecha;
public class Fecha {
    //Atributos :
   int año;
   int mes;
   int dia;
   //Constructor:
   public Fecha(int dia,int mes,int año){
       this.año = año;
       this.mes = mes;
       this.dia = dia;
   }
   //metodo mostarFecha:
   public void MostrarFecha(){
       System.out.println("Fecha : "+dia+"/"+mes+"/"+año);
   }
   public void setDia(int dia){
       this.dia = dia;
   }
   public void setMes(int mes){
       this.mes = mes;
   }
   public void setAño(int año){
       this.año = año;
   }
   //Operacion Crear:
   public void Crear(int dia,int mes,int año){
       this.dia = dia;
       this.mes = mes;
       this.año = año;
       MostrarFecha();
   }
   //Fecha desde texto con 2 digitos 
   public void Año2dig(char[] fechatexto){
       String f = String.valueOf(fechatexto); //de char a string
       dia = Integer.valueOf(f.substring(0,2));
       mes = Integer.valueOf(f.substring(2,4));
       año = Integer.valueOf(f.substring(4,6));
       MostrarFecha();
   }
   public void AñoCompleto(char[] fechatexto){
       String f = String.valueOf(fechatexto); //de char a string
       dia = Integer.valueOf(f.substring(0,2));//de string a int
       mes = Integer.valueOf(f.substring(2,4));
       año = Integer.valueOf(f.substring(4,8));
       MostrarFecha();
   }
   //crear desde texto año completo :
    public static void main(String[] args) {
        Fecha fecha = new Fecha(0,0,0);
        fecha.MostrarFecha();
        //creando fecha:
        fecha.Crear(18,12,2025);
        //Fecha con 2 digitos char[6] :
        char[] f1 = {'2','9','0','8','9','4'};
        fecha.Año2dig(f1);
        //Fecha completo char[8] :
        char[] f2 = {'2','9','0','8','1','9','9','4'};
        fecha.AñoCompleto(f2);
    }

    
}//fin class fecha
