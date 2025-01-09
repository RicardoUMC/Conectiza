package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomeActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        // Obtener referencia al botón
        val buttonLogin = findViewById<Button>(R.id.newButtonRegister)

        // Configurar el clic para ir a HomeActivity2
        buttonLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Encontrar el ImageButton por su ID
        val newButtonTutor = findViewById<ImageButton>(R.id.newButtonTutor)

        // Configurar el listener de clic
        newButtonTutor.setOnClickListener {
            // Crear un Intent para navegar a RegisterTutorActivity
            val intent = Intent(this, Iniciodesesion::class.java)
            startActivity(intent)
        }

        // Encontrar el ImageButton por su ID
        val newButtonTutorado = findViewById<ImageButton>(R.id.newButtonTutorado)

        // Configurar el listener de clic
        newButtonTutorado.setOnClickListener {
            // Crear un Intent para navegar a RegisterTutorActivity
            val intent = Intent(this, Iniciodesesion2::class.java)
            startActivity(intent)
        }
    }
}
