package com.efundae.moviles.nivel4.ud3.reto6.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.detallesTarea.DetallesTarea
import kotlinx.serialization.Serializable

@Serializable
data class DetallesTareaRoute(
    val mensaje : String
)

fun NavGraphBuilder.detallesTareaDestination(
    onIrAtras : () -> Unit
) {
    composable<DetallesTareaRoute> { backStackEntry ->
        val route = backStackEntry.toRoute<DetallesTareaRoute>()
        DetallesTarea(
            mensaje = route.mensaje,
            onIrAtras = onIrAtras
        )
    }
}
