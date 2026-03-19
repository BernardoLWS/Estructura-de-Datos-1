package modeloexamen;
/*
    Implementar el TDA Catastro especificado para 1000 lotes
    Nro de lotes : 1
    Nombre : juan perez
    Uv : 105    (de 1 hasta 200uv)
    Mz:21       (1....30 Mz) 
    Lote : 12   (1....30 lotes)
    Superficie : 300 M2     (150....450 M2)
    Servicios basiccos con lo que cuenta :  agua, luz,pavimento,alcamtarillado,telefono,gas domiciliario.
*/
public class Catastro {
    //Atributos :
    private final int max = 1000;
    int cont;                       //cantidad de formularios existen;
    String Nombres[];               //guarda los nombres 
    private VectorNBits datos1; 
    private VectorNBits datos2;
    //Constructor :
    public Catastro(){
        this.cont=0;
        datos1 = new VectorNBits(max,27);
        datos2 = new VectorNBits(max, 6);
        this.Nombres = new String[max];
    }
    //Metodos :
    public void Registrar(String nombre,int uv,int mz,int lote,int sup,boolean agua,boolean luz,boolean pav,boolean alcan,boolean telf,boolean gas){
        if(cont < 1000){ 
            if(uv>0 && uv<=200 && mz>0 && mz<=30 && lote>0 && lote<=30 && sup>=150 && sup<=450){
            Nombres[cont] = nombre;
            int valor1 = 0;
            valor1 = valor1|(uv<<19);       //uv<<(27-8)
            valor1 = valor1|(mz<<14);       //mz<<(27-8-5) 
            valor1 = valor1|(lote<<9);     //lote<<(27-8-5-5)
            valor1 = valor1|(sup);        //sup<<(27-8-5-5-9)=0 no se desplaza
            int valor2 = 0;
            int ag = (agua)?1:0;          int al = (alcan)?1:0;
            int lz = (luz)?1:0;            int tf = (telf)?1:0;
            int pv = (pav)?1:0;            int gs = (gas)?1:0;
            valor2 = valor2|(ag<<5);      //agua<<(6-1)
            valor2 = valor2|(lz<<4);      //agua<<(6-2)
            valor2 = valor2|(pv<<3);      //agua<<(6-3)
            valor2 = valor2|(al<<2);      //agua<<(6-4)
            valor2 = valor2|(tf<<1);      //agua<<(6-5)
            valor2 = valor2|(gs); 
            datos1.insertar(valor1, cont);
            datos2.insertar(valor2,cont);
            cont++;
            }
        }     
    }
    public String getnombre(int NroLote){
        if(NroLote>=0 && NroLote<1000){
            return Nombres[NroLote];
        }
        return "";
    }
    public int getuv(int NroLote){
        int val = datos1.Sacar(NroLote);
        val = val>>>19;     //mueve al la der(los 8bits de uv + 5bits no usados) 32-(8+5)=1
        return val;
    } 
    public int getmz(int NroLote){
        int val = datos1.Sacar(NroLote);
        val = val<<13;       //izq(8+5) 
        val = val>>>27;      //der(32-5)
        return val;
    }
    public int getlote(int NroLote){
        int val = datos1.Sacar(NroLote);
        val = val<<18;      //izq(5+8+5)
        val = val>>>27;     //(32-5)
        return val;
    }
    public int getsup(int NroLote){
        int val = datos1.Sacar(NroLote);
        val = val<<23;          //izq(5+8+5+5)
        val = val>>>23;         //der(32-9)
        return val;
    }
    public boolean getagua(int NroLote){
        int val = datos2.Sacar(NroLote);
        val = val>>>5;      //der(6-1)
        return (val == 1);
    }
    public boolean getluz(int NroLote){
        int val = datos2.Sacar(NroLote);
        val = val<<27;          //izq(32-5)
        val = val>>>31;         //der(32-1)
        return (val == 1);
    }
    public boolean getpav(int NroLote){
        int val = datos2.Sacar(NroLote);
        val = val<<28;          //izq(32-4)
        val = val>>>31;         //der(32-1)
        return (val == 1);
    }
    public boolean getalcan(int NroLote){
        int val = datos2.Sacar(NroLote);
        val = val<<29;          //izq(32-3)
        val = val>>>31;         //der(32-1)
        return (val == 1);
    }
    public boolean gettelf(int NroLote){
        int val = datos2.Sacar(NroLote);
        val = val<<30;          //izq(32-2)
        val = val>>>31;         //der(32-1)
        return (val == 1);
    }
    public boolean getgas(int NroLote){
        int val = datos2.Sacar(NroLote);
        val = val<<31;          //izq(32-1)
        val = val>>>31;         //der(32-1)
        return (val == 1);
    }
    //Mostrar :
    @Override
    public String  toString(){
       String S ="";
       for(int i = 0;i<cont;i++){
           S += getnombre(i) + ", " + getuv(i)+", "+getmz(i)+", "+getlote(i)+", "+getsup(i)+", "+getagua(i)+", "+getluz(i)+
           ", "+getpav(i)+", "+getalcan(i)+", "+gettelf(i)+", "+getgas(i)+"\n";
       }
       return S;
    }
    //Main :
    public static void main(String[] args) {
        Catastro c = new Catastro();
        c.Registrar("eduardo", 105, 21, 12, 300, true, true, true, true, true, true);
        c.Registrar("jimena", 112, 20, 10, 250, true, false, true, false, true, false);
        System.out.println(c.toString());
    }
}//fin Catastro
