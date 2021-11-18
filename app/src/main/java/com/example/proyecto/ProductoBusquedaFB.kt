package com.example.proyecto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyecto.databinding.ActivityProductoBusquedaFbBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_producto_busqueda_fb.*
import java.io.File

class ProductoBusquedaFB : AppCompatActivity() {


    lateinit var binding : ActivityProductoBusquedaFbBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductoBusquedaFbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buscarPBFB.setOnClickListener {

            val imageName = binding.editTextxdPBFB.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("Images/$imageName.jpg")
            val localfile = File.createTempFile("tempImage", "jpg")

            storageRef.getFile(localfile).addOnSuccessListener {

                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView9PBFB.setImageBitmap(bitmap)

                db.collection("Productos").document("DogShow").get().addOnSuccessListener {
                    textView4PBFB.setText(it.get("Veterinaria") as String?)
                    textView5PBFB.setText(it.get("Costo") as String?)
                    textView6PBFB.setText(it.get("Cantidad") as String?)

                }
            }
        }
    }
}