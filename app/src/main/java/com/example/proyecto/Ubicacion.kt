package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

private lateinit var map3: GoogleMap

class Ubicacion : AppCompatActivity() , OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicacion)
        createFragment()
    }

    private fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map3) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map3 = googleMap
        createMarker(4.694698, -74.055356, "Kanicat")
    }

    private fun createMarker(latitud: Double, longitud: Double , nombre: String){
        val coordinates = com.google.android.gms.maps.model.LatLng(latitud, longitud)
        val marker = MarkerOptions().position(coordinates).title(nombre)
        map3.addMarker(marker)
        map3.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f), 4000, null
        )
    }
}