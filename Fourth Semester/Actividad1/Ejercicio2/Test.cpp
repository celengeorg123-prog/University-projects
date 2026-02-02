/*
* Hecho por: Jorge Enrique Celis Cortés
* Institución: Facultad de Estudios a Distancia, Universidad Militar Nueva Granada
* Programa: Ingenieria informática a distancia
* Código: 200267
* Standar: CXX VERSION 20
*/

#include <Ordenar_selec.hpp>
#include <iostream>
#include <array>
#include <iomanip>
#include <limits>

int main()
{
    srand(static_cast<unsigned> (time(0)));

    /*Arreglo arbitrario estático de más de 20 elementos. Cada elemento representa un arreglo de 
    4 elementos, donde el primer elemento es el código, el segundo es la cantidad, 
    el tercero es el precio, y el cuarto las repeticiones del producto. */
    int array[100000][4], n{sizeof(array)/sizeof(array[0])}, counter{};

    /*Utilizamos esto como un tag de orden, ya que infinitus > n
    para todo entero n */
    auto infinitus = std::numeric_limits<int>::max();

    //Esto es para la tabla de impresión
    std::array<std::string_view, 3> titles {"Codigo", "Total", "Precio promedio"};

    for (auto x: array)
    {
        x[0] = (rand() % (1051)) + 1010;
        x[1] = (rand() % (15));
        x[2] = (rand() % (101))+1 ;
        x[3] = 1;
    }

    selec_sort(array, n, 
    [infinitus, &counter](auto &x, auto &y)
    {
        if (x[0] == y[0] && x[0] != infinitus)
        {
            x[1] += y[1];
            x[2] += y[2];
            y[0] = infinitus;
            x[3] ++;
            counter ++;

            return false;
        }
        return (x[0] > y[0]) ? true : false; 
    });

    std::cout << "\n";

    //Aquí comienza la impresión de la tabla
    for (auto &x: titles)
    {
        std::cout << std::left << std::setw(5 + x.size()) << x;
    }

    std::cout << "\n\n"; 

    for (int i{}; i < n-counter; i++)
    {
        auto x = (array[i][1] != 0)? 
        static_cast<float>(array[i][2])/array[i][3]
        : 0;

        std::cout << std::left 
        << std::setw(11)
        << array[i][0]
        << std::left << std::setw(10) 
        << array[i][1] << std::setprecision(4)
        << x << "\n";
    }
    
    std::cout << "\nNumber of repetitions found: " 
    << counter << std::endl;
}