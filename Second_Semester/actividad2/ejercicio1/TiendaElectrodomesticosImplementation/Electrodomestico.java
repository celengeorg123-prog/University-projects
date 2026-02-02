/*
 * @(#)Electrodomestico.java     17.0.6  25/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */

package ejercicio1.TiendaElectrodomesticosImplementation;

import actividad2.ejercicio1.Customs.Codigo;

/**
 *  
        Clase abstracta usada para simular las propiedades y
        comportamientos de mercancías de cariz 
        electrodoméstico.
 * @version      
        17.0.6 06 Jan 2023   @author          
        Jorge Celis  */
public abstract class Electrodomestico extends Codigo {

    /**  
    Nombre del electrodoméstico.*/
    protected String nombre;

    /**  
    Precio base de manufacturación.*/
    protected double basePrice;

    /**  
    Color del electrodoméstico (subjetivo).*/
    protected String color;

    /**  
    Consumo energético del electrodoméstico (letras de A-F).*/
    protected char letra;

    /**  
    Peso del electrodoméstico en kg.*/
    protected double peso;

    /**  
    Llave única que permite al vendedor conocer el precio
    base de manufacturación.*/
    protected String key;

    /**
     * Permite inicializar (set) los atributos del
       electrodoméstico. 
        @param nombre
        @param codigo
        @param color 
        @param basePrice  
        @param letra 
        @param peso
        @param key */
    Electrodomestico(String nombre, int codigo, String color, double basePrice, 
    char letra, double peso, String key){
        this.nombre=nombre;
        this.codigo=codigo;
        this.color=color;
        this.peso=peso;
        this.basePrice=basePrice;
        this.letra=comprobarConsumoEnergetico(letra);
        this.key=key;
    }

    /**
     * Método para implementar la letra de consumo correcta
       (default {@code F})
       @param letra letra ingresada por el usuario
       @return consumo energético apropiado (letras de A-F).*/
    private static char comprobarConsumoEnergetico(char letra){
        for (int i=0; i<=5; i++){
            if ('A'+ i==letra) return letra;
        }
        return 'F';
    }

    /**
     * Método para inicializar {@code letra} con el
       consumo correcto (default {@code F}).
        @param letra letra ingresada por el usuario
        @return consumo energético apropiado (letras de A-F).*/
    protected String customString (){
        return "\n\tCódigo: "+codigo
        +"\n\tColor: "+color+"\n\tPrecio de venta: $"+obtenerPrecioFinal()
        +"\n\tConsumo: "+letra+"\n\tPeso (kg): "+peso;
    }

    /**
     * Método para ajustar el precio de venta del electrodoméstico
       según el consumo energético.
        @param amount precio de venta ajustable.
        @return precio de venta ajustado según el consumo y el precio base.*/
    protected double ajustarPrecioVenta(double amount){
        switch(letra){
            case 'A': {
                return amount*1.75;
            }
            case 'B': {
                return amount*1.7;
            }
            case 'C': {
                return amount*1.65;
            }
            case 'D': {
                return amount*1.5;
            }
            case 'E': {
                return amount*1.35;
            }
            default:{
                return amount*1.05;
            }
        }
    }

    /**
     * Método para acceder al precio base del electrodoméstico.
      @param key clave única.
      @return El precio de venta si se ingresa
      la clave correcta.*/
    public double getBasePrice(String key){
        if (!this.key.equals(key)) return -1;
        return basePrice;
    }

    /**
     * Método para obtener el color del producto.
      @return el color del producto (subjetivo).*/
    public String getColor(){
        return color;
    }

    /**
     * Método para obtener el consumo energético
       del producto.
       @return el consumo energético (letras A-F).*/
    public char getLetra(){
        return letra;
    }

    /**
     * Método para obtener el peso del electrodoméstico.
       @return el {@code peso} (kg).*/
    public double getPeso(){
        return peso;
    }

    /**
     * Método para obtener el nombre del electrodoméstico.
       @return el {@code nombre}.*/
    public String getNombre(){
        return nombre;
    }

    /**
     * Método para obtener el precio de venta 
       del electrodoméstico.
       @return el precio final/venta.*/
    public abstract double obtenerPrecioFinal();
}