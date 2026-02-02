/*
 * @(#)Tienda.java     17.0.6 27/02/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio1.TiendaElectrodomesticosImplementation;

import actividad2.ejercicio1.Customs.Shop;

/**
 *  
      Clase cuya finalidad es la de simular una tienda
      que posee un inventario binario de productos 
      electrodomésticos como lavadoras y televisores.
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public final class Tienda {

    /**  
    Implementación compositiva de {@link Shop} .*/
    private Shop<Electrodomestico> shop = new Shop<>(); 

    /**
     * Método para determinar el número de lavadoras en el
       inventario.
       @param numeroLavadoras
       @return void.*/
    public void setNumeroLavadoras(int numeroLavadoras){
        shop.setIndex(numeroLavadoras);
    }

    /**
     * Método para obtener el número de lavadoras en el
       inventario.
       @return integro, el número de lavadoras.*/
    public int getNumeroLavadoras(){
        return shop.getIndex();
    }

    /**
     * Método para buscar un electrodoméstico en específico
       según su código. 
       @return void.*/
    public void searchElectrodomestico(int codigo){
        shop.search(codigo);
    }

    /**
     * Método para determinar el tamaño del inventario.
       @param n tamaño del {@code inventario}.  
       @return void.*/
    public void setSizeInventario(int n){
        shop.setSizeInventario( d-> new Electrodomestico[n], n);
    }

    /**
     * Método para insertar electrodomésticos en el {@code inventario}.
       @param m electrodoméstico que se quiere insertar.
       @param i índice para specíficar donde se quiere insertar.   
       @return void.*/
    public void setElementsInventario(Electrodomestico m, int i){
        shop.setElementsInventario(
        p->{
              if (i<shop.getIndex() && (!m.getClass().getSimpleName().equals("Lavadora"))){
                  System.out.println("¡No se pueden insertar televisores en la sección de lavadoras!");
                  return true;
              }
              if (i>=shop.getIndex() && (!m.getClass().getSimpleName().equals("Televisor"))){
                  System.out.println("¡No se pueden insertar lavadoras en la sección de televisores!");
                  return true;
              }
              return false;
        }
        , m, i);
        return;
    }

    /**
     * Método para obtener el {@code inventario}.
       @return {@code inventario}.*/
    public Electrodomestico[] getInventario(){
        return shop.getInventario();
    }

    /**
     * Método para obtener un catálogo compuesto de los
       televisores dentro de {@code inventario}.
       @return void.*/
    public void getCatalogoTelevisores(){
        shop.getCatalogo(0);
    }
}