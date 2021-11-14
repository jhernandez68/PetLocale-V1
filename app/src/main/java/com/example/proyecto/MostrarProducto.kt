package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_mostrar_producto.*
import kotlinx.android.synthetic.main.content_main.*

class MostrarProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_producto)

        val producto = intent.getSerializableExtra("producto") as Producto

        nombre_producto.text = producto.nombre
        precioproducto.text = "$${producto.precio}"
        detalles.text = producto.descripcion
        imagenxd.setImageResource(producto.imagen)

        val intentP = Intent(this, Googlemaps::class.java)
        button.setOnClickListener{
            startActivity(intentP)
        }

    }
}