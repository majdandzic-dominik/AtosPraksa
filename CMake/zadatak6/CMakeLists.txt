cmake_minimum_required(VERSION 3.10)
project(zadatak6)

find_library(Student shared imported lib/libStudent.so)
find_library(Professor shared imported lib/libProfessor.so)
add_executable(${PROJECT_NAME} src/main.cpp)
target_include_directories(${PROJECT_NAME} PUBLIC include)
target_link_directories(${PROJECT_NAME} PUBLIC lib)
target_link_libraries(${PROJECT_NAME} PUBLIC Student Professor)
