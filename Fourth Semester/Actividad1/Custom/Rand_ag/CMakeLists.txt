cmake_minimum_required(VERSION 3.27)

add_library(Rand_ag Rand_ag.cpp) 

target_include_directories(Rand_ag PUBLIC ${CMAKE_CURRENT_LIST_DIR})