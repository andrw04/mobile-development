package com.example.calculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.calculator.ui.states.CalculatorUiState
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
            var removeLength = 1

            val isTrigonometry = currentText.endsWith("sin(") ||
                    currentText.endsWith("cos(") ||
                    currentText.endsWith("tan(") ||
                    currentText.endsWith("ctg(")
            if (isTrigonometry) {
                removeLength = 4
            }

            val isLog = currentText.endsWith("lg(") ||
                    currentText.endsWith("ln(")
            if (isLog) {
                removeLength = 3
            }

            val nextText = currentText.substring(0, currentText.length - removeLength)

            if (nextText.isEmpty()) {
                _uiState.value = CalculatorUiState()
            }
            else {
                _uiState.value = _uiState.value.copy(currentText = nextText)
            }
        }
    }

    private fun calculate() {
        val expression : String = _uiState.value.currentText
        val tokens : List<String> = getTokens(expression)
        val outputQueue = mutableListOf<String>()
        val operatorStack = Stack<String>()

        try {
            for (token in tokens) {
                if (isNumeric(token)) {
                    outputQueue.add(token)
                }
                else if (isFunction(token)) {
                    operatorStack.push(token)
                }
                else if (isOperator(token)) {
                    while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                        getPrecedence(token) <= getPrecedence(operatorStack.peek())) {
                        outputQueue.add(operatorStack.pop())
                    }
                    operatorStack.push(token)
                }
                else if (token == "(") {
                    operatorStack.push(token)
                }
                else if (token == ")") {
                    while (operatorStack.peek() != "(") {
                        outputQueue.add(operatorStack.pop())
                    }
                    operatorStack.pop()
                    if (!operatorStack.isEmpty() && isFunction(operatorStack.peek())) {
                        outputQueue.add(operatorStack.pop())
                    }
                }
            }

            while (!operatorStack.isEmpty()) {
                outputQueue.add(operatorStack.pop())
            }

            val stack = Stack<Double>()
            for (token in outputQueue) {
                if (isNumeric(token)) {
                    stack.push(token.toDouble())
                }
                else if (isFunction(token)) {
                    val arg = stack.pop()
                    val result = when (token) {
                        "sin" -> sin(arg)
                        "cos" -> cos(arg)
                        "tan" -> tan(arg)
                        "ctg" -> 0.0 // todo
                        "ln" -> ln(arg)
                        "lg" -> log10(arg)
                        else -> throw IllegalArgumentException("Unknown function: $token")
                    }
                    stack.push(result)
                }
                else if (isOperator(token)) {
                    val operand2 = stack.pop()
                    val operand1 = stack.pop()
                    val result = when (token) {
                        "+" -> operand1 + operand2
                        "-" -> operand1 + operand2
                        "×" -> operand1 * operand2
                        "÷" -> operand1 / operand2
                        else -> throw IllegalArgumentException("Unknown operator: $token")
                    }
                    stack.push(result)
                }
            }

            _uiState.value = CalculatorUiState(formatOutput(stack.pop()))
        }
        catch (ex : Exception){
            _uiState.value = CalculatorUiState("Error")
        }
    }

    private fun formatOutput(number: Double) : String {
        return number.toString().removeSuffix(".0")
    }

    private fun getTokens(expr : String) : List<String> {
        var current = 0
        val tokens = mutableListOf<String>()

        while (!isAtEnd(expr, current)) {
            if (isOperatorOrBracket(expr[current])) {
                tokens.add(expr[current++].toString())
            }
            else if (expr[current].isLetter()) {
                var function = ""

                while (!isAtEnd(expr, current) && expr[current].isLetter()) {
                    function += expr[current++]
                }

                tokens.add(function)
            }
            else {
                var number = ""

                while (!isAtEnd(expr, current) && (expr[current].isDigit() || expr[current] == '.')) {
                    number += expr[current++]
                }

                tokens.add(number)
            }
        }

        return tokens
    }

    private fun isAtEnd(expr: String, current: Int) : Boolean {
        return current >= expr.length
    }

    private fun isOperatorOrBracket(symbol: Char) : Boolean {
        return when (symbol) {
            '(', ')', '+', '-', '×', '÷', '^', '!' -> true
            else -> false
        }
    }

    private fun isNumeric(token: String) : Boolean {
        return token.toDoubleOrNull() != null
    }

    private fun isOperator(token: String) : Boolean {
        return token in listOf("+", "-", "×", "÷")
    }

    private fun isFunction(token: String): Boolean {
        return token in listOf("sin", "cos", "tan", "ctg", "lg", "ln")
    }

    private fun getPrecedence(token: String): Int {
        return when (token) {
            "+", "-" -> 1
            "×", "÷" -> 2
            "^" -> 3
            "!" -> 4
            else -> 0
        }
    }
}