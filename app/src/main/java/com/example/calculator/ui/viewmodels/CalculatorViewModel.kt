package com.example.calculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.calculator.ui.states.CalculatorUiState
import com.example.calculator.ui.viewmodels.utilities.ExpressionCalculator
import com.example.calculator.ui.viewmodels.utilities.MathTokenizer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.IllegalArgumentException
import java.util.Stack
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.sin
import kotlin.math.tan

class CalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Symbol -> enterSymbol(action.symbol)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> _uiState.value = CalculatorUiState()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterSymbol(symbol: String) {
        val currentText = _uiState.value.currentText
        var newText = ""
        var replaceOldText = true

        if (currentText != "0")
            replaceOldText = false

        when (symbol) {
            "π", "e" -> newText += getConstantValue(symbol)
            "!", "^", "^(-1)", "+", "×", "÷", "." -> {
                newText += symbol
                replaceOldText = false
            }
            else -> newText += symbol
        }

        if (replaceOldText) {
            _uiState.value = CalculatorUiState(newText)
        }
        else {
            _uiState.value = _uiState.value.copy(currentText = currentText + newText)
        }
    }

    private fun getConstantValue(symbol: String) : String {
        return when (symbol) {
            "π" -> Math.PI.toString()
            "e" -> Math.E.toString()
            else -> ""
        }
    }

    private fun delete() {
        val currentText = _uiState.value.currentText
        if (currentText.isNotEmpty()) {
            val removeLength = calculateRemoveLength(currentText)

            val nextText = currentText.substring(0, currentText.length - removeLength)
            if (nextText.isEmpty()) {
                _uiState.value = CalculatorUiState()
            }
            else {
                _uiState.value = _uiState.value.copy(currentText = nextText)
            }
        }
    }

    private fun calculateRemoveLength(text : String) : Int {
        if (text.endsWith("lg(") || text.endsWith("ln(")) {
            return 3
        }

        val functions = listOf<String>("sin(", "cos(", "tan(", "ctg(")
        functions.forEach { func ->
            text.endsWith(func)
        }

        return 1
    }

    private fun calculate() {
        val expression : String = _uiState.value.currentText

        try {
            val result = ExpressionCalculator.calculate(expression)
            _uiState.value = CalculatorUiState(formatOutput(result))
        }
        catch (ex : Exception){
            _uiState.value = CalculatorUiState("Error")
        }
    }

    private fun formatOutput(number: Double) : String {
        return number.toString().removeSuffix(".0")
    }
}