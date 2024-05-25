
package io.github.heullerramos.poo2024.ConversorTemperaturaInstancia;

/**
 *
 * @author heull
 */
public class Program {
     public static void main(String[] args) {
        Temperatura t1 = new Temperatura(-4);
        
        try{
            
         System.out.println(t1.kelvinForCelcios());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
