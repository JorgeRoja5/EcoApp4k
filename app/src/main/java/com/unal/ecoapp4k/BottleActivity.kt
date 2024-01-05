package com.unal.ecoapp4k

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BottleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottle)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val calcularButton = findViewById<Button>(R.id.button8)
        val resultadoTextView = findViewById<TextView>(R.id.resultado)
        calcularButton.setOnClickListener {
            // Verificar si el EditText no está vacío
            if (editTextNumber.text.isNotEmpty()) {
                // Obtener el valor ingresado y convertirlo a entero
                val botellas = editTextNumber.text.toString().toInt()

                // Calcular el resultado (1 botella = 10 puntos)
                val puntos = botellas * 10

                // Mostrar el resultado en el TextView
                resultadoTextView.text = "Puntos: $puntos"
            } else {
                // Si el EditText está vacío, mostrar un mensaje de error
                resultadoTextView.text = "Por favor, ingrese la cantidad de botellas."
            }
        }
    }
}