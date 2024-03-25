package com.example.calculator.viewmodels.utilities

import java.util.Stack
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

class ExpressionCalculator {
    companion object {
        fun calculate(expr: String) : Double {
            val mathTokenizer = MathTokenizer(expr)
            val tokens = mathTokenizer.scanTokens()

            try {
                val tokenQueue = getTokenQueue(tokens)
                return evaluateTokens(tokenQueue)
            }
            catch (ex : Exception) {
                throw ex
            }
        }

        private fun getTokenQueue(tokens: List<String>) : List<String> {
            val output = mutableListOf<String>()
            val operators = Stack<String>()

            for (token in tokens) {
                when (token) {
                    in listOf("+", "-", "×", "÷", "^", "!", "√", "sin", "cos", "tan", "ctg", "lg", "ln") -> {
                        while (operators.isNotEmpty() && getPrecedence(operators.peek()) >= getPrecedence(token)) {
                            output.add(operators.pop())
                        }
                        operators.push(token)
                    }
                    "(" -> {
                        operators.push(token)
                    }
                    ")" -> {
                        while (operators.peek() != "(") {
                            output.add(operators.pop())
                        }
                        operators.pop()
                    }
                    else -> {
                        output.add(token)
                    }
                }
            }

            while (operators.isNotEmpty()) {
                output.add(operators.pop())
            }

            return output
        }

        private fun evaluateTokens(tokens: List<String>) : Double {
            val stack = Stack<Double>()

            for (token in tokens) {
                when (token) {
                    in listOf("+", "-", "×", "÷", "^") -> {
                        val b = stack.pop()
                        val a = if (stack.isEmpty()) {
                            0.0
                        } else {
                            stack.pop()
                        }
                        val result = when (token) {
                            "+" -> a + b
                            "-" -> a - b
                            "×" -> a * b
                            "÷" -> a / b
                            "^" -> a.pow(b)
                            else -> throw IllegalArgumentException("Unknown operator: $token")
                        }
                        stack.push(result)
                    }
                    in listOf("sin", "cos", "tan", "ctg", "lg", "ln") -> {
                        val a = stack.pop()
                        val result = applyFunction(a, token)
                        stack.push(result)
                    }
                    "√" -> {
                        val a = stack.pop()
                        stack.push(sqrt(a))
                    }
                    "!" -> {
                        val a = stack.pop()
                        var result = 1.0
                        for (i in 1..a.toInt()) {
                            result *= i
                        }
                        stack.push(result)
                    }
                    else -> stack.push(token.toDouble())
                }
            }

            return stack.pop()
        }

        private fun applyFunction(value: Double, func: String) : Double {
            return when (func) {
                "sin" -> sin(value)
                "cos" -> cos(value)
                "tan" -> tan(value)
                "ctg" -> 1.0 / tan(value)
                "lg" -> log10(value)
                "ln" -> ln(value)
                else -> throw IllegalArgumentException("Unknown operation: $func")
            }
        }

        private fun getPrecedence(token: String): Int {
            return when (token) {
                "+", "-" -> 1
                "×", "÷" -> 2
                "^" -> 3
                "!", "√", "sin", "cos", "tan", "ctg", "lg", "ln" -> 4
                else -> 0
            }
        }
    }
}