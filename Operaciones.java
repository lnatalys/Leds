/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author laura
 */
public class Operaciones {
    
    private int tamaño;
    private int numero;
    private int cantNumeros;

    private String caracter[];
    private int patron[][];
    
    public Operaciones(Integer tamaño, Integer numero, Integer cantNumeros){
        
        //Inicialización del vector de caracteres
        caracter= new String[5];
        caracter[0]=" ";
        caracter[1]="_";
        caracter[2]="|";
        caracter[3]="|";
        caracter[4]="-";
        
        //Inicialización de la matriz que compone los caracteres de cada número
        patron= new int[9][7];
        int patron[][]={new int[]{1,2,3,0,2,3,4},
                        new int[]{0,0,3,0,0,3,0},
                        new int[]{1,0,3,4,2,0,4},
                        new int[]{1,0,3,4,0,3,4},
                        new int[]{0,2,3,4,0,3,0},
                        new int[]{1,2,0,4,0,3,4},
                        new int[]{1,2,0,4,2,3,4},
                        new int[]{1,0,3,0,0,3,0},
                        new int[]{1,2,3,4,2,3,4},
                        new int[]{1,2,3,4,0,3,4}
                        };
        this.patron=patron;
        
        //Inicialización de los datos del número
        this.tamaño=tamaño;
        this.numero=numero;
        this.cantNumeros=cantNumeros;
    }
    
    
    public void imprimir(){
        
        //Inicialización de variables temporales
        String resultado="";
        String caracter="";
        int numTemp,valorCaracter;
        //recorre cada posición a dibujar del patrón de cada número
        for(int i=0;i<7;i++){
            numTemp=this.numero;
            resultado="";
            //for para recorrer cada número por posición del patrón
            for(int j=0;j<cantNumeros;j++){
                resultado=" "+resultado;
                valorCaracter=patron[numTemp%10][i];
                caracter=this.caracter[valorCaracter];
                
                //código para la parte vertical del número
                if(i==1 || i==4){
                    
                    //código para la parte derecha del número
                    valorCaracter=patron[numTemp%10][i+1];
                    caracter=this.caracter[valorCaracter];
                    resultado=caracter+resultado;
                    
                    //código para la parte izquierda del número
                    valorCaracter=patron[numTemp%10][i];
                    caracter=this.caracter[valorCaracter];
                    String espacio=repetirHorizontal(" ",tamaño-1);
                    
                    if(valorCaracter==2)
                        resultado=caracter+" "+espacio+resultado;
                    else if(valorCaracter==0){
                        resultado=caracter+caracter+espacio+resultado;
                    }
                    
                }
                //código para la parte horizontal del número
                else
                {
                    resultado=repetirHorizontal(caracter,tamaño)+" "+resultado;
                }
                numTemp=numTemp/10;
                
            }
            //si hay que duplicar verticalmente los símbolos
            if(i==1 || i==4){
                i=i+1;
                repetirVertical(resultado, tamaño);
            }
            else
            {
                System.out.println(" "+resultado);
            }
        }
    }
    
    //Método para duplicar numVeces un caracter 
    public static String repetirHorizontal(String caracter, int numVeces) {
        return new String(new char[numVeces]).replace("\0", caracter+" ");
    }
    
    //Método para duplicar numVeces una línea
    public static void repetirVertical(String cadena,int numVeces) {
        for (int i=0;i<numVeces;i++) {
            System.out.println(""+cadena);
        }
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCantNumeros(int cantNumeros) {
        this.cantNumeros = cantNumeros;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getCantNumeros() {
        return cantNumeros;
    }

    public int getTamaño() {
        return tamaño;
    }


    
}
