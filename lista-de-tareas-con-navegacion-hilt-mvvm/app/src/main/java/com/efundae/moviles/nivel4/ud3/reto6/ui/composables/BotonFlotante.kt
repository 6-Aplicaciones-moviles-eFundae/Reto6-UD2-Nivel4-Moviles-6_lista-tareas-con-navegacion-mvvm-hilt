package com.efundae.moviles.nivel4.ud3.reto6.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas.TareaEvent

@Composable
fun BotonFlotante(
    onTareaEvent: (TareaEvent) -> Unit
) {
    FloatingActionButton(
        modifier = Modifier
            .size(size = 80.dp)
            .shadow(elevation = 10.dp),
        onClick = { onTareaEvent(TareaEvent.OnDeleteTareas)},
        shape = MaterialTheme.shapes.large,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(
            modifier = Modifier.size(size =  35.dp),
            imageVector = Icons.Default.Delete,
            contentDescription = "Borrar"
        )
    }
}