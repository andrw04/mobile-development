package com.example.calculator.states

data class CalculatorUiState(
    val currentText: String = "0",
    var isOperator: Boolean = false
)