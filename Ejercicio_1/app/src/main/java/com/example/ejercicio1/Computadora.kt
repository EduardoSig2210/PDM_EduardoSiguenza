package com.example.ejercicio1

import android.util.Log

class Computadora (
    var ram: Int,
    var memoria: Int,
    var sistema: String,
    var programasInstalados: List<String>
) {
    fun encender(){
        Log.d("PRUEBA", "Computadora encendida")
    }
    fun apagar(){
        Log.d("PRUEBA", "Computadora apagada")
    }
    fun actualizar(nuevaRam: Int, nuevaMem: Int, nuevoOS: String){
        ram = nuevaRam
        memoria = nuevaMem
        sistema = nuevoOS
        Log.d("PRUEBA", "Computadora actualizada")
    }
    fun obtenerProgramas(): List<String> {
        return programasInstalados.filter { it.contains("2026")}
    }
}