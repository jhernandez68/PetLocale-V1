package com.example.proyecto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyecto.databinding.ActivityFblistViewBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class FBListView : AppCompatActivity() {

    lateinit var binding : ActivityFblistViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFblistViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buscar.setOnClickListener {
            
            val imageName = binding.editTextxd.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("Images/$imageName.jpg")
            val localfile = File.createTempFile("tempImage", "jpg")

            storageRef.getFile(localfile).addOnSuccessListener {

                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView9.setImageBitmap(bitmap)
            }.addOnFailureListener{
                Toast.makeText(this,"No se encontró la Veterinaria", Toast.LENGTH_SHORT).show()
                 }
        }

    }
}