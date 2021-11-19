package com.example.proyecto
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_veterinariasxde.*

class Veterinariasxde : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    var months: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veterinariasxde)

            db.collection("Lista").document("Veterinarias").get().addOnSuccessListener {
                veterinaria.setText(it.get("Nombre") as String?)
                Veterinaria.setText(it.get("Nombre3") as String?)
            }
        val intentP = Intent(this, ubicacionreal::class.java)
        val intentU = Intent (this, Ubicacion::class.java)
        val intentP2 = Intent(this, VeterinariasSearch::class.java)
        Location.setOnClickListener{
            startActivity(intentP)
        }

        location.setOnClickListener{
            startActivity(intentU)
        }

        listbutton.setOnClickListener{
            startActivity(intentP2)
        }

    }
}