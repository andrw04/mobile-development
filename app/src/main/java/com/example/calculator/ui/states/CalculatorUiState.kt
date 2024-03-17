package com.example.calculator.ui.states

data class CalculatorUiState(
    val currentText: String = "0",
    val deg: Boolean = true,
    val isNumber: Boolean = true,
    val isFunction: Boolean = false,
    val isOperation: Boolean = false,
    val isOpenBracket: Boolean = false,
    val isCloseBracket: Boolean = false
)