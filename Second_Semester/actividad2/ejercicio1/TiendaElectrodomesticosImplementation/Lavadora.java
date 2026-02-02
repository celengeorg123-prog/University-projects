/*
 * @(#)Lavadora.java     17.0.6  26/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio1.TiendaElectrodomesticosImplementation;

/**
 *  
        Clase cuyo propósito es el de simular a una
        lavadora arbitraria. 
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public final class Lavadora extends Electrodomestico {
    
    /**  
    Capacidad máxima de la lavadora.*/
    private double capacidad;

    public Lavadora(String nombre, int codigo, String color, double basePrice, 
    char letra, double peso, double capacidad, String key) {
        super(nombre, codigo, color, basePrice, letra, peso, key);
        this.capacidad=capacidad;
    }

    /**
     * Permite obtener la {@code capacidad} de la lavadora.     
       @return double {@code capacidad}. */
    public double getCapacidad(){
        return capacidad;
    }

    @Override
    public double obtenerPrecioFinal() {
        if (capacidad>30) return ajustarPrecioVenta(basePrice)+5e4;
        return ajustarPrecioVenta(basePrice);
    }

    @Override
    public String toString(){
        return "La lavadora con nombre "+nombre+" tiene: "+customString()
        +"\n\tCapacidad (kg): "+capacidad;
    }

}
