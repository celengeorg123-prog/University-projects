/*
 * @(#)OrderAlgol.java     17.0.6  13/10/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés (200267) & Juan Sebastian Manrique García (200302).
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 */


package Ejercicio2;

import BinarySearch.BinarySearch;
import OrderAlgol.QuickSort;

/**
 *  
        La clase estática Test1 se usa para probar
        las implementaciones solicitadas para el 
        segundo ejercicio empleando Quicksort. 
 * @version      
        17.0.6 13 Oct 2023  @author          
        Jorge Celis & Sebastian Manrique  */
public class Test1 
{
    public static void main(String[] args) 
    {
        String[] marcas = 
        {
        "Toyota", "Ford", "Chevrolet", "Honda", "BMW", "Mercedes", "Audi", "Hyundai", "Tesla", "Volkswagen",
        "Nissan", "Kia", "Subaru", "Mazda", "Lexus", "Porsche", "Ferrari", "Jaguar", "Land Rover", "Maserati"
        };

        new QuickSort<String>((p,q)->q.compareTo(p)).sort(marcas);

        var buscado = "Kia";

        if (BinarySearch.search(marcas, buscado) > -1)
        {
            System.out.println("La marca " + buscado + " se encontró en el conjunto.");
        } else 
        {
            System.out.println("La marca " + buscado + " no se encontró en el conjunto.");
        }
    }
}