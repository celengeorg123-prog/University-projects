#ifndef ORDENAR_SELEC
#define ORDENAR_SELEC

/*
* Hecho por: Jorge Enrique Celis Cortés
* Institución: Facultad de Estudios a Distancia, Universidad Militar Nueva Granada
* Programa: Ingenieria informática a distancia
* Código: 200267
* Standar: CXX VERSION 20
*/

#include <algorithm>

/*Función mutable que organiza un arreglo por selección 
  empleando un criterio específico y empezando 
  desde el indice lw (default 0). 
* @param array cualquiera
* @param n tamaño del arreglo
* @param criteria criterio de ordenamiento (lambda)
* @param lw índice de comienzo
 */
template<class T, class K> 
void selec_sort(T* arr, int n, const K &criteria, int lw = 0)
{
    for (int i{lw}; i < n-1; i++)
    {
        int k{i};

        for (int j{i+1}; j < n; j++)
        {
            if (criteria (arr[k], arr[j])) k = j;
        }

        std::swap(arr[i], arr[k]);
    }
}

/*Función mutable que organiza un arreglo por selección 
  empezando desde el indice lw (default 0) y asumiendo que
  el operador '>' está definido para los datos. 
* @param array cualquiera
* @param n tamaño del arreglo
* @param lw índice de comienzo */
template<class T> 
void selec_sort(T* arr, int n, int lw = 0)
{
    for (int i{lw}; i < n-1; i++)
    {
        int k{i};

        for (int j{i+1}; j < n; j++)
        {

            if (arr[k] > arr[j]) k = j;
        }

        std::swap(arr[i], arr[k]);
    }
}

#endif