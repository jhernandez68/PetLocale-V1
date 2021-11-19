package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_productos.*

class Productos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        val db = FirebaseFirestore.getInstance()

        val producto = Producto("Productos VetVet", 10.0,"La veterinaria VetVet cuenta actualmente con una cantidad de 10 productos ofrecidos, como lo son:" +
                "DogShow", R.drawable.iconvetvet )
        val producto2 = Producto("Productos PetShop", 12.0,"", R.drawable.iconpetshop )
        val producto3 = Producto ("Productos Kanicats", 15.0, "",R.drawable.iconkanicat)
        val producto4 = Producto ("Productos X Veterinaria", 0.0, "",R.drawable.ic_menu_gallery)
        val producto5 = Producto ("Produtos Veterinaria 2", 1.0, "",R.drawable.ic_menu_gallery)
        val producto6 = Producto ("Produtos Veterinaria 3", 2.0, "",R.drawable.ic_menu_gallery)
        val producto7 = Producto ("Produtos Veterinaria 4", 3.0, "",R.drawable.ic_menu_gallery)
        val producto8 = Producto ("Produtos Veterinaria 5", 4.0, "",R.drawable.ic_menu_gallery)
        val producto9 = Producto ("Produtos Veterinaria 6", 5.0, "",R.drawable.ic_menu_gallery)
        val producto10 = Producto ("Produtos Veterinaria 7", 0.0, "",R.drawable.ic_menu_gallery)
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

