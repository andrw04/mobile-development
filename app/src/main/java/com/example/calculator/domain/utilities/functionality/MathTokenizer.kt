package com.example.calculator.domain.utilities.functionality

class MathTokenizer(val expr: String) {
    private var tokens = mutableListOf<String>()
    private var start: Int = 0
    private var current: Int = 0

    fun scanTokens() : List<String> {
        while (!isAtEnd()) {
            scanToken()
            start = current
        }

        return tokens
    }

    private fun scanToken() {
        val c = advance()

        if (c.isDigit()) { // number
            number()
        }
        else if (c in listOf('+', '-', '×', '÷', '^', '√', '!', '(', ')')) { // single character operator
            tokens.add(c.toString());
        }
        else { // other functions
            function()
        }
    }

    private fun isAlpha(symbol: Char?) : Boolean {
        return symbol != null && symbol.isLetter()
    }

    private fun isDigit(symbol: Char?) : Boolean {
        return symbol != null && symbol.isDigit()
    }

    private fun function() {
        while (isAlpha(peek())) {
            advance()
        }

        tokens.add(expr.substring(start, current))
    }

    private fun number() {
        while (isDigit(peek())) {
            advance()
        }

        if (peek() == '.' && isDigit(peekNext())) {
            advance()

            while (isDigit(peek())) {
                advance()
            }

            if (peek() == 'E') {
                advance() // E
                advance() // + or -

                while (isDigit(peek())) {
                    advance()
                }
            }
        }

        tokens.add(expr.substring(start, current));
    }

    private fun isAtEnd() : Boolean {
        return current >= expr.length
    }

    private fun peek() : Char? {
        if (isAtEnd()) {
            return null
        }

        return expr[current]
    }

    private fun peekNext() : Char? {
        if (current + 1 >= expr.length) {
            return null
        }

        return expr[current + 1]
    }

    private fun advance() : Char {
        return expr[current++]
    }
}