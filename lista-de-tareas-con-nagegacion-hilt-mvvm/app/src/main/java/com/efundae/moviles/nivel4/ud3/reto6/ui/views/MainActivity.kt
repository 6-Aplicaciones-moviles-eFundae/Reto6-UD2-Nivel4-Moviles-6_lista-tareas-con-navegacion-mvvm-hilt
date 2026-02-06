package com.efundae.moviles.nivel4.ud3.reto6.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.tarea.ListaTareasViewModel
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.tarea.ListaTareasScreen
import com.pmdm.proyectobase2425.ui.theme.TareasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val vm : ListaTareasViewModel by viewModels()
        setContent {
            TareasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaTareasScreen(
                        modifier = Modifier.padding(innerPadding),
                        listaTareasVm = vm.listaTareasState,
                        onTareaEvent = vm::onTareaEvent,
                        tareaSeleccionada = vm.tareaSeleccionada
                    )
                }
            }
        }
    }
}