package com.example.calculator.domain.viewmodels

import com.example.calculator.domain.states.AppTheme

sealed class CalculatorAction {
    data class Symbol(val symbol: String) : CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
    data class SetTheme(val theme: AppTheme) : CalculatorAction()
}