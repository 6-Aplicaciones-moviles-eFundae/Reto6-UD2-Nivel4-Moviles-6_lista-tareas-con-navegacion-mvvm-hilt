package com.efundae.moviles.nivel4.ud3.reto6.ui.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Espacio(n: Int) {
    Spacer(Modifier.size(n.dp))
}