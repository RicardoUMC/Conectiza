package com.example.conectiza

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon as Icon1
import com.example.conectiza.ui.theme.ConectizaTheme

class Tutorado : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConectizaTheme {
                TutoradoScreen()
            }
        }
    }
}

@Preview
@Composable
fun TutoradoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Contenedor principal con padding general
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            // Barra de búsqueda
            MySearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de nueva tutoría
            NewTutoriaButton()

            Spacer(modifier = Modifier.height(24.dp))

            // Sección de tutorías
            Text(
                text = "Tutorías",
                color = Color(0xFF6BC2D4), // Color personalizado
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tarjeta de una tutoría
            TutoradoCard(
                materia = "Cálculo",
                horario = "Martes 12:00 hrs.",
                tutor = "Ricardo Mora",
                lugar = "Biblioteca de ESCOM"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Texto de no más tutorías
            Text(
                text = "No hay más tutorías",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        // Agrega un Spacer para empujar la barra de navegación hacia abajo
        Spacer(modifier = Modifier.weight(1f))

        // Barra de navegación inferior
        BottomNavigationBar()
    }
}

@Composable
fun MySearchBar() {
    Row(
        modifier = Modifier
            .background(Color(0xFFEFF7F8), shape = RoundedCornerShape(24.dp))
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Buscar tutoría") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
            ),
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFEFF7F8))
        )
        Icon1(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            tint = Color.Gray
        )
    }
}

@Composable
fun NewTutoriaButton() {
    Button(
        onClick = { /* Acción */ },
        colors = ButtonDefaults.buttonColors(Color(0xFF6BC2D4)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Nueva tutoría")
        Spacer(modifier = Modifier.width(8.dp))
        Icon1(Icons.Default.Add, contentDescription = "Añadir")
    }
}

@Composable
fun TutoradoCard(materia: String, horario: String, tutor: String, lugar: String) {
    Card(
        border = BorderStroke(1.dp, Color(0xFF6BC2D4)),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .background(Color(0xFFEDF5F6))
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEDF5F6))
                .padding(16.dp)
        ) {
            Text(
                text = materia,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = horario,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tutor: $tutor",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Lugar: $lugar",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar() {
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF6BC2D4))
            ) {
                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp, 0.dp),
                    containerColor = Color(0xFF6BC2D4)
                ) {
                    NavigationBarItem(
                        icon = { Icon1(Icons.Default.Home, contentDescription = "Inicio") },
                        label = { Text("Inicio") },
                        selected = false,
                        onClick = { /* Acción */ }
                    )
                    NavigationBarItem(
                        icon = { Icon1(Icons.Default.Add, contentDescription = "Nueva tutoría") },
                        label = { Text("Nueva") },
                        selected = false,
                        onClick = { /* Acción */ }
                    )
                    NavigationBarItem(
                        icon = { Icon1(Icons.Default.Email, contentDescription = "Mensajes") },
                        label = { Text("Mensajes") },
                        selected = false,
                        onClick = { /* Acción */ }
                    )
                    NavigationBarItem(
                        icon = { Icon1(Icons.Default.Person, contentDescription = "Perfil") },
                        label = { Text("Perfil") },
                        selected = false,
                        onClick = { /* Acción */ }
                    )
                }
            }
        }
    ) {}
}
