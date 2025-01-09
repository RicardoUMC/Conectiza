package com.example.conectiza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Iniciodesesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciodesesion)

        // Boton para pantalla de inicio de tutor
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Configurar el listener de clic
        btnLogin.setOnClickListener {
            val intent = Intent(this, iniciotutor::class.java)
            startActivity(intent)
        }
    }
}