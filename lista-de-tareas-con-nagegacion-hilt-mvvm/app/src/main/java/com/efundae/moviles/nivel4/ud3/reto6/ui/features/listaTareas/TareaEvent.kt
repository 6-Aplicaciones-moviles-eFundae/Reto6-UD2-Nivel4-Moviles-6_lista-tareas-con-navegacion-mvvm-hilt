package com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas

sealed interface TareaEvent {
    data class onGetTarea(val id: Int) : TareaEvent
    data class onInsertTarea(val tareaUiState: TareaUiState) : TareaEvent
    data class onUpdate(val tareaUiState: TareaUiState) : TareaEvent
    data class onDeleteTarea(val tareaUiState: TareaUiState) : TareaEvent
}