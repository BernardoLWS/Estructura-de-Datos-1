package examen2;
public class Prueba {
    int x;
    String h;
    double f;
        public Prueba(int x, String h, double f){
        this.x = x;
        this.h = h;
        this.f = f;
    
        }
        public String prueba() {
            return "Prueba{" + "x=" + x + ", h=" + h + ", f=" + f + '}';
         }
    
    public static void main(String[] args){
        Lista_C c=new Lista_C();
       c.insertarInicio(7);
       c.insertarInicio(9);
       c.insertar(8);
       c.insertar(1,3);
       System.out.println(c.getLongitud());
       System.out.println(c.toString());
    }
}
