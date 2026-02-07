package com.efundae.moviles.nivel4.ud3.reto6.models

import com.efundae.moviles.nivel4.ud3.reto6.data.Tarea
import com.efundae.moviles.nivel4.ud3.reto6.models.mocks.TareaDaoMock
import javax.inject.Inject

class TareaRepository @Inject constructor(
    private var dao: TareaDaoMock
) {
    fun get() = dao.get().map { it.toTarea() }.toMutableList()
    fun get(id: Int) = dao.get(id)?.toTarea()
    fun insert(tarea: Tarea) = dao.insert(tareaMock = tarea.toTareaMock())
    fun delete() = dao.delete()
}