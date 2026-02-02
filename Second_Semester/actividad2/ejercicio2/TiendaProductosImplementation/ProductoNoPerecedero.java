/*
 * @(#)ProductNoPerecedero.java     17.0.6  27/02/2023
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
      productos consumibles del diario vivir que no
      poseen caducación. 
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public final class ProductoNoPerecedero extends Producto{
    
    /**  
    Componente que determina el tipo de consumible 
    (e.g., una mercancía como un martillo se puede clasificar
    como un objeto de utilidades manuales).*/
    private String tipo;
  
    public ProductoNoPerecedero(int codigo, String descripcion, double precio, String tipo) {
        super(codigo, descripcion, precio);
        this.tipo=tipo;
    }

    @Override 
    double calcular(int cantidad){
        return  obtenerPrecioFinalBase(precio, cantidad);
    }

    @Override
    public String toString(){
        return "Este producto no perecedero tiene: "
        +customString()+"\n\tTipo: "+tipo;
    }
}
