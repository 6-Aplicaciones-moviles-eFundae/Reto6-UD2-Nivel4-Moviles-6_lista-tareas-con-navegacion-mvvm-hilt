package com.efundae.moviles.nivel4.ud3.reto6.models.mocks

import java.time.LocalDate
import javax.inject.Inject

class TareaDaoMock @Inject constructor() {
    private var listaTareas = mutableListOf(
        TareaMock(
            id = 1,
            titulo = "Curso Android",
            descripcion = "Descripción de Curso Android",
            fecha = LocalDate.now().minusDays(8),
            completada = true
        ),
        TareaMock(
            id = 2,
            titulo = "Curso SQL",
            descripcion = "Descripción de Curso SQL",
            fecha = LocalDate.now().minusDays(5),
            completada = true
        ),
        TareaMock(
            id = 3,
            titulo = "Curso Kotlin",
            descripcion = "Descripción de Curso Kotlin",
            fecha = LocalDate.now().minusDays(3),
            completada = false
        )
    )

    fun get() = listaTareas
    fun get(id: Int) = listaTareas.find { it.id == id }
    fun insert(tareaMock: TareaMock) = listaTareas.add(tareaMock)
    fun delete() = listaTareas.clear()
}