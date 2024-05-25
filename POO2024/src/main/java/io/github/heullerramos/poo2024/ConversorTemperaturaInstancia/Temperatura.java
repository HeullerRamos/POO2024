
package io.github.heullerramos.poo2024.ConversorTemperaturaInstancia;

/**
 *
 * @author heull
 */
public class Temperatura {
    private  float temperatura;
    
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
        return (temperatura * 1.8) + 32;
    }
    public Double celciosForKelvin(){
        return temperatura + 273.15;
    }
    //exceção
    public Double kelvinForCelcios(){
        if(temperatura < 0)
            throw new RuntimeException("Temperatura invalida");
        else
            return temperatura - 273.15;
    }
    //exceção
    public Double kelvinForFahrenheit(){
        if(temperatura <0)
            throw new RuntimeException("Temperatura invalida");
        else
            return ((temperatura - 273.15) * 1.8) + 32;
    }

    public Double fahrenheitForCelcios(){
        return (temperatura - 32) / 1.8;
    }
    public Double fahrenheitForKelvin(){
        return ((temperatura - 32) / 1.8) + 273.15;
    }
}
