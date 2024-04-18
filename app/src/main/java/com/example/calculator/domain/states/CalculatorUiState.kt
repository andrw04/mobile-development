package com.example.calculator.domain.states

import androidx.compose.ui.graphics.Color

data class CalculatorUiState(
    var currentText: String = "0",
    var isOperator: Boolean = false,
    var appTheme: AppTheme = AppTheme(),
)

data class AppTheme(
    val themeName: String = "Base",
    val backgroundColor: Color = Color(0xFF_F1_F2_F3),
    val displayTextColor: Color = Color(0xFF_00_00_00),

    val numberButtonColor : Color = Color(0xFF_FF_FF_FF),
    val operationButtonColor : Color = Color(0xFF_4B_5E_FC),
    val functionButtonColor : Color = Color(0xFF_D2_D3_DA),

    val numberButtonTextColor: Color = Color(0xFF_00_00_00),
    val operationButtonTextColor: Color = Color(0xFF_00_00_00),
    val functionButtonTextColor: Color = Color(0xFF_00_00_00),
)