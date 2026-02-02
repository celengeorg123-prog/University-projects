/*
 * @(#)AppTienda1.java     17.0.6  1/03/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */

package ejercicio2.Tester;

import actividad2.ejercicio1.Customs.SafeInput;
import ejercicio2.TiendaProductosImplementation.*;

/**
 *  
        Clase que hace una prueba de implementación de: 
        <li> {@link Tienda};
        <li> {@link SafeInput};
        <li> {@link Producto};
        <li> {@link ProductoNoPerecedero};
        <li> {@link ProductoPerecedero}. 
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public class AppTienda1 {

    public static void main(String[] args){
        Tienda tienda = new Tienda();
        tienda.setSizeItinerario(SafeInput.getSafeInt("Ingrese la cantidad de productos de su inventario: "));

        if (tienda.getItinerario().length==0){
            return;
        }
        tienda.setNumeroPerecederos(SafeInput.getSafeInt("¿Cuántos perecederos tienes?"
        +"(recuerda que el numero tiene que ser menor que o igual a "+tienda.getItinerario().length
        +"): "));
        for (int i=0; i<tienda.getNumeroPerecederos(); i++){
            System.out.print("Para el producto perecedero #"+(i+1)
            +", ingrese los siguientes datos: ");
            
            tienda.setElementsItinerario(new ProductoPerecedero(SafeInput.getSafeInt("\n\tCódigo: "), 
            SafeInput.getSafeString("\n\tDescripción: "), 
            SafeInput.getSafeDouble("\n\tPrecio: $"), 
            SafeInput.getSafeInt("\n\tDías a caducar: ")), 
            i);
        }

        System.out.println("Se asume que se tiene(n) "
        +(tienda.getItinerario().length-tienda.getNumeroPerecederos())
        +" producto(es) no perecedero(s).");

        for (int i=tienda.getNumeroPerecederos(); i<tienda.getItinerario().length; i++){
            System.out.println("Para el producto no perecedero #"+(i+1-tienda.getNumeroPerecederos())
            +", ingrese los siguientes datos: ");

            tienda.setElementsItinerario(new ProductoNoPerecedero(SafeInput.getSafeInt("\n\tCódigo: "), 
            SafeInput.getSafeString("\n\tDescripción: "), 
            SafeInput.getSafeDouble("\n\tPrecio: $"), 
            SafeInput.getSafeString("\n\tTipo: ")),i);
        }

        tienda.getCatalogoNoPerecederos();
        if(
        SafeInput.getSafeChar("¿Quieres buscar un electrodómestico en específico? (ingrese 'y' si ese es el caso): ")=='y')
        tienda.searchProducto(SafeInput.getSafeInt("Ingrese el código del producto que "
        +"desea encontrar: "));
    }
}