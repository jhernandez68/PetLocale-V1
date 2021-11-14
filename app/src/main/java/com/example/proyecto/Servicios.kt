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

        val servicio = Servicio("Baño para perro", 300000.0,"Dog Chow, para perros de 7 años o más", R.drawable.icondog )
        val servicio2 = Servicio("Baño para gato", 150000.0,"Dog Chow, para perros de 7 años o más", R.drawable.catbanio )
        val servicio3 = Servicio ("Consulta", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.consulta)
        val servicio4 = Servicio ("Radiografia para perro", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.iconradio)
        val servicio5 = Servicio ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val servicio6 = Servicio ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val servicio7 = Servicio ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val servicio8 = Servicio ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val servicio9 = Servicio ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val servicio10 = Servicio ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)

        val listaServicios = listOf(servicio, servicio2, servicio3, servicio4, servicio5, servicio6, servicio7, servicio8, servicio9, servicio10)

        val adapter = ServiciosAdapter(this, listaServicios)

        listaService.adapter = adapter

        listaService.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this, MostrarServicios::class.java)
            intent.putExtra("servicio", listaServicios[i])
            startActivity(intent)
        }


        etSearchService.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                adapter!!.filter.filter(s)
            }
            override fun afterTextChanged(s: Editable?) {}
        })


    }

}