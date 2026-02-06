package com.efundae.moviles.nivel4.ud3.reto6.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.ListaTareasScreen
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.ListaTareasViewModel
import kotlinx.serialization.Serializable

@Serializable
data object ListaTareasRoute

fun NavGraphBuilder.listaTareasDestination(
    onIrADetallesTarea: (String) -> Unit,
    listaTareasVM: ListaTareasViewModel
) {
    composable<ListaTareasRoute> {
        ListaTareasScreen(
            listaTareasVm = listaTareasVM.listaTareasState,
            onTareaEvent = listaTareasVM::onTareaEvent,
            tareaSeleccionada = listaTareasVM.tareaSeleccionada,
            onIrADetallesTarea = onIrADetallesTarea
        )
    }
}