/*
 * @(#)AppTienda2.java     17.0.6  1/03/2023
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
public class AppTienda2 {

    public static void main(String[] args){
        Tienda tienda=new Tienda();
        tienda.setSizeItinerario(1000);
        tienda.setNumeroPerecederos(500);
        for (int i=0,j=500; i<500 && j<1000; i++,j++){
            tienda.setElementsItinerario(
                new ProductoPerecedero((int)(500*Math.random()), "Tester Lavadora #"+i, 3, (int)(8*Math.random())), i);
            tienda.setElementsItinerario(
                new ProductoNoPerecedero((int)((501)*Math.random()+500), "Tester Lavadora #"+(j-500), 3, "Nosé"),j);
        }
        tienda.getCatalogoNoPerecederos();
        tienda.searchProducto(SafeInput.getSafeInt("¿Qué electrodoméstico quieres encontrar?: "));
        tienda.setElementsItinerario(new ProductoNoPerecedero(0,null,3,null), 0);
    }
}
