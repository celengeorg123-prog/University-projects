/*
 * @(#)Televisor.java     17.0.6  26/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio1.TiendaElectrodomesticosImplementation;

/**
 *  
        Clase cuyo propósito es el de simular a un
        televisor arbitraria. 
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public final class Televisor extends Electrodomestico{
    
    /**  
    Resolución del televisor (en pulgadas).*/
    private double resolucion;

    /**  
    Si tiene sintonizador entonces 
    {@code sintonizadorTDT=true}.*/
    private Boolean sintonizadorTDT;

    public Televisor(String nombre, int codigo, String color, double basePrice,
    char letra, double peso, double resolucion,
    char answer, String key) {
        super(nombre, codigo, color, basePrice, letra, peso, key);
        this.resolucion=resolucion;
        this.sintonizadorTDT=(answer=='y'?true:false);
    }

    /**
     * Permite obtener la resolución del televisor.
       @return double {@code resolución}*/
    public double getResolucion(){
        return resolucion;
    }

    /**
     * Permite saber si el televisor tiene sintonizador.
       @return Boolean {@code sintonizadorTDT}*/
    public Boolean probarSintonizador(){
        return sintonizadorTDT;
    }
    
    @Override
    public double obtenerPrecioFinal() {
        double valueAcumulator=basePrice;
        if (resolucion>40){
            valueAcumulator*=1.3;
        }
        if (sintonizadorTDT){
            valueAcumulator+=5e4;
        }
        return ajustarPrecioVenta(valueAcumulator);
    }
    
    @Override
    public String toString(){
        return "El televisor con nombre "+nombre+" tiene: "
        +customString()+"\n\tResolución (inch): "+resolucion
        +(sintonizadorTDT?"\n\tAdemás, tiene sintonizadorTDT":"\n\tAdemás, no tiene sintonizadorTDT");
    }
}
