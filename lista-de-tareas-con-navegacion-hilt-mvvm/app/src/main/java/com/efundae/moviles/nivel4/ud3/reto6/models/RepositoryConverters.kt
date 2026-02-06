package com.efundae.moviles.nivel4.ud3.reto6.models

import com.efundae.moviles.nivel4.ud3.reto6.data.Tarea
import com.efundae.moviles.nivel4.ud3.reto6.models.mocks.TareaMock

fun Tarea.toTareaMock() = TareaMock(
    id = this.id,
    titulo = this.titulo,
    descripcion = this.descripcion,
    fecha = this.fecha,
    completada = this.completada
)

fun TareaMock.toTarea() = Tarea(
    id = this.id,
    titulo = this.titulo,
    descripcion = this.descripcion,
    fecha = this.fecha,
    completada = this.completada
)