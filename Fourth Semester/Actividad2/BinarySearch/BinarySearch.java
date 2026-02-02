/*
 * @(#)OrderAlgol.java     17.0.6  09/10/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés (200267) & Juan Sebastian Manrique García (200302).
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 */


package BinarySearch;

/**
 *  
        La clase estática BinarySearch se usa para crear
        buscar elementos ordenados ya sea en listas de integros
        o listas de cadenas.  
 * @version      
        17.0.6 13 Oct 2023  @author          
        Jorge Celis & Sebastian Manrique  */ 
public class BinarySearch 
{
    /**
     *  Función para realizar búsqueda binaria en un arreglo ordenado
        de mayor a menor de enteros.   
        @param array
        @param target */
    public static int search(Integer[] array, int target) 
    {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) 
        {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) 
            {
                return mid; // Encontrado
            } else if (array[mid] > target) 
            {
                low = mid + 1;
            } else 
            {
                high = mid - 1;
            }
        }

        return -1; // No encontrado
    }

    /**
     *  Función para realizar búsqueda binaria en un arreglo ordenado
        de cadenas de forma alfabética.   
        @param array
        @param target */
    public static int search(String[] array, String target) 
    {
        int izquierda = 0;
        int derecha = array.length - 1;

        while (izquierda <= derecha) 
        {
            int medio = (int)(derecha + izquierda) / 2;

            int comparacion = array[medio].compareTo(target);

            if (comparacion == 0) 
            {
                return medio;

            } else if (comparacion < 0)
            {
                izquierda = medio + 1;
            } else 
            {
                derecha = medio - 1;
            }
        }

        return -1;
    }
}