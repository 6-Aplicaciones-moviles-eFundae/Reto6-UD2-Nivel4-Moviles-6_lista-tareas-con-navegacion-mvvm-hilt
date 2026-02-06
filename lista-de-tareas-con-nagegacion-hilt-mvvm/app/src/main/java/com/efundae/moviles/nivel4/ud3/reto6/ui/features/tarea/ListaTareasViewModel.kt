package com.efundae.moviles.nivel4.ud3.reto6.ui.features.tarea

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.efundae.moviles.nivel4.ud3.reto6.models.TareaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@SuppressLint("MutableCollectionMutableState")
@HiltViewModel
class ListaTareasViewModel @Inject constructor(
    private val repository: TareaRepository
) : ViewModel() {

    var listaTareasState by mutableStateOf(cargarTareas())
    var tareaSeleccionada: TareaUiState? by mutableStateOf(TareaUiState())
    private fun cargarTareas() = repository.get().map { it.toTareaUiState() }.toMutableList()
    fun onTareaEvent(tareaEvent: TareaEvent) {
        when (tareaEvent) {
            is TareaEvent.onGetTarea -> {
                tareaSeleccionada = repository.get(tareaEvent.id)?.toTareaUiState()
            }
            is TareaEvent.onInsertTarea -> {
                repository.insert(tareaEvent.tareaUiState.toTarea())
                cargarTareas()
            }
            is TareaEvent.onUpdate -> {
                repository.update(tareaEvent.tareaUiState.toTarea())
                cargarTareas()
            }
            is TareaEvent.onDeleteTarea -> {
                repository.delete(tareaEvent.tareaUiState.toTarea())
                cargarTareas()
            }
        }
    }
}