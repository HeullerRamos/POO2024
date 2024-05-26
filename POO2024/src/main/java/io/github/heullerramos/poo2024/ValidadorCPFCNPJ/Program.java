
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

/**
 *
 * @author heuller
 */
public class Program {
    public static void main(String[] args) {
         CPF c1 = new CPF();
        try{
            c1.setCpf(1234567830L);
            //System.out.println(c1.validarCpf());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
