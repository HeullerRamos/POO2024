
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

/**
 *
 * @author heuller
 */
public class Program {
    public static void main(String[] args) {
         CPF c1 = new CPF();
         Cnpj c2 = new Cnpj();
        try{
            c1.setCpf(456789014L);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            c2.setCnpjString("35.017.120/0001-88");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
