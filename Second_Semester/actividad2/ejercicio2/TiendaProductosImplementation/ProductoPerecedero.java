/*
 * @(#)ProductoPerecedero.java     17.0.6  1/03/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio2.TiendaProductosImplementation;

/**
 *  
      Clase final cuyo propósito es el de simular
      productos consumibles del diario vivir que poseen
      caducación. 
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public final class ProductoPerecedero extends Producto{
    
    /**  
    Componente usado para determinar la caducación.*/
    private int caducacion;

    public ProductoPerecedero(int codigo, String descripcion, double precio, int caducacion) {
        super(codigo, descripcion, precio);
        this.caducacion=caducacion;
    }

    @Override
    public String toString(){
        return "Este producto perecedero tiene:"
        +customString()+"\n\tCaducación (días faltantes): "+caducacion;
    }

    @Override 
    double calcular(int cantidad) {
        switch(caducacion){
            case 1:{
                return obtenerPrecioFinalBase(precio, cantidad)*0.25;
            }
            case 2:{
                return obtenerPrecioFinalBase(precio, cantidad)*0.33;
            }
            case 3:{
                return obtenerPrecioFinalBase(precio, cantidad)*0.5;
            }
            default: {
                return obtenerPrecioFinalBase(precio, cantidad);
            }
        }
    }
}
