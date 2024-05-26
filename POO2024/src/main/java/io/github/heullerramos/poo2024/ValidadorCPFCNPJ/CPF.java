
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

/**
 *
 * @author heuller
 */
import static java.lang.Math.pow;
public class CPF {
    private long cpf;
    private int pos;
    private int soma =0;
    private int primeiroDigito = 0;
    private int segundoDigito = 0;
    
    
    public CPF(){
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public long getCpf(){
        return cpf;
    }
    public void setCpf(long cpf){
        //System.out.println(cpf);
        if(validarCpf(cpf)==true)
            this.cpf=cpf;
        else
            throw new RuntimeException("cpf invalido");
    }
    //</editor-fold>
    public int obterDigito(long cpf,int pos){
        return (int) ((cpf/(pow(10,pos)))%10);
    }
    private  boolean validarCpf(long cpf){
        if(cpf==00000000000L || cpf==11111111111L ||cpf==22222222222L
        || cpf==33333333333L || cpf==44444444444L || cpf==55555555555L ||
        cpf==66666666666L || cpf==77777777777L || cpf==88888888888L || cpf==99999999999L){
            return false;
        }
        int i;
        int j=11;
        for(i=10;i>=2;i--){
            soma += obterDigito(cpf,i)*i;
        }
        
        if((11- (soma%11))>=10)
            primeiroDigito =0;
        else
            primeiroDigito=11- (soma%11);
            System.out.println("primeiro digito:" + primeiroDigito);
            soma=0;
        for(int k=10;k>=2;k--){
            soma+=obterDigito(cpf,k)*j;
            j--;
        }
        soma+=primeiroDigito*2;
        //System.out.println(soma);
        if((11 - (soma%11))>=10)
            segundoDigito =0;
        else
            segundoDigito=(11 - (soma%11));
            System.out.println("segundo digito: " + segundoDigito);
        
        if(primeiroDigito == ((cpf%100)/10)){
    
            if((segundoDigito==((cpf%100))%10)){
                return true;
            }
        }
        return false;
    }
       
}

