
package io.github.heullerramos.poo2024.ValidadorCPFCNPJ;

import static java.lang.Math.pow;

/**
 *
 * @author heull
 */
public class Cnpj {
    private long cnpjLong;
    private String cnpjString;
    private final int[] algarismosDeValidacao1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
    private final int[] algarismosDeValidacao2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
    private int digito1;
    private int digito2;
    private int soma =0;
  
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public long getCnpjLong() {
        return cnpjLong;
    }

    public String getCnpjString() {
        return cnpjString;
    }

    public void setCnpj(long cnpj) throws Exception{
        if(isCnpjValido(cnpj) == true)
            this.cnpjLong = cnpj;
        else
        throw new RuntimeException("cnpj invalido");
    }

    public void setCnpjString(String cnpj) throws Exception{
        if(isCnpjValido(cnpj) == true)
            this.cnpjString = cnpj;
        else
        throw new RuntimeException("cnpj invalido");
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructor">
    public Cnpj() {
        
    }
   //</editor-fold> 
    
    public int obterDigito(long cnpj,int pos){
        return (int) ((cnpj/(pow(10,pos)))%10);
    }
     
    public boolean isCnpjValido(String cnpj) {
    //retira os caracteres ".", "-", "/""
    cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
    cnpjLong = Long.parseLong(cnpj);
    return isCnpjValido(cnpjLong);

  }
     
    public boolean isCnpjValido(long cnpj){
        int i = 11;
        int j = 2;
        while( i>=0 && j <14){
            soma += obterDigito(cnpj,j) * algarismosDeValidacao1[i];
            i--;
            j++;
        }
        if((soma%11)<2)
            digito1=0;
        else
            digito1=11-(soma%11);
        if(digito1 != obterDigito(cnpj,1))
            return false;
        soma = 0;
        i=12;
        j=1;
         while( i>=0 && j <14){
            soma += obterDigito(cnpj,j) * algarismosDeValidacao2[i];
            i--;
            j++;
        }
        if(soma%11<2)
            digito2=0;
        else
            digito2=11-(soma%11);
        if(digito2 != obterDigito(cnpj,0))
            return false;
        else{
            System.out.println("Cnpj válido");
            return true;
        }
    }
}
