package com.example.conectiza

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterTutorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrotutor)

        // Lista de materias
        val subjects = listOf(
            "Cálculo",
            "Álgebra Lineal",
            "Cálculo Aplicado",
            "Análisis Vectorial",
            "Mecánica y Electromagnetismo",
            "Matemáticas Discretas",
            "Ecuaciones Diferenciales",
            "Probabilidad y Estadística",
            "Matemáticas Avanzadas para Ingeniería",
            "Fundamentos de Programación",
            "Estructuras de Datos",
            "Análisis y Diseño de Algoritmos",
            "Bases de Datos",
            "Sistemas Operativos",
            "Teoría de la Computación",
            "Redes de Computadoras",
            "Compiladores",
            "Análisis y Diseño de Sistemas",
            "Formulación y Evaluación de Proyectos de Ingeniería",
            "Finanzas Empresariales",
            "Parámetros de Programación",
            "Fundamentos de Diseño Digital",
            "Circuitos Eléctricos",
            "Electrónica Analógica",
            "Instrumentación y Control",
            "Procesamiento Digital de Señales",
            "Arquitectura de Computadoras",
            "Sistemas en Chip",
            "Tecnologías para el Desarrollo de Aplicaciones Web",
            "Diseño de Sistemas Digitales",
            "Administración de Servicios en Red",
            "Aplicaciones para Comunicaciones en Red",
            "Sistemas Distribuidos",
            "Inteligencia Artificial",
            "Métodos Cuantitativos en la Toma de Decisiones",
            "Ingeniería de Software",
            "Desarrollo de Aplicaciones Móviles Nativas",
            "Liderazgo Personal",
            "Gestión Empresarial",
            "Desarrollo de Habilidades Sociales para la Alta Dirección"
        )


        // Configurar el adaptador para el MultiAutoCompleteTextView
        val autoCompleteSubjects = findViewById<MultiAutoCompleteTextView>(R.id.autoCompleteSubjects)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, subjects)
        autoCompleteSubjects.setAdapter(adapter)
        autoCompleteSubjects.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        // Botón de registro (opcional: validar materias seleccionadas)
        findViewById<Button>(R.id.btnRegistro).setOnClickListener {
            val selectedSubjects = autoCompleteSubjects.text.toString().split(",").map { it.trim() }
            if (selectedSubjects.isEmpty() || selectedSubjects[0].isEmpty()) {
                Toast.makeText(this, "Por favor selecciona al menos una materia.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Materias seleccionadas: $selectedSubjects", Toast.LENGTH_SHORT).show()
                // Aquí puedes proceder a guardar el registro
            }
        }
    }
}
