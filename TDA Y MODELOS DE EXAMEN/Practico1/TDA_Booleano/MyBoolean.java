package TDA_Booleano;

public class MyBoolean {
 //Atributos :
    int value;
 //Constructor :   
  public MyBoolean(int value ){
      this.value = (value!=0? 1:0);
  }
//Metodos :
public static MyBoolean Create(int CondicionComoInt){
    return new MyBoolean(CondicionComoInt);
}
public static MyBoolean And(MyBoolean b1,MyBoolean b2){
    return new MyBoolean(b1.value & b2.value); //(true && true -> true)
}
public static MyBoolean Or(MyBoolean b1,MyBoolean b2){
    return new MyBoolean(b1.value | b2.value);  //(true || false -> true)
}
public static MyBoolean Not(MyBoolean b){
    return  new MyBoolean(b.value==1? 0:1);  //(!true -> false)
}
public static Boolean Equals(MyBoolean b1,MyBoolean b2){
    return  (b1.value == b2.value);   //true^false -> true
}
public int getValue(){
    return value;
}
public String toString(){
    return (value == 1? "True":"False");
}
    public static void main(String[] args) {
        //Instancias :
        MyBoolean b1 = MyBoolean.Create(1);     //TRUE
        MyBoolean b2 = MyBoolean.Create(0);    //FALSE
        
        //Operacion And :
        MyBoolean AndResultado = MyBoolean.And(b1,b2);
        System.out.println("(b1 And b2) = "+AndResultado);
        //Operacion Or :
        MyBoolean OrResultado = MyBoolean.Or(b1, b2);
        System.out.println("(b1 or b2) = "+OrResultado);
        //Operador Not :
        MyBoolean NotResultado = MyBoolean.Not(b1);
        System.out.println("(b1 Not b2) = "+ NotResultado);
        //Operador Equals :
        Boolean EqualsResultado = MyBoolean.Equals(b1, b2);
        System.out.println("(b1 == b2) = "+ EqualsResultado);
    }
}//Fin ClaseBooleanoX
