package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_logeo.*
import kotlinx.android.synthetic.main.activity_tutorial.*

class Logeo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logeo)

        val intent = Intent(this, Tutorial::class.java)
        entrar.setOnClickListener(){
            startActivity(intent)
        }
    }
}