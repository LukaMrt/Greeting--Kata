cmake_minimum_required(VERSION 3.21)
project(c_implementation C)

set(CMAKE_C_STANDARD 99)

add_executable(c_implementation main.c greet.h greet.c)
