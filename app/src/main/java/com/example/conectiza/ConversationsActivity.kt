package com.example.conectiza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ConversationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversations)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewConversations)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val conversations = listOf(
            Conversation("Alondra Fuentes", "Hola, claro tengo un espacio a las 9"),
            Conversation("Giselle Carmona", "¿Cómo estás?"),
            Conversation("Ricardo Mora", "¿Puedes mañana?")
        )

        recyclerView.adapter = ConversationAdapter(conversations) { conversation ->
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("conversation_name", conversation.name)
            startActivity(intent)
        }

        val composeView = findViewById<ComposeView>(R.id.composeBottomNav)
        composeView.setContent {
            NavBarMen() // Cambiado de BottomNav a NavBarMen
        }
    }
}
