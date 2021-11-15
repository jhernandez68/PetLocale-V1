package com.example.proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

    class CalificacionVet : AppCompatActivity() {
    lateinit var ratingBar: RatingBar
    lateinit var button: Button
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificacion_vet)
        ratingBar = findViewById(R.id.ratingBar)
        ratingBar.numStars = 5
        button = findViewById(R.id.buttonCheck)
        textView = findViewById(R.id.textView)
        ratingBar.onRatingBarChangeListener =
            OnRatingBarChangeListener {
                    _, rating, _ ->
                Toast.makeText(
                    this@CalificacionVet, "Stars: " +
                            rating.toInt(), Toast.LENGTH_SHORT
                ).show()
            }
        button.setOnClickListener {
            textView.text = "You have got " + ratingBar.rating.toInt()+ " stars"
        }
    }
}