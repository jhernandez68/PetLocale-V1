package com.example.proyecto


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_resenias_service.*

class reseniasService : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    var limitS = 10
    var limitI = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resenias_service)

        var count : Int

    }

    fun guess (view: View){
        val enteredNumber = calTextService?.text.toString().toInt()
        when {
            enteredNumber > limitS -> {
                Toast.makeText(this, "Fuera de rango", Toast.LENGTH_LONG).show()
            }
            enteredNumber < limitI -> {
                Toast.makeText(this, "Fuera de rango", Toast.LENGTH_LONG).show()
            }
            else -> {
                sendButtonService.setOnClickListener{
                    db.collection("Veterinarias").document("Reseñas").collection("Reseñas").document("ReseñasServicios").set(
                        hashMapOf(
                            "Reseña" to reseniaTextService.text.toString(),
                            "Calificación" to calTextService.text.toString().toInt(),
                            "Veterinaria" to "VetVet",
                            "Tipo" to "Servicios"
                        )
                    )
                    Toast.makeText(this, "Comentario Enviado", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}