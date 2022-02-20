cmake_minimum_required(VERSION 3.10)
project(zadatak5)

add_executable(zadatak5 src/main.cpp src/Professor.cpp src/Student.cpp)
target_include_directories(zadatak5 PUBLIC include)
