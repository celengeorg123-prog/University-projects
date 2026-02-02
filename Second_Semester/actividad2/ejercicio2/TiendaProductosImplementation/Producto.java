/*
 * @(#)Producto.java     17.0.6  27/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */

package ejercicio2.TiendaProductosImplementation;

import actividad2.ejercicio1.Customs.Codigo;

/**
 *  
      Clase abstracta cuyo propósito es el de simular
      productos consumibles del diario vivir. 
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public abstract class Producto extends Codigo{

    /**  
    Descripción (probablemente nutricional) del producto.*/
    protected String descripcion;
    
    /**  
    Atributo común de la noción de precio.*/
    protected double precio;

    /**
     * Permite inicializar (set) los elementos de objetos 
       {@code Producto}.
       @param codigo
       @param descripcion 
       @param precio
    */
    Producto(int codigo, String descripcion, double precio){
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.precio=precio;
    }
    
    /**
     * Permite obtener la descripción del producto.
       @return cadena {@code descripcion}.*/
    public String getDescripcion(){
        return descripcion;
    }
   
    /**
     * Permite determinar el precio de una cuantía específica de
       productos.
       @param precio de una unidad.
       @param cantidad de productos clasificados bajo esa unidad. 
       @return double que servirá como base para determinar el precio
       final.*/
    protected static double obtenerPrecioFinalBase(double precio, int cantidad){
        return precio*cantidad;
    }

    /**
     * Permite generalizar la representación en cadena de los contenidos 
       de un producto (en el sentido semántico de OOP).
       @return {@code String}.*/
    protected String customString(){
        return "\n\tCódigo: "+codigo
        +"\n\tDescripción: "+descripcion
        +"\n\tPrecio de venta (1 unidad): $"+precio;
    }

    /**
     * Permite calcular el precio a pagar según 
       el tipaje y la cantidad.
       @param cantidad número de productos a pagar.
       @return {@code double}, el valor a pagar.*/
    abstract double calcular(int cantidad);
}
