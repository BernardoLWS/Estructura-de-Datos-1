//  clase consulta :
//  Nro = 1 ;            -> (cont)
//  Nombre = juan;       -> (String)
//  Sexo = M ;           -> (1 bits)
//  Edad = 25 ;          -> (7 bits)    (de 15 a 100 años)=85
//  Sintitomas ;         -> (5 bits)
//                       Total = 13 bits
package modeloexamen;
    public class Consulta {
    //  Atributos :
        int max = 10;  int cont;        
        VectorNBits datos;
        String [] Nombres;
    // Constructor :
    public Consulta(){
        this.datos = new VectorNBits(max, 13);
        this.Nombres = new String[max];
        this.cont = 0;
    }
    //  Metodos :
    public void registrar(String nom,char sex,int edad,boolean fiebre,boolean Dgarganta,boolean Diarrea,boolean Dcabeza, boolean tos){
        if(cont<max){
           Nombres[cont]=nom; 
           int list = 0;
           int sx = sex=='M'?1:0;
           int f = fiebre?1:0;
           int dg = Dgarganta?1:0;
           int d = Diarrea?1:0;
           int dc = Dcabeza?1:0;
           int ts = tos?1:0;
           list = list|(sx<<12);
           list = list|(edad<<5);
           list = list|(f<<4);
           list = list|(dg<<3);
           list = list|(d<<2);
           list = list|(dc<<1);
           list = list|(ts);
           datos.insertar(list,cont);
           cont++;
        } 
    }
    // Getters :
    public String getnombre(int Nro){
        if(Nro>=0 && Nro<max){
            return Nombres[Nro];
        }
        return "";
    }
    public char getsexo(int Nro){
        int val = datos.Sacar(Nro);
        val = val>>>12;   
        return (val == 1)?'M':'F';
    } 
    public int getedad(int Nro){
        int val = datos.Sacar(Nro);
        val = val<<20;      
        val = val>>>25;     
        return val;
    }
    public boolean getfiebre(int Nro){
        int val = datos.Sacar(Nro);
        val = val<<27;
        val = val>>>31;
        return (val == 1);
    }
    public boolean getDgarganta(int Nro){
        int val = datos.Sacar(Nro);
        val = val<<28;       
        val = val>>>31;         
        return (val == 1);
    }
    public boolean getDiarrea(int Nro){
        int val = datos.Sacar(Nro);
        val = val<<29;        
        val = val>>>31;         
        return (val == 1);
    }
    public boolean getDcabeza(int Nro){
        int val = datos.Sacar(Nro);
        val = val<<30;          
        val = val>>>31;        
        return (val == 1);
    }
    public boolean gettos(int Nro){
        int val = datos.Sacar(Nro);
        val = val<<31;          
        val = val>>>31;        
        return (val == 1);
    }
    
        @Override
    public String toString(){
        String S = "";
        for(int i = 0;i<cont;i++){
            S += "Nro :"+(i+1)+"\n"+" Nombre :"+Nombres[i]+", "+" Sexo :"+getsexo(i)+""+", "+" Edad :"+getedad(i)+", "+" fiebre: "+getfiebre(i)+", "+
                " Dgarganta: : "+getDgarganta(i)+", "+" Diarrea: "+getDiarrea(i)+", "+" Dcabeza: "+getDcabeza(i)+", "+
                " tos: "+gettos(i)+"\n" ;
        }
        return S;
    }
    public static void main(String[] args) {
     Consulta c = new Consulta();
     c.registrar("lucas",'M', 25, true, true, true, true, true);
      c.registrar("maria",'F', 23, true, false, true,false, true);
       c.registrar("diego",'M', 27, true, false, false, false, true);
      System.out.println(c.toString());
    }
}//fin
