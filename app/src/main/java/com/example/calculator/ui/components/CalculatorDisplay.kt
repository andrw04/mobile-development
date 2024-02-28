package com.example.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorDisplay(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Text(
        text = text,
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
            .verticalScroll(rememberScrollState()),
        style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 50.sp,
            color = color,
            fontFamily = FontFamily.Monospace,
        ),
//        maxLines = 3
    )
}