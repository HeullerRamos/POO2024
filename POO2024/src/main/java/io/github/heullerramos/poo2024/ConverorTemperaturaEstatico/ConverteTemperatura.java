
package io.github.heullerramos.poo2024.ConverorTemperaturaEstatico;

/**
 *
 * @author heull
 */
public class ConverteTemperatura {
    
    public static Double celciosForFahrenheit(Double temperatura){
        return (temperatura * 1.8) + 32;
    }
    public static Double celciosForKelvin(Double temperatura){
         if((temperatura + 273.15) < 0)
            throw new RuntimeException("Temperatura invalida");
        else
            return temperatura + 273.15;
    }
     //exceção
    public static Double kelvinForCelcios(Double temperatura){
        if(temperatura < 0)
            throw new RuntimeException("Temperatura invalida");
        else
            return temperatura - 273.15;
    }
    //exceção
    public static Double kelvinForFahrenheit(Double temperatura){
        if(temperatura <0)
            throw new RuntimeException("Temperatura invalida");
        else
            return ((temperatura - 273.15) * 1.8) + 32;
    }
    public Double fahrenheitForCelcios(Double temperatura){
        return (temperatura - 32) / 1.8;
    }
    //exceção
    public Double fahrenheitForKelvin(Double temperatura){
        if((((temperatura - 32) / 1.8) + 273.15) < 0)
            throw new RuntimeException("Temperatura invalida");
        else
        return ((temperatura - 32) / 1.8) + 273.15;
    }
}
