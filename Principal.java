/*
 * Laura Nataly Sanabria Cepeda
 * Estudiante de Ingenierìa de sistemas de la Universidad Nacional de Colombia
 */
package principal;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author laura
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    private static Operaciones op; 
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner s = new Scanner(System.in);
        
        Vector<Operaciones> datos= new  Vector<Operaciones>();

        
        try {
            String fila[];
            int n=0,numero=0,cantNumeros=0;
            
            do{
                fila=s.next().split(",");
                n = Integer.parseInt(fila[0]);
                numero = Integer.parseInt(fila[1]);
                if((n==0 && numero==0)) break;
                cantNumeros=fila[1].length();
                op = new Operaciones(n,numero,cantNumeros);
                datos.add(op);
                
            }while(n!=0 && numero!=0);
            
            for (int i=0;i<datos.size();i++){
                datos.elementAt(i).imprimir();
            }
            
        }catch (NumberFormatException e) {
            System.out.println("El formato ingresado está erróneo, debe separar dos números con coma.");
        }catch (NegativeArraySizeException e) {
            System.out.println("Debe ingresar sólo números positivos");
        }

    
        
    }
    
}
