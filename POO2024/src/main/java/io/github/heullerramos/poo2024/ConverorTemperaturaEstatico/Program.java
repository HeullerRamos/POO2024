
package io.github.heullerramos.poo2024.ConverorTemperaturaEstatico;

/**
 *
 * @author heull
 */
public class Program {
    public static void main(String[] args) {
       try{
           System.out.println(ConverteTemperatura.kelvinForCelcios(0.0));
       }
       catch(RuntimeException e){
           System.out.println(e.getMessage());
        }
    }
    
}
