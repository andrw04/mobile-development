package com.example.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R
import com.example.calculator.states.AppTheme

@Composable
fun Display(
    text: String,
    modifier : Modifier = Modifier,
    appTheme: AppTheme = AppTheme(),
    backgroundColor: Color = Color.Transparent,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = text,
            textAlign = TextAlign.End,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 50.sp,
                color = appTheme.displayTextColor,
                fontFamily =  FontFamily.SansSerif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .verticalScroll(rememberScrollState())
        )
    }
}