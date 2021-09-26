package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_logeo.*
import kotlinx.android.synthetic.main.activity_registroxd.*

class Registroxd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registroxd)

        val intent = Intent(this, Tutorial::class.java)
        registrarse.setOnClickListener(){
            startActivity(intent)
        }
    }
}