package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mostrar_producto.*
import kotlinx.android.synthetic.main.activity_mostrar_producto.button
import kotlinx.android.synthetic.main.activity_mostrar_producto.imagenxd
import kotlinx.android.synthetic.main.activity_mostrar_servicios.*

class MostrarServicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_servicios)

        val servicio = intent.getSerializableExtra("servicio") as Servicio

        nombre_servicio.text = servicio.nombre
        precioservicio.text = "$${servicio.precio}"
        detallesservicio.text = servicio.descripcion
        imagenxdService.setImageResource(servicio.imagen)

        val intentP = Intent(this, Googlemaps::class.java)
        button.setOnClickListener{
            startActivity(intentP)
        }

    }
}