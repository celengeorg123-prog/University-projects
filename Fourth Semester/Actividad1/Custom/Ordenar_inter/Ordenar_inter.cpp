/*
* Hecho por: Jorge Enrique Celis Cortés
* Institución: Facultad de Estudios a Distancia, Universidad Militar Nueva Granada
* Programa: Ingenieria informática a distancia
* Código: 200267
* Standar: CXX VERSION 20
*/

#include "Ordenar_inter.hpp"
#include <iostream>

/*Función mutable que organiza un arreglo de números enteros 
  por inserción empleando el orden parcial '<=' y empezando 
  desde el indice lw (default 0). 
* @param array arreglo de números enteros cualquiera
* @param n tamaño del arreglo
* @param lw índice de comienzo */
void insert_sort(int array[], int n, int lw)
{
    for (int i{lw}; i<n; i++)
    {
        int key{array[i]}, j{i-1};

        for (; j >= 0 && array[j] > key; --j)
        {
            array[j+1] = array[j];
        }

        array[j+1] = key;
    }
}