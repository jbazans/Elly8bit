package main64bit8bit;

public class Ellys8Bit {

    public static void main(String[] args) {
        char[] num64bit8bit=inicializar();
        int N=5;
        char auxiliar;
        boolean validar=true;
        while(N-1>0){
            for (int i = 0; i < 64; i++) {
                if (i-1>=0) {
                    if (num64bit8bit[i]=='0' && num64bit8bit[i-1]=='1') {
                        if (validar) {
                            auxiliar=num64bit8bit[i-1];
                            num64bit8bit[i-1]=num64bit8bit[i];
                            num64bit8bit[i]=auxiliar;
                            validar=false;
                        }
                    }
                }
            }
            N--;
            validar=true;
        }        
        int decimal=calcular(num64bit8bit);
        System.out.println(num64bit8bit);
        System.out.println(decimal);
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
        for (int i = 63; i > 7; i--) {
            num64bit8bit[i]='0';
        }
        for (int i = 7; i >-1; i--) {
            num64bit8bit[i]='1';
        }
        return num64bit8bit;
    }
    
}
