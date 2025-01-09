package com.example.conectiza

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarChat)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewChat)
        val inputMessage = findViewById<EditText>(R.id.editTextMessage)
        val buttonSend = findViewById<ImageButton>(R.id.buttonSend)

        // Configurar el Toolbar
        setSupportActionBar(toolbar)

        // Obtener el nombre del tutor desde el Intent
        val conversationName = intent.getStringExtra("conversation_name") ?: "Chat"
        supportActionBar?.title = conversationName

        // Configurar RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Lista de mensajes de ejemplo
        val messages = mutableListOf(
            Message("Hola, quisiera una asesoría para redes 1", true),
            Message("Hola, claro tengo un espacio a las 9 hoy", false)
        )
        val adapter = ChatAdapter(messages)
        recyclerView.adapter = adapter

        // Enviar mensaje
        buttonSend.setOnClickListener {
            val text = inputMessage.text.toString()
            if (text.isNotEmpty()) {
                messages.add(Message(text, true))
                adapter.notifyItemInserted(messages.size - 1)
                recyclerView.scrollToPosition(messages.size - 1)
                inputMessage.text.clear()
            }
        }

        // Agregar NavBarMen usando Compose
        val composeView = findViewById<ComposeView>(R.id.composeView)
        composeView.setContent {
            NavBarMen() // Cambiado de BottomNav a NavBarMen
        }
    }
}
