
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

/**
 *
 * @author heuller
 */
import static java.lang.Math.pow;
public class CPF {
    private long cpfLong;
    private String cpfString;
    private int soma =0;
    private int primeiroDigito = 0;
    private int segundoDigito = 0;
    
    
    public CPF(){
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public long getCpf(){
        return cpfLong;
    }
    public void setCpf(long cpf){
        if(isCpfValido(cpf)==true)
            this.cpfLong=cpf;
        else
            throw new RuntimeException("cpf invalido");
    }
     public void setCpf(String cpf){
        // System.out.println(cpfs);
        //System.out.println(cpf);
        if(isCpfValido(cpf)==true)
            this.cpfString=cpf;
        else
            throw new RuntimeException("cpf invalido");
    }
    
    //</editor-fold>
     
    public int obterDigito(long cpf,int pos){
        return (int) ((cpf/(pow(10,pos)))%10);
    }
    private  boolean isCpfValido(long cpf){
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
            ////System.out.println("primeiro digito:" + primeiroDigito);
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
            //System.out.println("segundo digito: " + segundoDigito);
        
        if(primeiroDigito == ((cpf%100)/10)){
    
            if((segundoDigito==((cpf%100))%10)){
                System.out.println("CPF valido");
                return true;
            }
        }
        return false;
    }
    
    private boolean isCpfValido(String cpf){
        cpf = cpf.replace(".","").replace("-","");
        cpfLong = Long.parseLong(cpf);
        return isCpfValido(cpfLong);
        //System.out.println(cpf);
//        if ((cpf.equals("000.000.000-00")) || (cpf.equals("111.111.111-11")) || 
//            (cpf.equals("222.222.222-22")) || (cpf.equals("333.333.333-33")) || 
//            (cpf.equals("444.444.444-44")) || (cpf.equals("555.555.555-55")) || 
//            (cpf.equals("666.666.666-66")) || (cpf.equals("777.777.777-77")) || 
//            (cpf.equals("888.888.888-88")) || (cpf.equals("999.999.999-99")) ||
//            (cpf.length()!=14))
//            return false; 
//        
//        int peso = 10;
//        int num = 0;
//        //calcula o primeiro digito
//        for (int i =0;i<11;i++){
//            //ignora (.) no for
//            if((i==3 || i==7)){
//                //((cpf.charAt(i)== 45) && ((i == 3) || (i == 7)))
//                continue;
//            }
//            //transforma o numero char em int
//            num = (int)(cpf.charAt(i) - 48);
////            System.out.println("num:"+num);
////            System.out.println("peso:"+peso);
////            System.out.println("num*peso:"+num*peso);
//            soma = soma + (num * peso);
////            System.out.println("soma:"+soma);
////            System.out.println("----------------------");
//            peso--;
//        }
//       // System.out.println("soma:"+soma);
//        //valida o primeiro digito
//        primeiroDigito = 11 - (soma % 11);
//        if(primeiroDigito == 10 || primeiroDigito == 11)
//            primeiroDigito = 0;
//        //System.out.println("dig 1:"+primeiroDigito);
//        //calcula o segundo digito
//        soma = 0;
//        peso = 11;
//        for (int i =0;i<13;i++){
//            //ignora (.) e o (-) no for
//            if((i==3 || i== 7 || i==11)){
//                //((cpf.charAt(i)== 45) && (i == 3) || (i == 7)) || ((cpf.charAt(i)== 46) && i==11)
//                continue;
//            }
//            //transforma o numero char em int
//            num = (int)(cpf.charAt(i) - 48);
//            soma = soma + (num * peso);
//            peso--;
//        }
//        
//        //valida segundo gigito
//        segundoDigito = 11 - (soma % 11);
//        if(segundoDigito == 10 || segundoDigito == 11)
//            segundoDigito = 0;
//       // System.out.println("dig 2:"+segundoDigito);
//        //verifica se os digitos obtidos batem com os informados
//        System.out.println("");
//        if((primeiroDigito == (cpf.charAt(12)-48)) && (segundoDigito == (cpf.charAt(13)-48)))
//            return true;
//        else
//            return false;
//    }
    }
}

