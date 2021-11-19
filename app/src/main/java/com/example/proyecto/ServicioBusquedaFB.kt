package com.example.proyecto


import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isInvisible
import com.example.proyecto.databinding.ActivityServicioBusquedaFbBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_servicio_busqueda_fb.*
import java.io.File

class ServicioBusquedaFB : AppCompatActivity() {


    lateinit var binding : ActivityServicioBusquedaFbBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityServicioBusquedaFbBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView4SFB.isInvisible = true
        textView5SFB.isInvisible = true
        textView6SFB.isInvisible = true
        textView7SFB.isInvisible = true
        textView8SFB.isInvisible = true
        textView9SFB.isInvisible = true

        binding.buscarSFB.setOnClickListener {

            val imageName = binding.editTextxdSFB.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("Images/$imageName.jpg")
            val localfile = File.createTempFile("tempImage", "jpg")

            storageRef.getFile(localfile).addOnSuccessListener {

                textView4SFB.isInvisible = false
                textView5SFB.isInvisible = false
                textView6SFB.isInvisible = false
                textView7SFB.isInvisible = false
                textView8SFB.isInvisible = false
                textView9SFB.isInvisible = false
                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView9SFB.setImageBitmap(bitmap)

                db.collection("Servicios").document("Baños").get().addOnSuccessListener {
                    textView4SFB.setText(it.get("Veterinaria") as String?)
                    textView5SFB.setText(it.get("Costo") as String?)
                    textView6SFB.setText(it.get("INFO") as String?)

                }
            }.addOnFailureListener{
                Toast.makeText(this,"No se encontró el Servicio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
