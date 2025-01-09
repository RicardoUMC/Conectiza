package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar adaptador para ViewPager
        val adapter = WelcomePagerAdapter(this)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager) // Asegúrate de que este ID sea correcto en tu XML
        viewPager.adapter = adapter

        // Registrar cambios de página en el ViewPager
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // Configura comportamiento según la página actual si es necesario
            }
        })
    }

    fun goToHome(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
