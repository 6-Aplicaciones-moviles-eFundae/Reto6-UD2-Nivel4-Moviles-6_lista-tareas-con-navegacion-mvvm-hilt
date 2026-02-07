package com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas

sealed interface TareaEvent {
    data class OnSetTareaSeleccionada(val id: Int) : TareaEvent
    data class OnInsertTarea(val tareaUiState: TareaUiState) : TareaEvent
    data object OnDeleteTareas : TareaEvent
}