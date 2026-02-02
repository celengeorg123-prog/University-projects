/*
 * @(#)Tienda.java     17.0.6  2/03/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés.
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 * Código estudiantil: 200267
 */


package ejercicio2.TiendaProductosImplementation;

import actividad2.ejercicio1.Customs.Shop;

/**
 *  
      Clase cuya finalidad es la de simular una tienda
      que posee un inventario binario de productos 
      consumibles (probablemente en un sentido nutricional) 
      como productos perecederos y no perecederos.
 * @version      
      17.0.6 06 Jan 2023   @author          
      Jorge Celis  */
public final class Tienda {
    
    /**  
    Implementación compositiva de {@link Shop} .*/
    private Shop<Producto> shop = new Shop<>();

    /**
     * Método para determinar el número de perecederos en el
       inventario.
       @param numeroPerecederos
       @return void.*/
    public void setNumeroPerecederos(int numeroPerecederos){
        shop.setIndex(numeroPerecederos);
    }

    /**
     * Método para obtener el número de perecederos del
       {@code inventario}.
       @param numeroPerecederos
       @return integro, el número de perecederos.*/
    public int getNumeroPerecederos(){
        return shop.getIndex();
    }

    /**
     * Método para buscar un producto específico según
       su {@code codigo}.
       @param codigo del producto.
       @return void.*/
    public void searchProducto(int codigo){
        shop.search(codigo);
    }

     /**
     * Método para buscar un producto específico según
       su {@code codigo}.
       @param codigo del producto.
       @return void.*/ 
    public void setSizeItinerario(int n){
        shop.setSizeInventario(b->new Producto[n], n);
    }

    /**
     * Método para insertar productos en el {@code inventario}.
       @param m producto que se quiere insertar.
       @param i índice para specíficar donde se quiere insertar.   
       @return void.*/
    public void setElementsItinerario(Producto m, int i){
        shop.setElementsInventario(
        p->{
            if (i<shop.getIndex() && (!m.getClass().getSimpleName().equals("ProductoPerecedero"))){
                System.out.println("¡No se pueden insertar no perecederos en la sección de perecederos!");
                return true;
            }
            if (i>=shop.getIndex() && (!m.getClass().getSimpleName().equals("ProductoNoPerecedero"))){
                System.out.println("¡No se pueden insertar perecederos en la sección de no perecederos!");
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
    public Producto[] getItinerario(){
        return shop.getInventario();
    }

    /**
     * Método para obtener un catálogo compuesto de los
       productos no perecederos dentro de {@code inventario}.
       @return void.*/
    public void getCatalogoNoPerecederos(){
        shop.getCatalogo(0);
    }
}
