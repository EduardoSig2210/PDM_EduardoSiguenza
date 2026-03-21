package com.example.ejercicio1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val programas = listOf("notion 2026", "Facebook 2024", "Spotify 2026", "Chrome 2026")
        val compu = Computadora(
            ram = 16,
            memoria = 256,
            sistema = "Windows",
            programasInstalados = programas
        )

        compu.encender()

        Log.d("PRUEBA", "--- Datos Iniciales ---")
        Log.d("PRUEBA", "RAM: ${compu.ram} GB")
        Log.d("PRUEBA", "Memoria: ${compu.memoria} GB")
        Log.d("PRUEBA", "Sistema Operativo: ${compu.sistema}")
        Log.d("PRUEBA", "Aplicaciones Instaladas: ${compu.obtenerProgramas()}")

        compu.actualizar(32,512,"Ubuntu")
        Log.d("PRUEBA", "--- Despues de Actualizar ---")
        Log.d("PRUEBA", "Nueva RAM: ${compu.ram} GB")
        Log.d("PRUEBA", "Nueva Memoria: ${compu.memoria}")
        Log.d("PRUEBA", "Nuevo Sistema Operativo: ${compu.sistema}")

        compu.apagar()
    }
}