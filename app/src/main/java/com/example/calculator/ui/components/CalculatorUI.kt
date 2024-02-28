package com.example.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.BackgroundColor
import com.example.calculator.ui.viewmodels.CalculatorViewModel


@Composable
fun CalculatorUI(
    calculatorViewModel: CalculatorViewModel = viewModel()
) {
    val backgroundColor = BackgroundColor
    val calculatorUiState by calculatorViewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                CalculatorDisplay(
                    calculatorUiState.currentText,
                    color =  Color.Black,
                )
            }
            Divider(
                color = Color.LightGray,
                thickness = 1.dp
            )
            CalculatorKeyboard(
                viewModel = calculatorViewModel
            )
        }
    }
}

@Preview
@Composable
fun CalculatorUIPreview() {
    CalculatorUI()
}
