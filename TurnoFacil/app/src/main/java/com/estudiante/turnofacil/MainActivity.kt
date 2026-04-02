package com.estudiante.turnofacil

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val servicios = arrayListOf(
        "Asesoría Académica",
        "Certificados",
        "Bienestar Universitario",
        "Secretaría Académica",
        "Pagos y Financiera",
        "Biblioteca"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listViewServicios)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, servicios)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("posicion", position)
            startActivity(intent)
        }
    }
}