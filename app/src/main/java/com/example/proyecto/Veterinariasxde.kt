package com.example.proyecto
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class Veterinariasxde : AppCompatActivity() {

    lateinit var listViewVet: ListView
    var Vets: ArrayList<String> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null
    lateinit var etSearchVet: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veterinariasxde)
        listViewVet = findViewById(R.id.listViewVet)
        etSearchVet = findViewById(R.id.etSearchVet)

        Vets.add("VetVet")
        Vets.add("PetShop")
        Vets.add("Kanicats")
        Vets.add("AnimalShall")
        Vets.add("Sibate Pets")
        Vets.add("Soluvet")
        Vets.add("Clinivet")
        Vets.add("Kannes")
        Vets.add("Javiagro")
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, Vets)
        listViewVet.adapter = arrayAdapter
        etSearchVet.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                arrayAdapter!!.filter.filter(s)
            }
            override fun afterTextChanged(s: Editable) {}
        })
    }
}