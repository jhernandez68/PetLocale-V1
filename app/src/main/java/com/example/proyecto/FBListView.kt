package com.example.proyecto

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isInvisible
import com.example.proyecto.databinding.ActivityFblistViewBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_fblist_view.*
import java.io.File

class FBListView : AppCompatActivity() {

    lateinit var binding : ActivityFblistViewBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFblistViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DireccionFBxd.isInvisible = true
        TelefonoFBxd.isInvisible = true
        HorarioFBxd.isInvisible = true
        textView4.isInvisible = true
        textView5.isInvisible = true
        textView6.isInvisible = true

        binding.buscar.setOnClickListener {


            DireccionFBxd.isInvisible = false
            TelefonoFBxd.isInvisible = false
            HorarioFBxd.isInvisible = false
            textView4.isInvisible = false
            textView5.isInvisible = false
            textView6.isInvisible = false
            
            val imageName = binding.editTextxd.text.toString()
            val storageRef = FirebaseStorage.getInstance().reference.child("Images/$imageName.jpg")
            val localfile = File.createTempFile("tempImage", "jpg")

            storageRef.getFile(localfile).addOnSuccessListener {

                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.imageView9.setImageBitmap(bitmap)

                db.collection("Veterinarias").document("VetVet").get().addOnSuccessListener {
                    textView4.setText(it.get("direccion") as String?)
                    textView5.setText(it.get("Telefono") as String?)
                    textView6.setText(it.get("Horario") as String?)
                }

                db.collection("Veterinarias").document("Kanicat").get().addOnSuccessListener {
                    textView4.setText(it.get("direccion") as String?)
                    textView5.setText(it.get("Telefono") as String?)
                    textView6.setText(it.get("Horario") as String?)
                }

                db.collection("Veterinarias").document("VetVet").get().addOnSuccessListener {
                    textView4.setText(it.get("direccion") as String?)
                    textView5.setText(it.get("Telefono") as String?)
                    textView6.setText(it.get("Horario") as String?)
                }

            }.addOnFailureListener{
                Toast.makeText(this,"No se encontró la Veterinaria", Toast.LENGTH_SHORT).show()
                 }
        }

    }
}