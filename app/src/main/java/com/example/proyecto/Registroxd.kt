package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_logeo.*
import kotlinx.android.synthetic.main.activity_registroxd.*

class Registroxd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registroxd)

        registrarse.setOnClickListener{
            if(editTextTextEmailAddress.text.isNotEmpty() && editTextPhone.text.isNotEmpty() && editTextTextPassword.text.isNotEmpty()){
             FirebaseAuth.getInstance().createUserWithEmailAndPassword(editTextTextEmailAddress.text.toString()
                 , editTextTextPassword.text.toString()).addOnCompleteListener{
                     if(it.isSuccessful){
                        showMain(it.result?.user?.email?: "", ProviderType.BASIC)
                     }else{
                        showAlert()
                     }
             }
            }

        }
    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showMain(email: String, provider: ProviderType){
        val homeIntent = Intent(this,MainActivity::class.java).apply {

        }
        startActivity(homeIntent)
    }
}