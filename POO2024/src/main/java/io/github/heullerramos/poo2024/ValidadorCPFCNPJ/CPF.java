
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

/**
 *
 * @author heuller
 */
import static java.lang.Math.pow;
public class CPF {
    private long cpfLong;
    private String cpfString;
    private int soma = 0;
    private int primeiroDigito = 0;
    private int segundoDigito = 0;
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public CPF() {
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    public long getCpf() {
        return cpfLong;
    }

    public void setCpf(long cpf) throws Exception{
        if (isCpfValido(cpf) == true){
            this.cpfLong = cpf;
            
        }else
            throw new RuntimeException("cpf invalido");
    }

    public void setCpf(String cpf) throws Exception{
        if (isCpfValido(cpf) == true)
            this.cpfString = cpf;
        else
            throw new RuntimeException("cpf invalido");
    }

    // </editor-fold>

    private int obterDigito(Long cpf, int pos){
        int div = 10; int mod = 10;
        Double digito = (cpf.doubleValue() %(pow(mod, pos)) / (pow(div, pos-1)));

        return digito.intValue(); 
    }

    static int contagarDigito(Long cpf) {
        int contador = 0;
        while (cpf >= 1) {
            cpf /= 10;
            contador++;

        }
        return contador;
    }

    private boolean isCpfValido(long cpf) {
        int digitos = contagarDigito(cpf);
        if (cpf == 00000000000L || cpf == 11111111111L || cpf == 22222222222L
                || cpf == 33333333333L || cpf == 44444444444L || cpf == 55555555555L ||
                cpf == 66666666666L || cpf == 77777777777L || cpf == 88888888888L || cpf == 99999999999L) {
            return false;
        }
        int i;
        int j = 11;
        for (i = digitos; i > 2; i--){
            soma += obterDigito(cpf, i) * (i-1);
            
        }

        if ((11 - (soma % 11)) >= 10)
            primeiroDigito = 0;
        else
            primeiroDigito = 11 - (soma % 11);
        soma = 0;
        for (int k = digitos; k > 1; k--) {
            soma += obterDigito(cpf, k) * k;

        }
        if ((11 - (soma % 11)) >= 10)
            segundoDigito = 0;
        else
            segundoDigito = (11 - (soma % 11));

        if (primeiroDigito == ((cpf % 100) / 10)) {

            if ((segundoDigito == ((cpf % 100)) % 10)) {
                System.out.println("CPF valido");
                return true;
            }
        }
        return false;
    }

    private boolean isCpfValido(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "");
        cpfLong = Long.parseLong(cpf);
        return isCpfValido(cpfLong);

    }
}

