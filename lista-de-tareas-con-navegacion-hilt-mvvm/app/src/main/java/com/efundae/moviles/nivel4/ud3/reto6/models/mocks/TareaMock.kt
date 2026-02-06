package com.efundae.moviles.nivel4.ud3.reto6.models.mocks

import java.time.LocalDate

data class TareaMock(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val fecha: LocalDate,
    val completada : Boolean
)
