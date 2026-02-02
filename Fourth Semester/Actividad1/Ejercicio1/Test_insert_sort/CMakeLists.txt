cmake_minimum_required(VERSION 3.27)

add_executable(Insert_sort Test.cpp)

target_link_libraries(Insert_sort 
PRIVATE Ordenar_inter Rand_ag Minimum)