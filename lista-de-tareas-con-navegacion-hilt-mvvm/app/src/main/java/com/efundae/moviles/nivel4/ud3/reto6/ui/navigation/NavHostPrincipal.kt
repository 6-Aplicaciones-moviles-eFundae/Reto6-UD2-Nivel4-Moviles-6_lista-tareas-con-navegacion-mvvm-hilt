package com.efundae.moviles.nivel4.ud3.reto6.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.ListaTareasViewModel

@Composable
fun NavHostPrincipal(
    navController: NavHostController,
    listaTareasViewModel: ListaTareasViewModel
) {
    NavHost(
        navController = navController,
        startDestination = ListaTareasRoute
    ) {
        listaTareasDestination(
            onIrADetallesTarea = { mensaje ->
                navController.navigate(route = DetallesTareaRoute(mensaje))
            },
            listaTareasVM = listaTareasViewModel
        )
        detallesTareaDestination {
            navController.popBackStack()
        }
    }
}