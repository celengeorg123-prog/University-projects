/*
 * @(#)OrderAlgol.java     17.0.6  13/10/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés (200267) & Juan Sebastian Manrique García (200302).
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 */


package OrderAlgol;

import java.util.function.BiFunction;
import java.util.Random;

/**
 *  
        La clase genérica QuickSort se usa para crear
        objetos con criterios determinados por el
        usuario para ordenar un arreglo usando quick
        sort. 
 * @version      
        17.0.6 13 Oct 2023  @author          
        Jorge Celis & Sebastian Manrique */ 
public class QuickSort <T>  
{
    /**  
    Criterio(lambda) empleado por el usuario para ordenar. */
    private BiFunction<T, T, Integer> predicate;

    /**  
    Objeto para asignación de un pivote de forma aleatoria. */
    private Random rand = new Random();

    /**
     *  Función que permite remplazar los valores de un
        arreglo cualquiera en las posiciones {@code x} &
        {@code y}.    
        @param array
        @param x
        @param y */
    private void swap(T array[], int x, int y)
    {
        var temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     *  Función que permite seleccionar el un valor 
        arbitrario del {@code array} desde la posición
        {@code left} a la posición {@code index}
        @param array
        @param left
        @param index */
    private T randSetter(T array[], int left, int index)
    {
        var rand_index = rand.nextInt(index - left) + left;

        swap(array, rand_index, index);
        
        return array[index];
    }

    /**
     *  Sets {@code predicate}. 
        @param predicate */
    public QuickSort (BiFunction<T, T, Integer> predicate)
    {
        this.predicate = predicate;
    }
    
    /**
     *  Función que ordena {@code array} desde {@code left}
        hasta {@code index} empleando el algoritmo de quicksort.
        @param array
        @param left
        @param index */
    public void sort (T array[], int left, int index) 
    {
        if (array.length < 2) return;

        int indicator = left, right = index - 1;

        T pivot = randSetter(array, left, index);

        while (left <= right) 
        {
            if 
            ( 
                predicate.apply(pivot, array[left]) > 0
                && 
                predicate.apply(pivot, array[right]) < 0
            )

            {
                swap(array, left, right);
                left ++;
                --right;
            }

            if (predicate.apply(pivot, array[left]) <= 0) left++;

            if (predicate.apply(pivot, array[right]) >= 0) --right;
        }
        
        swap(array, left, index);

        if (right > indicator) sort(array, indicator, right);
        if (left + 1 < index) sort(array, left + 1, index);
    }

    /**
     *  Misma funcionalidad que {@code sort(T array[], int left, int index)}, pero
        se asume que el usuario quiere organizar todo el arreglo. 
        @param array */
    public void sort(T array[]) {sort(array, 0, array.length - 1);}
}