/*
 * @(#)AppTienda2.java     17.0.6  28/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */

package ejercicio1.Tester;

import actividad2.ejercicio1.Customs.SafeInput;
import ejercicio1.TiendaElectrodomesticosImplementation.*;

/**
 *  
        Clase que hace una prueba de implementación de: 
        <li> {@link Tienda};
        <li> {@link SafeInput};
        <li> {@link Electrodomestico};
        <li> {@link Lavadora};
        <li> {@link Televisor}. 
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public class AppTienda2 {

    public static void main(String[] args){
        Tienda tienda=new Tienda();
        tienda.setSizeInventario(1000);
        tienda.setNumeroLavadoras(500);
        for (int i=0,j=500; i<500 && j<1000; i++,j++){
            tienda.setElementsInventario(
                new Lavadora("Tester Lavadora #"+i, (int)(500*Math.random()), null,391,'F',31.331,233,null), i);
            tienda.setElementsInventario(
                new Televisor("Tester Televisor #"+(j-500),(int) ((501)*Math.random()+500),"Op",33, 'F', 22, 12.3, 'E', null ),j);
        }
        tienda.getCatalogoTelevisores();
        tienda.searchElectrodomestico(SafeInput.getSafeInt("¿Qué electrodoméstico quieres encontrar?: "));
    }
}
