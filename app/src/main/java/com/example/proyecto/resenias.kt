package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_resenias.*

class resenias : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    var limitS = 10
    var limitI = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resenias)

        var count : Int

    }

    fun guess (view: View){
        val enteredNumber = calText?.text.toString().toInt()
        when {
            enteredNumber > limitS -> {
                Toast.makeText(this, "Fuera de rango", Toast.LENGTH_LONG).show()
            }
            enteredNumber < limitI -> {
                Toast.makeText(this, "Fuera de rango", Toast.LENGTH_LONG).show()
            }
            else -> {
                sendButton.setOnClickListener{
                    db.collection("Veterinarias").document("Reseñas").set(
                        hashMapOf(
                            "Reseña" to reseniaText.text.toString(),
                            "Calificación" to calText.text.toString().toInt(),
                            "Veterinaria" to "VetVet"
                        )
                    )
                    Toast.makeText(this, "Comentario Enviado", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}