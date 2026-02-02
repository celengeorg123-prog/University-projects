/*
 * @(#)AppTienda1.java     17.0.6  28/02/2023
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
public class AppTienda1 {

    public static void main(String[] args){
       Tienda tienda = new Tienda();

       tienda.setSizeInventario(SafeInput.getSafeInt("Ingrese la cantidad de electrodomésticos de su itinerario: "));

       if (tienda.getInventario().length==0){
            return;
       }
       tienda.setNumeroLavadoras(SafeInput.getSafeInt("¿Cuántas lavadoras tienes? "
       +"(recuerda que el numero tiene que ser menor que o igual a "+tienda.getInventario().length
       +"): "));
        for (int i=0; i<tienda.getNumeroLavadoras(); i++){
            System.out.println("Para la lavadora #"+(i+1)+", ingrese los siguients datos: ");
            tienda.setElementsInventario(new Lavadora(SafeInput.getSafeString("\tNombre: "), 
            SafeInput.getSafeInt("\tCódigo: "), SafeInput.getSafeString("\tColor: "), 
            SafeInput.getSafeDouble("\tPrecio base: $"),
            SafeInput.getSafeChar("\tConsumo (letras de A-F): "), 
            SafeInput.getSafeDouble("\tPeso (kg): "), SafeInput.getSafeDouble("\tCapacidad (kg): "),
            SafeInput.getSafeString("\tClave para acceder al precio base del producto: ")), i);
            System.out.println();
        }
        
        System.out.println("Se asume que se tiene(n) "
        +(tienda.getInventario().length-tienda.getNumeroLavadoras())
        +" televisor(es).");

        for (int i=tienda.getNumeroLavadoras(); i<tienda.getInventario().length; i++){
            System.out.println("Para el televisor #"+(i-tienda.getNumeroLavadoras()+1)
            +", ingrese los siguients datos: ");
            
            tienda.setElementsInventario(new Televisor(SafeInput.getSafeString("\tNombre: "), 
            SafeInput.getSafeInt("\tCódigo: "), SafeInput.getSafeString("\tColor: "), 
            SafeInput.getSafeDouble("\tPrecio base: $"),
            SafeInput.getSafeChar("\tConsumo (letras de A-F): "), 
            SafeInput.getSafeDouble("\tPeso (kg): "), SafeInput.getSafeDouble("\tResolución (pulgadas): "),
            SafeInput.getSafeChar("\t¿Tiene sintonizador TDT? (ingrese 'y' si ese es el caso): "),
            SafeInput.getSafeString("\tClave para acceder al precio base del producto: ")), i);
            System.out.println();
        }
        tienda.getCatalogoTelevisores();
        if (
        SafeInput.getSafeChar("¿Quieres buscar un electrodómestico en específico? (ingrese 'y' si ese es el caso): ")=='y')
        tienda.searchElectrodomestico(SafeInput.getSafeInt("Ingrese el código del electrodoméstico que "
        +"desea encontrar: ")); 
    }
}