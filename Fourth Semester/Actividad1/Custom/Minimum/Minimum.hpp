#ifndef MINIMUM
#define MINIMUM

/*
* Hecho por: Jorge Enrique Celis Cortés
* Institución: Facultad de Estudios a Distancia, Universidad Militar Nueva Granada
* Programa: Ingenieria informática a distancia
* Código: 200267
* Standar: CXX VERSION 20
*/

/*Función encargada de encontrar el índice del elemento 
  más pequeño del arreglo empezando desde 
  el indice lw (default 0). 

* Note: Está version asume que '>' está definido para 
  los elementos en cuestión. 

* @param array un arreglo estático cualquiera
* @param n tamaño del arreglo
* @param lw índice de comienzo */
template <typename T>
int find_min(T* array, int n, int lw = 0)
{
  int k{lw};

  for (int i{lw+1}; i < n; i++)
  {
    if (array[k] > array[i]) k = i;
  }

  return k;
}

/*Función encargada de encontrar el índice del elemento 
  más pequeño del arreglo empezando desde 
  el indice lw (default 0). 

* @param array un arreglo estático cualquiera
* @param n tamaño del arreglo
* @param lw índice de comienzo 
* @param crit criterio de ordenamiento (lambda) */
template <typename T, class K>
int find_min(T &array, int n, const K &crit, int lw = 0)
{
  int k{lw};

  for (int i{lw+1}; i < n; i++)
  {
    if (crit(array[k], array[i])) k = i;
  }

  return k;
}

#endif