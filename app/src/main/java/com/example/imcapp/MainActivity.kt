package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        solicitarInformacoes()
    }

    private fun solicitarInformacoes() {
        println("Por favor, informe seu sexo (M para masculino, F para feminino): ")
        val sexo = readLine()?.toUpperCase()

        println("Por favor, informe sua altura em metros (ex: 1.75): ")
        val altura = readLine()?.toDouble()

        if (sexo == "M" || sexo == "F") {
            val pesoIdeal = calcularPesoIdeal(sexo, altura)
            println("Seu peso ideal é: $pesoIdeal kg")
        } else {
            println("Sexo inválido.")
        }
    }

    private fun calcularPesoIdeal(sexo: String?, altura: Double?): Double {
        return when (sexo) {
            "M" -> altura?.let { 72.7 * it - 58.0 } ?: 0.0
            "F" -> altura?.let { 62.1 * it - 44.7 } ?: 0.0
            else -> 0.0
        }
    }
}
