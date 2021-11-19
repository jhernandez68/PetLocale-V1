package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mostrar_servicios.*

class MostrarServicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_servicios)

        val servicio = intent.getSerializableExtra("servicio") as Servicio

        nombre_servicio.text = servicio.nombre
        precioservicio.text = "#" +servicio.precio
        detallesservicio.text = servicio.descripcion
        imagenxdService.setImageResource(servicio.imagen)

        val intentP = Intent(this, ServicioBusquedaFB::class.java)
        val intentP2 = Intent(this, reseniasService::class.java)

        buttonService.setOnClickListener{
            startActivity(intentP)
        }

        resButtonService.setOnClickListener{
            startActivity(intentP2)
        }



    }
}