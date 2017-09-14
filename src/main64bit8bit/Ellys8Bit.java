package main64bit8bit;

public class Ellys8Bit {
    public static void main(String[] args) {
        int decremento = 1;
        char[] num64bit8bit=inicializar();
        int N=5;
        char auxiliar;
        boolean finalCero = false;
        while(N-decremento>0){
            if (num64bit8bit[0]=='0')
                finalCero = true;
            else
                finalCero = false;
            procesar(num64bit8bit);
            if(finalCero){
                num64bit8bit = moverCeros(num64bit8bit);
            }
            decremento ++;
        }
        int decimal=calcular(num64bit8bit);
        String binario="";
        for (int i= 0; i<64; i++){
             binario=num64bit8bit[i]+binario;
        }
        System.out.println(binario);
        System.out.println(decimal);
    }
    
    public static char[] procesar(char[] num64bit8bit){
        for (int i = 1; i < 64; i++) {               
            if (num64bit8bit[i]=='0' && num64bit8bit[i-1]=='1') {
                  char  auxiliar =num64bit8bit[i-1];
                    num64bit8bit[i-1]=num64bit8bit[i];
                    num64bit8bit[i]=auxiliar;
                    return num64bit8bit;
            }            
        } 
        return num64bit8bit;
    }
    
    public static int calcular(char[] num64bit8bit){
        int numerodecimal=0;
        for (int i = 0; i < num64bit8bit.length; i++) {
            int potencia2=(int) Math.pow(2,i);
            int digito=(int) Integer.parseInt(String.valueOf(num64bit8bit[i]));
            numerodecimal=numerodecimal+digito*potencia2;
        }
        return numerodecimal;
    }
    
    public static char[] inicializar(){
        char[] num64bit8bit = new char[64];
        for (int i = 0; i < 8; i++) {
            num64bit8bit[i]='1';
        }
        for (int i = 8; i < 64; i++) {
            num64bit8bit[i]='0';
        }
        return num64bit8bit;
    }

    private static char[] moverCeros(char[] num64bit8bit) {
        boolean cambiar = true;
        int cantidadCeros = 0;
        boolean hacercambio = false;
        boolean seguir = false;
        int suma = 0;
        for (int i=0;i<64;i++){
            if (num64bit8bit[i]=='1'){
                seguir = true;                
                suma = suma + 1;
                if (suma == 8){
                    seguir = false;
                }
            }
            if (seguir && num64bit8bit[i]=='0'&& suma <8){
                hacercambio = true;
            }
        }
        if(hacercambio){            
            for(int i=0;i<64;i++){
               if (cambiar && num64bit8bit[i]=='1') {
                   cambiar = false;
                   cantidadCeros = i;
               }

               if (!cambiar){
                   if (num64bit8bit[i]=='0'){
                       for(int j=0;j<cantidadCeros;j++){
                           num64bit8bit[i-j-1]='0';
                           num64bit8bit[j]='1';
                       }

                       return num64bit8bit;
                   }
               }
            }
        }
        return  num64bit8bit;       
    }
}
