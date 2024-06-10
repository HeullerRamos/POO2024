
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

/**
 *
 * @author heuller
 */
public class Program {
    public static void main(String[] args) {
         Cnpj c1 = new Cnpj();
        try{
            c1.setCnpj(35017120000186L);
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }
}
