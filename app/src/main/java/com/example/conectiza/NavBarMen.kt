package com.example.conectiza

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NavBarMen() { // Cambiamos el nombre de la función
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6BC2D4))
    ) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            containerColor = Color(0xFF6BC2D4)
        ) {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                label = { androidx.compose.material3.Text("Inicio") },
                selected = false,
                onClick = { /* Acción para Inicio */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Add, contentDescription = "Nueva tutoría") },
                label = { androidx.compose.material3.Text("Nueva") },
                selected = false,
                onClick = { /* Acción para Nueva tutoría */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Email, contentDescription = "Mensajes") },
                label = { androidx.compose.material3.Text("Mensajes") },
                selected = false,
                onClick = { /* Acción para Mensajes */ }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                label = { androidx.compose.material3.Text("Perfil") },
                selected = false,
                onClick = { /* Acción para Perfil */ }
            )
        }
    }
}
