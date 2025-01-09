package com.example.conectiza

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conectiza.ui.theme.ConectizaTheme
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.util.Calendar

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
    var select by remember { mutableStateOf(false) }

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
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )

                Spacer(modifier = Modifier.height(42.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Materia", style = MaterialTheme.typography.bodyLarge)
                    TextField(
                        value = subject.value,
                        onValueChange = { subject.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFEFF7F8),
                            focusedIndicatorColor = Color(0xFF6BC2D4),
                            unfocusedIndicatorColor = Color(0xFF6BC2D4)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                val datePickerState = rememberDatePickerState()
                var showDateDialog by remember { mutableStateOf(false) }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Fecha", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF6BC2D4)),
                        onClick = {
                            showDateDialog = true
                        }) {
                        Text("Seleccionar fecha")
                    }

                    if (showDateDialog) {
                        DatePickerDialog(
                            onDismissRequest = { showDateDialog = false },
                            confirmButton = {
                                Button(onClick = { showDateDialog = false }) {
                                    Text(text = "Confirmar")
                                }
                            },
                            dismissButton = {
                                OutlinedButton(onClick = { showDateDialog = false }) {
                                    Text(text = "Cancelar")
                                }
                            }
                        ) {
                            DatePicker(
                                state = datePickerState,
                                modifier = Modifier.verticalScroll(rememberScrollState())
                            )
                        }
                    }

                    val date = datePickerState.selectedDateMillis
                    date?.let {
                        val localDate = Instant.ofEpochMilli(it)
                            .atZone(ZoneId.of("UTC"))
                            .toLocalDate()
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Fecha seleccionada: ${localDate.dayOfMonth} " +
                            "/ ${localDate.monthValue} " +
                            "/ ${localDate.year}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Left
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                val timeState = rememberTimePickerState()
                var showTimeDialog by remember { mutableStateOf(false) }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Hora", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(Color(0xFF6BC2D4)),
                        onClick = {
                            showTimeDialog = true
                        }) {
                        Text("Seleccionar hora")
                    }

                    var showSelectedTime by remember { mutableStateOf(false) }
                    if (showTimeDialog) {
                        TimePickerDialog(
                            onDismiss = { showTimeDialog = false },
                            onConfirm = {
                                showTimeDialog = false
                                showSelectedTime = true
                            }
                        ) {
                            TimeInput(state = timeState)
                        }
                    }

                    if (showSelectedTime) {
                        timeState.let {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Hora seleccionada: ${timeState.hour}" +
                                        ":${timeState.minute} ",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Left
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Lugar", style = MaterialTheme.typography.bodyLarge)
                    TextField(
                        value = place.value,
                        onValueChange = { place.value = it },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xFFEFF7F8),
                            focusedIndicatorColor = Color(0xFF6BC2D4),
                            unfocusedIndicatorColor = Color(0xFF6BC2D4)
                        )
                    )
                }

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


@Composable
fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Cancelar")
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("Confirmar")
            }
        },
        text = { content() }
    )
}