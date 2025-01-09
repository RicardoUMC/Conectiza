package com.example.conectiza // Cambia esto según tu paquete

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Conversation(
    val name: String,
    val lastMessage: String
)

class ConversationAdapter(
    private val conversations: List<Conversation>,
    private val onItemClick: (Conversation) -> Unit
) : RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conversation, parent, false)
        return ConversationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        val conversation = conversations[position]
        Log.d("Adapter", "Mostrando conversación: ${conversation.name} - ${conversation.lastMessage}")
        holder.bind(conversation, onItemClick)
    }
    override fun getItemCount() = conversations.size

    class ConversationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private val textLastMessage: TextView = itemView.findViewById(R.id.textLastMessage)

        fun bind(conversation: Conversation, onItemClick: (Conversation) -> Unit) {
            textName.text = conversation.name
            textLastMessage.text = conversation.lastMessage
            itemView.setOnClickListener { onItemClick(conversation) }
        }
    }
}

