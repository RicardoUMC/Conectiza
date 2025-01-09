package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class iniciotutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciotutor)

        // Encontrar el ImageButton por su ID
        val button_tutorias = findViewById<Button>(R.id.button_tutorias)

        // Configurar el listener de clic
        button_tutorias.setOnClickListener {
            // Crear un Intent para navegar a RegisterTutorActivity
            val intent = Intent(this, Tutor::class.java)
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

