package com.efundae.moviles.nivel4.ud3.reto6.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun estiloLineaDetallesTarea(campo : String, valor : String = ""): AnnotatedString {
    return buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.SemiBold
            ),
            block = {
                append(campo)
            }
        )
        withStyle(
            style = SpanStyle(
                fontStyle = FontStyle.Italic
            ),
            block = {
                append(valor)
            }
        )
    }
}