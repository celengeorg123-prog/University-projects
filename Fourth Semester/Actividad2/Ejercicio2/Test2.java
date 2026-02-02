/*
 * @(#)OrderAlgol.java     17.0.6  13/10/2023
 *
 * Hecho por: Jorge Enrique Celis Cortés (200267) & Juan Sebastian Manrique García (200302).
 * Institución: Universidad Militar Nueva Granada.
 * Programa: Ingenieria Informática a Distancia.
 */



package Ejercicio2;

import BinarySearch.BinarySearch;
import OrderAlgol.SelectionSort;

/**
 *  
        La clase estática Test2 se usa para probar
        las implementaciones solicitadas para el 
        segundo ejercicio empleando selection sort. 
 * @version      
        17.0.6 13 Oct 2023  @author          
        Jorge Celis & Sebastian Manrique  */
public class Test2 
{
     public static void main(String[] args) 
    {
        String[] marcas = 
        {
        "Toyota", "Ford", "Chevrolet", "Honda", "BMW", "Mercedes", "Audi", "Hyundai", "Tesla", "Volkswagen",
        "Nissan", "Kia", "Subaru", "Mazda", "Lexus", "Porsche", "Ferrari", "Jaguar", "Land Rover", "Maserati"
        };

        new SelectionSort<String>((p, q)-> p.compareTo(q) > 0).sort(marcas, 0);

        var buscado = "Porsche";

        if (BinarySearch.search(marcas, buscado) > -1)
        {
            System.out.println("La marca " + buscado + " se encontró en el conjunto.");
        } else 
        {
            System.out.println("La marca " + buscado + " no se encontró en el conjunto.");
        }
    }
}
