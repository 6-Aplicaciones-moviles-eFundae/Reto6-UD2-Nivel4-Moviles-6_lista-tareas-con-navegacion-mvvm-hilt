package com.efundae.moviles.nivel4.ud3.reto6.models.mocks

import javax.inject.Inject

class TareaDaoMock @Inject constructor() {
    private var listaTareas = mutableListOf<TareaMock>()
    fun get() = listaTareas
    fun get(id: Int) = listaTareas.find { it.id == id }
    fun insert(tareaMock: TareaMock) = listaTareas.add(tareaMock)
    fun delete(tareaMock: TareaMock?) = listaTareas.remove(tareaMock)
    fun update(tareaMock: TareaMock) {
        val oldTarea = listaTareas.find { it.id == tareaMock.id }
        delete(oldTarea)
        insert(tareaMock)
    }
}