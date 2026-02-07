package com.efundae.moviles.nivel4.ud3.reto6.ui.features.detallesTarea


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.efundae.moviles.nivel4.ud3.reto6.ui.composables.Espacio
import com.efundae.moviles.nivel4.ud3.reto6.ui.composables.estiloLineaDetallesTarea
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.TareaUiState
import java.time.format.DateTimeFormatter


@Preview(showBackground = true)
@Composable
fun DetallesTarea(
    onIrAtras: () -> Unit = {},
    tareaSeleccionada: TareaUiState = TareaUiState()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .border(2.dp, MaterialTheme.colorScheme.primary)
                    .padding(all = 20.dp)
            ) {
                Text(
                    text = "Detalles de la tarea",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Espacio(n = 15)
                Text(
                    text = estiloLineaDetallesTarea(
                        campo = "ID: ",
                        valor = tareaSeleccionada.id.toString()
                    )
                )
                Espacio(n = 5)
                Text(
                    text = estiloLineaDetallesTarea(
                        campo = "Título: ",
                        valor = tareaSeleccionada.titulo
                    )
                )
                Espacio(n = 5)
                Text(
                    text = estiloLineaDetallesTarea(
                        campo = "Descripción: ",
                        valor = tareaSeleccionada.descripcion
                    )
                )
                Espacio(n = 5)
                Text(
                    text = estiloLineaDetallesTarea(
                        campo = "Fecha: ",
                        valor = tareaSeleccionada.fecha.format(
                            DateTimeFormatter.ofPattern(
                                "dd/MM/y"
                            )
                        )
                    )
                )
                Espacio(n = 5)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = estiloLineaDetallesTarea(
                            campo = "Completada: "
                        )
                    )
                    Icon(
                        imageVector = if (tareaSeleccionada.completada) Icons.Filled.Check else Icons.Filled.Clear,
                        contentDescription = if (tareaSeleccionada.completada) "Completada" else "No completada",
                        tint = if (tareaSeleccionada.completada) {
                            Color(
                                red = 27,
                                green = 109,
                                blue = 27,
                                alpha = 255
                            )
                        } else Color.Red
                    )
                }
            }
            Espacio(n = 10)
            Button(onClick = onIrAtras) {
                Text(text = "Volver")
            }
        }
    }
}