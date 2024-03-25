package com.example.calculator.viewmodels

sealed class CalculatorAction {
    data class Symbol(val symbol: String) : CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
}