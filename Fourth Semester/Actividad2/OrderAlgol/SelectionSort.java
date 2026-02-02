/*
 * @(#)OrderAlgol.java     17.0.6  12/10/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés (200267) & Juan Sebastian Manrique García (200302).
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 */
 
package OrderAlgol;

import java.util.function.BiPredicate;

/**
 *   
        La clase genérica SelectionSort  se usa para crear
        objetos con criterios determinados por el
        usuario para ordenar un arreglo usando selection
        sort
 * @version      
        17.0.6 12 Oct 2023  @author          
        Jorge Celis & Sebastian Manrique */ 
public class SelectionSort <T> 
{
    /**  
    Criterio(lambda) empleado por el usuario para ordenar. */
    private BiPredicate<T,T> predicate;

    /**
     *  Permite inicializar (set) {@code predicate}.    
        @param predicate */
    public SelectionSort (BiPredicate<T,T> predicate)
    {
        this.predicate = predicate;
    }
    
    /**
     *  Ordena {@code array} empleando selection sort desde
        {@code lw} elemento.    
        @param array
        @param lw */
    public void sort(T array[], int lw)
    {
        for (var i = lw; i < array.length - 1; i++)
        {
            var k = i;

            for (var j = i+1; j < array.length; j++)
            {
                if (predicate.test(array[k], array[j])) k = j;
            }

            var temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }
}