package com.example.educacionitmvpexample

import com.example.educacionitmvpexample.util.EdadValidator
import org.junit.Assert
import org.junit.Test

class EdadValidatorTest {

    private val edadValidator = EdadValidator()

    @Test
    fun esMenorDeEdad(){
        val edad = 15

        val resultadoDeVerificacion = edadValidator.esMayorDeEdad(edad)

        Assert.assertFalse(resultadoDeVerificacion)
    }


    @Test
    fun esMayorDeEdad(){
        val edad = 40

        val edadValida = edadValidator.esMayorDeEdad(edad)

        Assert.assertTrue(edadValida)
    }

    @Test
    fun estaMayor(){
        val edad = 60

        val resultadoDeVerificacion = edadValidator.esMayorDeEdad(edad)

        Assert.assertFalse(resultadoDeVerificacion)
    }
}