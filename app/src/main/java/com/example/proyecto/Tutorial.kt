package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tutorial.*

class Tutorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.SplashTeme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)


        val intent = Intent(this, Logeo::class.java)
        continuar.setOnClickListener(){
                startActivity(intent)

        }

    }
}