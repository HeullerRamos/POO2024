
package io.github.heullerramos.poo2024.ConversorTemperaturaInstancia;

/**
 *
 * @author heull
 */
public class Temperatura {
    private  Double temperatura;
    private Double resultadoConversao;
    
    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Temperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">    
    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
    //</editor-fold>
    
    public Double celciosForFahrenheit(){
        resultadoConversao = (temperatura * 1.8) + 32;
        return resultadoConversao;
    }
    public Double celciosForKelvin(){
        resultadoConversao = temperatura + 273.15;
        if(resultadoConversao < 0)
            throw new RuntimeException("Temperatura invalida");
        else
        return resultadoConversao;
    }
    //exceção
    public Double kelvinForCelcios(){
        if(temperatura < 0)
            throw new RuntimeException("Temperatura invalida");
        else{
            resultadoConversao = temperatura - 273.15;
            return resultadoConversao;
        }
    }
    //exceção
    public Double kelvinForFahrenheit(){
        if(temperatura <0)
            throw new RuntimeException("Temperatura invalida");
        else{
            resultadoConversao = ((temperatura - 273.15) * 1.8) + 32;
            return resultadoConversao;
        }
    }
    public Double fahrenheitForCelcios(){
        return (temperatura - 32) / 1.8;
    }
    //exceção
    public Double fahrenheitForKelvin(){
        resultadoConversao = ((temperatura - 32) / 1.8) + 273.15;
        if(resultadoConversao < 0)
            throw new RuntimeException("Temperatura invalida");
        else
        return resultadoConversao;
    }
}
