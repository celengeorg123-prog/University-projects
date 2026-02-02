/*
* Hecho por: Jorge Enrique Celis Cortés
* Institución: Facultad de Estudios a Distancia, Universidad Militar Nueva Granada
* Programa: Ingenieria informática a distancia
* Código: 200267
* Standar: CXX VERSION 20
*/

#include "Rand_ag.hpp"

/*Función mutable que asigna números aleatorios a un 
arreglo con números entre lb y ub. 
* @param arr arreglo de enteros cualquiera
* @param n tamaño del arreglo
* @param lb entero más pequeño
* @param ub entero más grande */
void rand_init(int arr[], int n, int lb, int ub)
{
    for (int i{}; i<n; i++)
    {
        arr[i] = (rand() % (ub - lb + 1)) + lb;
    }
}