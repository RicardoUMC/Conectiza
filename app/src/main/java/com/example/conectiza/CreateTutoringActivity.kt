package com.example.conectiza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conectiza.ui.theme.ConectizaTheme

class CreateTutoringActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConectizaTheme {
                CreateTutoringScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CreateTutoringScreen() {
    val subject = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }
    val place = remember { mutableStateOf("") }

    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Crear tutoría",
                    fontSize = 28.sp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                TextField(
                    value = subject.value,
                    onValueChange = { subject.value = it },
                    label = { Text("Materia") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFEFF7F8),
                        focusedIndicatorColor = Color(0xFF6BC2D4),
                        unfocusedIndicatorColor = Color(0xFF6BC2D4)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = date.value,
                    onValueChange = { date.value = it },
                    label = { Text("Fecha (DD/MM/AAAA)") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFEFF7F8),
                        focusedIndicatorColor = Color(0xFF6BC2D4),
                        unfocusedIndicatorColor = Color(0xFF6BC2D4)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = time.value,
                    onValueChange = { time.value = it },
                    label = { Text("Hora (HH:MM)") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFEFF7F8),
                        focusedIndicatorColor = Color(0xFF6BC2D4),
                        unfocusedIndicatorColor = Color(0xFF6BC2D4)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = place.value,
                    onValueChange = { place.value = it },
                    label = { Text("Lugar") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFEFF7F8),
                        focusedIndicatorColor = Color(0xFF6BC2D4),
                        unfocusedIndicatorColor = Color(0xFF6BC2D4)
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* Lógica para registrar la tutoría */ },
                    colors = ButtonDefaults.buttonColors(Color(0xFF6BC2D4)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Crear", color = Color.White)
                }
            }
        }
    )
}
