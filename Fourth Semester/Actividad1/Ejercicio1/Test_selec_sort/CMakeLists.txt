cmake_minimum_required(VERSION 3.27)

add_executable(Selec_sort  Test.cpp)

target_link_libraries(Selec_sort 
PRIVATE Ordenar_selec Rand_ag Minimum)