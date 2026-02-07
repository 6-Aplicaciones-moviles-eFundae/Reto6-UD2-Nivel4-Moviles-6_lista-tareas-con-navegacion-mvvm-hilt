package com.efundae.moviles.nivel4.ud3.reto6.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.ListaTareasViewModel
import com.efundae.moviles.nivel4.ud3.reto6.ui.navigation.NavHostPrincipal
import com.pmdm.proyectobase2425.ui.theme.TareasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val tareasVM: ListaTareasViewModel by viewModels()
            val navController = rememberNavController()
            TareasTheme {
                NavHostPrincipal(
                    navController = navController,
                    listaTareasVM = tareasVM
                )
            }
        }
    }
}