/*
* Hecho por: Jorge Enrique Celis Cortés
* Institución: Facultad de Estudios a Distancia, Universidad Militar Nueva Granada
* Programa: Ingenieria informática a distancia
* Código: 200267
* Standar: CXX VERSION 20
*/

#include <Minimum.hpp>
#include <Ordenar_inter.hpp>
#include <Rand_ag.hpp>
#include <iostream>

int main()
{
    //El ejercicio solicita arreglos estáticos de tamaño arbitario
    //Este es solo un ejemplo 
    int arr[10];

    //Tamaño del arreglo
    int n{sizeof(arr)/sizeof(arr[0])};

    //Asignamos integros 1 <= k <= 90
    rand_init(arr, n, 1, 90);

    std::cout << "Arreglo original:\n\n";

    for (auto x: arr)
    {
        std::cout << x << " ";
    }

    std::cout << "\nArreglo ordenado por insercion:\n\n";

    //Remplazamos el primer el elemento por el mínimo del arreglo 
    std::swap(arr[0], arr[find_min(arr, n)]);

    //Organizamos empleando inserción desde el 2° elemento
    insert_sort(arr, n, 1);

    for(auto x: arr)
    {
        std::cout << x << " ";
    }

    std::cout << std::endl;
}