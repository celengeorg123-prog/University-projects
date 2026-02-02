cmake_minimum_required(VERSION 3.27)

add_executable(Test Test.cpp)

target_link_libraries(Test 
PRIVATE Ordenar_selec)