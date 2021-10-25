package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_productos.*

class Productos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val producto = Producto("Comida para perro", 100000.0,"Dog Chow, para perros de 7 años o más", R.drawable.iconproducto1 )
        val producto2 = Producto("Comida para perro", 100000.0,"Dog Chow, para perros de 7 años o más", R.drawable.iconproducto1 )
        val producto3 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto4 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto5 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto6 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto7 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto8 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto9 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)
        val producto10 = Producto ("Disponible pronto!", 0.0, "Servicio | Producto | Veterinaria disponible pronto!",R.drawable.ic_menu_gallery)

        val listaProductos = listOf(producto, producto2, producto3, producto4, producto5, producto6, producto7, producto8, producto9, producto10)

        val adapter = ProductosAdapter(this, listaProductos)
        lista.adapter = adapter

        lista.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this, MostrarProducto::class.java)
            intent.putExtra("producto", listaProductos[i])
            startActivity(intent)
        }


    }

}

