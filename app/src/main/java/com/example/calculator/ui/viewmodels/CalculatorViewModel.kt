package com.example.calculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.calculator.ui.states.CalculatorUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculatorUiState())
    val uiState: StateFlow<CalculatorUiState> = _uiState.asStateFlow()

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Clear -> _uiState.value = CalculatorUiState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: Int) {
        if (_uiState.value.currentText == "0") {
            _uiState.value = CalculatorUiState("$number")
        }
        else {
            _uiState.value = _uiState.value.copy(
                currentText = _uiState.value.currentText + number
            )
        }
    }

    private fun delete() {
        val currentText = _uiState.value.currentText
        if (currentText.isNotEmpty()) {
            if (currentText.length == 1) {
                _uiState.value = CalculatorUiState("0")
            }
            else {
                val nextText = currentText.substring(0, currentText.length - 1)
                _uiState.value = _uiState.value.copy(currentText = nextText)
            }
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {

    }

    private fun enterDecimal() {

    }

    private fun calculate() {

    }
}