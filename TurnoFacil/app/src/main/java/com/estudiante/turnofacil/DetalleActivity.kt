package com.estudiante.turnofacil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    val nombres = arrayListOf("Asesoría Académica", "Certificados", "Bienestar Universitario", "Secretaría Académica", "Pagos y Financiera", "Biblioteca")
    val descripciones = arrayListOf("Orientación sobre tu proceso académico", "Solicitud de documentos oficiales", "Apoyo psicológico y social", "Trámites administrativos", "Pagos de matrícula y otros", "Préstamo de libros y recursos")
    val cupos = arrayListOf(15, 20, 10, 18, 25, 30)
    val horarios = arrayListOf("7am - 12pm", "8am - 5pm", "7am - 3pm", "8am - 4pm", "8am - 5pm", "7am - 6pm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val pos = intent.getIntExtra("posicion", 0)

        findViewById<TextView>(R.id.tvNombre).text = nombres[pos]
        findViewById<TextView>(R.id.tvDescripcion).text = descripciones[pos]
        findViewById<TextView>(R.id.tvCupos).text = "Cupos disponibles: ${cupos[pos]}"
        findViewById<TextView>(R.id.tvHorario).text = "Horario: ${horarios[pos]}"

        val btnSolicitar = findViewById<Button>(R.id.btnSolicitar)

        if (cupos[pos] == 0) {
            btnSolicitar.text = "Sin cupos"
            btnSolicitar.isEnabled = false
        } else {
            btnSolicitar.setOnClickListener {
                val intent = Intent(this, TurnoActivity::class.java)
                intent.putExtra("servicio", nombres[pos])
                startActivity(intent)
            }
        }
    }
}
