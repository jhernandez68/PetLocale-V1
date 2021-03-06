package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_tutorial.*
import kotlinx.android.synthetic.main.content_main.*

enum class ProviderType{
    BASIC
}

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val intent = Intent(this, Productos::class.java)

        val intentService = Intent(this, Servicios::class.java)

        val intentVet = Intent(this, Veterinariasxde::class.java)

        val intentMaps = Intent(this, Googlemaps::class.java)

        imageView3.setOnClickListener(){
            startActivity(intent)
        }
        imageView4.setOnClickListener(){
            startActivity(intentVet)
        }
        imageView2.setOnClickListener(){
            startActivity(intentService)
        }

        emergencia.setOnClickListener(){
            startActivity(intentMaps)
        }

        val intent2 = Intent(this, FBListView::class.java)

        button2.setOnClickListener{
            startActivity(intent2)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}