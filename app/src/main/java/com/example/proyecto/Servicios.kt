package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_servicios.*


class Servicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)

        val servicio = Servicio("Servicios VetVet", 12.0,"Kanicat Actualmente cuenta con 12 Servicios, entre ellos: Baño (para perros y/o gatos)", R.drawable.iconvetvet )
        val servicio2 = Servicio("Servicios PetShop", 10.0,"PetShop cuenta actualmente con:", R.drawable.iconpetshop)
        val servicio3 = Servicio ("Servicios Kanicat", 0.0, "Kanicat cuenta actualmente con:",R.drawable.iconkanicat)

        val listaServicios = listOf(servicio, servicio2, servicio3)

        val adapter = ServiciosAdapter(this, listaServicios)

        listaService.adapter = adapter

        listaService.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this, MostrarServicios::class.java)
            intent.putExtra("servicio", listaServicios[i])
            startActivity(intent)
        }


    }

}