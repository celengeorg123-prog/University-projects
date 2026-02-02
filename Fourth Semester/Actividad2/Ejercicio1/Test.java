/*
 * @(#)OrderAlgol.java     17.0.6  13/10/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés (200267) & Juan Sebastian Manrique García (200302).
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 */


package Ejercicio1;

import BinarySearch.BinarySearch;
import OrderAlgol.QuickSort;
import java.util.Arrays;
import java.util.Random;


/**
 *  
        La clase estática Test se usa para probar
        las implementaciones solicitadas para el 
        primer ejercicio. 
 * @version      
        17.0.6 13 Oct 2023  @author          
        Jorge Celis & Sebastian Manrique  */
public class Test 
{
    public static void main(String[] args)
    {
        var rand = new Random();
        Integer[] array = new Integer[35];

        for (var i = 0; i < array.length; i++)
        {
            array[i] = rand.nextInt(100)+40;
        }

        System.out.println("Array no ordenado: " + Arrays.toString(array) + "\n");

        new QuickSort<Integer> ((p,q)->(p<q)?-1:(p>q)?1:0).sort(array);

        System.out.println("Array ordenado: " + Arrays.toString(array) + "\n");

        // Realizar búsqueda binaria
         var target = 43;

         var result = BinarySearch.search(array, target);
 
         if (result != -1) 
         {
            System.out.println("El elemento " + array[result] + " encontrado en la posición " + result);
         } else 
         {
            System.out.println("Elemento " + target + " no fue encontrado en el arreglo");
         }

    }
}