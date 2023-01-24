package com.example.educacionitmvpexample.util

class EdadValidator {

    fun esMayorDeEdad(edad: Int): Boolean {
        return edad in 18..45
    }

}