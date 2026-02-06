package com.efundae.moviles.nivel4.ud3.reto6.ui.features.tarea

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListaTareasScreen(
    modifier: Modifier = Modifier,
    listaTareasVm: MutableList<TareaUiState> = mutableListOf(),
    onTareaEvent: (TareaEvent) -> Unit,
    tareaSeleccionada: TareaUiState?
) {
    Column(modifier) {
        Text("Hola, Ainara")
    }
}