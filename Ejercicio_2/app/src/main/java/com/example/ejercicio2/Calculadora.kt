package com.example.ejercicio2

class Calculadora (
    val marca: String,
    val aniosDeVida: Int
){


    constructor (marca:String, aniosDeVida: Int) : this(marca, aniosDeVida)

    fun suma(a: Double, b: Double): Double{
        return a + b
    }

    fun resta(a: Double, b: Double): Double{
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double{
        return a * b
    }

    fun dividir (a: Double, b: Double){
        if(b == 0.0){
            println("Err: No se puede dividir entre cero")
            return 0.0
        }else{
            return a / b
        }

    }
}