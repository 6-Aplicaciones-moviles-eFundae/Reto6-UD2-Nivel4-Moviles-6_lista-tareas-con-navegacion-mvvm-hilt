package com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas

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
    var listaTareasState by mutableStateOf(value = cargarTareas())
    var tareaSeleccionada: TareaUiState by mutableStateOf(TareaUiState())
    private fun cargarTareas() = repository.get().map { it.toTareaUiState() }.toMutableList()
    fun onTareaEvent(tareaEvent: TareaEvent) {
        when (tareaEvent) {
            is TareaEvent.OnSetTareaSeleccionada -> {
                repository.get(tareaEvent.id)?.let { tareaSeleccionada = it.toTareaUiState() }
            }
            is TareaEvent.OnGetTarea -> {
                repository.get(tareaEvent.id)?.let { tareaSeleccionada = it.toTareaUiState() }
            }
            is TareaEvent.OnInsertTarea -> {
                repository.insert(tareaEvent.tareaUiState.toTarea())
                listaTareasState = cargarTareas()
            }
            is TareaEvent.OnDeleteTareas -> {
                repository.delete()
                listaTareasState = cargarTareas()
            }
        }
    }

    fun getTarea(id: Int): TareaUiState? {
        return repository.get(id)?.toTareaUiState()
    }
}