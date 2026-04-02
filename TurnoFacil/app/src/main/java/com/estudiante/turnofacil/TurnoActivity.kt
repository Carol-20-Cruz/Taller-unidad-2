package com.estudiante.turnofacil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TurnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turno)

        val servicio = intent.getStringExtra("servicio") ?: ""
        findViewById<TextView>(R.id.tvServicioTurno).text = "Servicio: $servicio"

        findViewById<Button>(R.id.btnConfirmar).setOnClickListener {
            val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val documento = findViewById<EditText>(R.id.etDocumento).text.toString()

            if (nombre.isEmpty() || documento.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hora = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
            Toast.makeText(this, "¡Turno confirmado!\nNombre: $nombre\nDoc: $documento\nHora: $hora", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}