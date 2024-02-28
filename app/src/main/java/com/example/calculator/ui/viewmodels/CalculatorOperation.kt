package com.example.calculator.ui.viewmodels

sealed class CalculatorOperation(val op: String) {
    object Add: CalculatorOperation("+")
    object Substract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("×")
    object Divide: CalculatorOperation("÷")
}