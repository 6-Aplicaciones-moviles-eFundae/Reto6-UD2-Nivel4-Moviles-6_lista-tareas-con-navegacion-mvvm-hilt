package com.efundae.moviles.nivel4.ud3.reto6.ui.features.detallesTarea

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetallesTarea(
    mensaje: String = "",
    onIrAtras: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(paddingValues = innerPadding)
        ) {
            Text(text = "Mensaje de la tarea: $mensaje")
            Button(onClick = onIrAtras) {
                Text(text = "Volver")
            }
        }
    }
}