package com.efundae.moviles.nivel4.ud3.reto6.ui.features.listaTareas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.efundae.moviles.nivel4.ud3.reto6.ui.composables.BotonFlotante
import com.efundae.moviles.nivel4.ud3.reto6.ui.composables.Espacio

@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListaTareasScreen(
    listaTareasVm: MutableList<TareaUiState> = mutableListOf(),
    onTareaEvent: (TareaEvent) -> Unit = {},
    tareaSeleccionada: TareaUiState? = null,
    onIrADetallesTarea: (Int) -> Unit = {}
) {
    var tareaTextField by rememberSaveable { mutableStateOf(value = "") }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { BotonFlotante(onTareaEvent) },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(paddingValues = innerPadding)
        ) {
            Text(text = "Lista dinámica", fontSize = 35.sp, fontWeight = FontWeight.Bold)
            Espacio(n = 10)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = tareaTextField,
                    onValueChange = { tareaTextField = it },
                    label = { Text(text = "Nueva tarea") },
                    placeholder = { Text(text = "Ej: Curso de SQL") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Nueva tarea"
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
                Button(
                    onClick = {
                        onTareaEvent(
                            TareaEvent.OnInsertTarea(
                                TareaUiState(
                                    id = listaTareasVm.count() + 1,
                                    titulo = tareaTextField,
                                    descripcion = "Descripción de $tareaTextField"
                                )
                            )
                        )
                        tareaTextField = ""
                    },
                    enabled = tareaTextField.isNotEmpty(),
                    content = { Text(text = "Añadir") }
                )
            }
            if (listaTareasVm.isNotEmpty()) {
                Espacio(n = 10)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.secondary)
                        .padding(all = 2.dp)
                ) {
                    items(items = listaTareasVm) { elemento ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 3.dp)
                                .combinedClickable(
                                    onClick = { onTareaEvent(TareaEvent.OnSetTareaSeleccionada(elemento.id)) },
                                    onLongClick = {
                                        onTareaEvent(TareaEvent.OnSetTareaSeleccionada(elemento.id))
                                        onIrADetallesTarea(elemento.id)
                                    }
                                )
                                .animateItem()
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = MaterialTheme.colorScheme.onSecondary)
                                    .padding(all = 4.dp),
                                text = elemento.titulo,
                                fontSize = 25.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
            Espacio(n = 15)
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (tareaSeleccionada != null && tareaSeleccionada.id != 0 && listaTareasVm.isNotEmpty()) {
                    Text(
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.large)
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(15.dp),
                        text = "Tarea seleccionada: ${tareaSeleccionada.titulo}",
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}