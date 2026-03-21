package com.example.ejercicio2

import com.example.ejercicio2.Calculadora

fun main(){
    val calcu = Calculadora(
        marca = "Casio",
        aniosDeVida = 6
    )

    println("--- calculadora ${calcu.marca}")
    println("Años de vida: ${calcu.aniosDeVida}")

    println("15 + 5 = ${calcu.suma(15.0, 5.0)}")
    println("15 - 5 = ${calcu.resta(15.0, 5.0)}")
    println("15 * 5 = ${calcu.multiplicar(15.0, 5.0)}")
    println("15 / 5 = ${calcu.dividir(15.0, 5.0)}")

    println("15 / 0 = ${calcu.dividir(15.0, 0.0)}")
}