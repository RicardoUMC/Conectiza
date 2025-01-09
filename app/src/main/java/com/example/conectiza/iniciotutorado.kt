package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class iniciotutorado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciotutorado)

        // Encontrar el ImageButton por su ID
        val button_ntutorias = findViewById<Button>(R.id.button_ntutorias)

        // Configurar el listener de clic
        button_ntutorias.setOnClickListener {
            val intent = Intent(this, CreateTutoringActivity::class.java)
            startActivity(intent)
        }

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

