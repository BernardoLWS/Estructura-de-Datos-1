package modeloexamen;
//-------------------- TDA FRACCION -------------------------
// 1.- Nombre : Racional
// 2.- Datos : Numerador y Denominador -> Reales
// 3.- Relacion : sin relacion
// 4.- Metodos :  
// 4.1 Constructores:
public class Racional { //Clase racional principal
    int nume; //numerador
    int deno; //denominador
  public Racional(){
    this.nume = 0;
    this.deno = 1; //denominador nunca sera cero
  }   
  public Racional(int nume, int deno, char signo){
    this.deno = Math.abs(deno); //valor absoluto de deno  
    if (signo == '+'){   
       this.nume = +Math.abs(nume);  //+numerador
    }else{
       this.nume = -Math.abs(nume);  //-numerador
    }
  } 
  
  //4.2 Getters :
  public int getNume(){
     return Math.abs(nume);
  }
  public int getDeno(){
     return Math.abs(deno);
  }
  public char getSigno(){
    if(nume>=0){
         return '+';
    }else{
         return '-'; 
    }
  }
  //4.3 Setters :
  public void setNume(int nume){
      if(this.nume>=0){
          this.nume = nume;
      }else{
          this.nume = -nume;
      }
  }
  public void setDeno(int deno){
      this.deno=deno;
  }
  public void setSigno(char signo){
      if(signo == '+'){
          nume = Math.abs(nume);
      }else{
          nume = -Math.abs(nume);
      }
  }
  // 4.4 Operaciones Auxiliares :
  public void Suma(Racional A, Racional B){
      deno = A.getDeno()* B.getDeno();
      nume = (A.nume*B.getDeno() + A.getDeno()*B.nume);
      Simplificar();
  }
  public void Resta(Racional A,Racional B){
      deno = A.getDeno()*B.getDeno();
      nume = (A.nume*B.getDeno()-A.getDeno()*B.nume);
      Simplificar();
  }
  public void Multiplicar(Racional A,Racional B){
      deno = A.getDeno()*B.getDeno();
      nume = A.nume*B.nume;
      Simplificar();
  }
  public void Dividir(Racional A,Racional B){
      nume = A.nume* B.deno;
      deno = A.deno* B.nume;
      if(deno<0)
          nume = nume*(-1);
          deno = Math.abs(deno);
      Simplificar();
  }
  public void Simplificar(){
      int x=MCD();
      nume = nume/x;
      deno = deno/x;
  }
  public int MCD(){
      int u = Math.abs(nume);
      int v = Math.abs(deno);
      if(v==0)
          return u;
      else{
          int z;
          while(v != 0){
              z=u%v; u=v; v=z;
          }
          return u;
      }
  }

  public String ToString(){
  String c = "C=";
  c = " "+ getNume()+"\n"+c+getSigno()+"---"+"\n"+getDeno();
  return c;
  }
  
  public String AString(){
      String c = "C="+getSigno()+" "+getNume()+"/"+getDeno();
      return c;
  }
  
  public static void main(String[] args){
      Racional A = new Racional(1,4,'+');
      System.out.println(A.ToString());
      Racional B = new Racional(1,2,'-');
      System.out.println(B.ToString());
      Racional C = new Racional();
      C.Dividir(A,B);
      System.out.println(C.ToString());
      Racional D = new Racional();
      D.Multiplicar(A,B);
      System.out.println(D.ToString());
  }
}//Fin clase racional principal
