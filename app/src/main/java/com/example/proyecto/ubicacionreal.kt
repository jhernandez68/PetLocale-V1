package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_ubicacionreal.*

class ubicacionreal : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var map2:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicacionreal)
        createFragment()
    }

    private fun createFragment(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map2) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map2 = googleMap
        createMarker(4.630608, -74.190660, "VetVet")
    }

    private fun createMarker(latitud: Double, longitud: Double , nombre: String){
        val coordinates = com.google.android.gms.maps.model.LatLng(latitud, longitud)
        val marker = MarkerOptions().position(coordinates).title(nombre)
        map2.addMarker(marker)
        map2.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f), 4000, null
        )
    }
}