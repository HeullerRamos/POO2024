
package io.github.heullerramos.poo2024.ConversorTemperaturaInstancia;

/**
 *
 * @author heull
 */
public class Program {
     public static void main(String[] args) {
        Temperatura t1 = new Temperatura(-50000.0);
        
        try{
            
         System.out.println(t1.celciosForKelvin());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
