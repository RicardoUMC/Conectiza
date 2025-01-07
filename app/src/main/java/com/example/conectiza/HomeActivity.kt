package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
    }
}
