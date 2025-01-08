package com.example.conectiza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class iniciotutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciotutor)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Manejar las selecciones del menú
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Acción para "Inicio"
                    true
                }
                R.id.nav_new -> {
                    // Acción para "Nueva tutoría"
                    true
                }
                R.id.nav_messages -> {
                    // Acción para "Mensajes"
                    true
                }
                R.id.nav_profile -> {
                    // Acción para "Perfil"
                    true
                }
                else -> false
            }
        }
    }
}

