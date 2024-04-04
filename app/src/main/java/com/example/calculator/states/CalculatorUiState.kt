package com.example.calculator.states

data class CalculatorUiState(
    var currentText: String = "0",
    var isOperator: Boolean = false
)