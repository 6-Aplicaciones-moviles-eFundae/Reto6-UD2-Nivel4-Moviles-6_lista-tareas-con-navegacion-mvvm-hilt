package com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListaTareasScreen(
    listaTareasVm: MutableList<TareaUiState> = mutableListOf(),
    onTareaEvent: (TareaEvent) -> Unit,
    tareaSeleccionada: TareaUiState?,
    onIrADetallesTarea : (String) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(paddingValues = innerPadding)
        ) {
            Text(
                modifier = Modifier.clickable(onClick = { onIrADetallesTarea("ª") }),
                text = "Hola, Ainara"
            )
        }
    }
}