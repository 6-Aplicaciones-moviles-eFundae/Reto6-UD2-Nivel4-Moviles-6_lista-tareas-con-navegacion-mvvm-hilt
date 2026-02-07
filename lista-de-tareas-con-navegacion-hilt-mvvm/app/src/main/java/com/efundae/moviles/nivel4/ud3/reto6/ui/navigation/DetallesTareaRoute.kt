package com.efundae.moviles.nivel4.ud3.reto6.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.detallesTarea.DetallesTarea
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.TareaUiState
import kotlinx.serialization.Serializable

@Serializable
data class DetallesTareaRoute(val id: Int)

fun NavGraphBuilder.detallesTareaDestination(
    getTarea: (Int) -> TareaUiState?,
    onIrAtras: () -> Unit,
) {
    composable<DetallesTareaRoute> { backStackEntry ->
        val route = backStackEntry.toRoute<DetallesTareaRoute>()
        val tarea = getTarea(route.id)
        if (tarea != null) {
            DetallesTarea(
                onIrAtras = onIrAtras,
                tareaSeleccionada = tarea
            )
        }
    }
}
