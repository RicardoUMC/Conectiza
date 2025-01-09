package com.example.conectiza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Iniciodesesion2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iniciodesesion2)

        // Encontrar el ImageButton por su ID
        val btnLogin2 = findViewById<Button>(R.id.btnLogin2)

        // Configurar el listener de clic
        btnLogin2.setOnClickListener {
            val intent = Intent(this, iniciotutorado::class.java)
            startActivity(intent)
        }
    }
}