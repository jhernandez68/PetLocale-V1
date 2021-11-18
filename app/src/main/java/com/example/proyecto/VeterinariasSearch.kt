package com.example.proyecto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_veterinarias_search.*

class VeterinariasSearch : AppCompatActivity() {

    lateinit var listView: ListView
    var Vets: ArrayList<String> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null
    lateinit var etSearch: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veterinarias_search)

        listView = findViewById(R.id.listViewjaja)
        etSearch = findViewById(R.id.etSearchjaja)
        Vets.add("PetShop")
        Vets.add("VetVet")
        Vets.add("Kanicats")
        Vets.add("Clinita Jupiter")
        Vets.add("Sibapets")
        Vets.add("AnimalShall")
        Vets.add("Javiagro")
        Vets.add("Soluvet")
        Vets.add("Kannes")
        Vets.add("Clinivet")
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, Vets)
        listView.adapter = arrayAdapter
        etSearchjaja.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                arrayAdapter!!.filter.filter(s)
            }
            override fun afterTextChanged(s: Editable) {}
        })
    }
}