package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Obtener referencia al botón
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        // Configurar el clic para ir a HomeActivity2
        buttonLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity2::class.java)
            startActivity(intent)
        }

        //Boton de Registro Tutor
        // Encontrar el ImageButton por su ID
        val newButtonTutor = findViewById<ImageButton>(R.id.buttonTutor)

        // Configurar el listener de clic
        newButtonTutor.setOnClickListener {
            // Crear un Intent para navegar a RegisterTutorActivity
            val intent = Intent(this, RegisterTutorActivity::class.java)
            startActivity(intent)
        }

        //Boton de Registro Tutorado
        // Encontrar el ImageButton por su ID
        val newButtonTutorado = findViewById<ImageButton>(R.id.buttonTutorado)

        // Configurar el listener de clic
        newButtonTutorado.setOnClickListener {
            // Crear un Intent para navegar a RegisterTutorActivity
            val intent = Intent(this, RegistroTutoradoActivity::class.java)
            startActivity(intent)
        }
    }
}
