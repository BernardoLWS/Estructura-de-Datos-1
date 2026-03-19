package modeloexamen;
public class VectorNBits {
    //Atributos :
    int V[];
    int Cant;
    int CantidadBits;
    //Constructor :
    public VectorNBits(int NumElementos,int CantBits){
        int NumBits = NumElementos*CantBits;
        int NumEnteros =  NumBits/32;
        if(NumBits%32 != 0){
            NumEnteros++;
        }
        V = new int[NumEnteros];
        Cant = NumElementos;
        CantidadBits = CantBits;
    }
    //Metodos : 
    public void insertar(int ele,int pos){
        if(pos <= Cant){
            int ele1 = ele;
            int mask = (int)Math.pow(2,CantidadBits)-1;
            int NumBits = CalcularBits(pos);
            int NumEntero = CalcularEntero(pos);
            mask = mask<<NumBits;
            mask = ~mask;
            V[NumEntero] = V[NumEntero]&mask;
            ele = ele<<NumBits;
            V[NumEntero] = V[NumEntero]|ele;
            if((NumBits+CantidadBits)>32){
                int mask1 = (int)Math.pow(2,CantidadBits)-1;
                mask1 = mask1>>>(32-NumBits);
                mask1 = ~mask1;
                V[NumEntero+1] = V[NumEntero+1]&mask1;
                ele1 = ele1>>>(32-NumBits);
                V[NumEntero+1] = V[NumEntero+1]|ele1;
            }
        }
    }
    public int Sacar(int pos){
        int mask = (int)((Math.pow(2, CantidadBits)-1));
        int NumBits = CalcularBits(pos);
        int NumEntero = CalcularEntero(pos);
        mask = mask<<NumBits;
        mask = mask&V[NumEntero];
        mask = mask>>>NumBits;
        if((NumBits+CantidadBits)>32){
            int mask1 = (int)((Math.pow(2,CantidadBits)-1)); 
            mask1 = mask1>>>(32-NumBits);
            mask1 = mask1&V[NumEntero+1];
            mask1 = mask1<<(32-NumBits);
            mask = mask|mask1;
        }
        return mask;
    }
 
    
    private int CalcularBits(int pos){
        return ((pos*CantidadBits)%32);
    }    
    private int CalcularEntero(int pos){
        return ((pos-1)*CantidadBits/32);
    }
    
    @Override
    public String toString(){
        String S = "V=[";
        for(int i=1;i<=Cant;i++){
            S=S+Sacar(i)+",";
        }
        S = S.replaceAll(",$", "");
        S=S+"]";
        return S;
    }
    public static void main(String[] args){
     VectorNBits x = new VectorNBits(10,6);
     x.insertar(33, 1);
     x.insertar(22, 3);
     x.insertar(58, 7);
     x.insertar(35, 10);
     x.insertar(8, 6);
     x.insertar(34, 5);
     x.insertar(18, 4);
     System.out.println(x);
     x.insertar(59, 4);
     System.out.println(x);
    } 
}//Fin VectorNBits
