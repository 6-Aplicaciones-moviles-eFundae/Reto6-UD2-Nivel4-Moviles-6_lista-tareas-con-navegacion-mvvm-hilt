package com.efundae.moviles.nivel4.ud3.reto6.ui.features.tarea

import com.efundae.moviles.nivel4.ud3.reto6.data.Tarea
import java.time.LocalDate


data class TareaUiState(
    val id: Int = 0,
    val titulo: String = "",
    val descripcion: String = "",
    val fecha: LocalDate = LocalDate.now(),
    val completada: Boolean = false
)

fun TareaUiState.toTarea() = Tarea(
    id = this.id,
    titulo = this.titulo,
    descripcion = this.descripcion,
    fecha = this.fecha,
    completada = this.completada
)

fun Tarea.toTareaUiState() = TareaUiState(
    id = this.id,
    titulo = this.titulo,
    descripcion = this.descripcion,
    fecha = this.fecha,
    completada = this.completada
)