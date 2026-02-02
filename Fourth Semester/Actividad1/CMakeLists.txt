cmake_minimum_required(VERSION 3.27)

project(Actividad1 VERSION 20 LANGUAGES CXX)

include(CTest)
enable_testing()

add_subdirectory(Custom/Ordenar_inter)
add_subdirectory(Custom/Rand_ag)
add_subdirectory(Custom/Ordenar_selec)
add_subdirectory(Custom/Minimum)
add_subdirectory(Ejercicio1/Test_insert_sort)
add_subdirectory(Ejercicio1/Test_selec_sort)
add_subdirectory(Ejercicio2)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_NAME})

include(CPack)