package com.efundae.moviles.nivel4.ud3.reto6.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.ListaTareasViewModel

@Composable
fun NavHostPrincipal(
    navController: NavHostController,
    listaTareasVM: ListaTareasViewModel
) {
    NavHost(
        navController = navController,
        startDestination = ListaTareasRoute
    ) {
        listaTareasDestination(
            onIrADetallesTarea = {
                navController.navigate(route = DetallesTareaRoute(id = it))
            },
            listaTareasVM = listaTareasVM
        )
        detallesTareaDestination(
            getTarea = listaTareasVM::getTarea,
            onIrAtras = { navController.popBackStack() }
        )
    }
}