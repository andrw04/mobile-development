package com.example.calculator.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.viewmodels.CalculatorAction
import com.example.calculator.viewmodels.CalculatorViewModel

@Composable
fun Keyboard(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel(),
    buttonSpacing: Dp = 2.dp
) {

    val orientation = LocalConfiguration.current.orientation
    val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        if (isLandscape) {
            ExpandedKeyboard()
        }
        else {
            MinimalKeyboard()
        }
    }
}

@Composable
fun ExpandedKeyboard(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 2.dp,
    viewModel: CalculatorViewModel = viewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "x!",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("!")) },
                modifier = Modifier.weight(2f)
            )
            KeyboardButton(
                text = "1/x",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("^(-1)")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "C",
                onClick = { viewModel.onAction(CalculatorAction.Clear) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "del",
                onClick = { viewModel.onAction(CalculatorAction.Delete) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "%",
                onClick = {
                    viewModel.onAction(CalculatorAction.Symbol("÷100"))
                    viewModel.onAction(CalculatorAction.Calculate)
                          },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "÷",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("÷")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "xⁿ",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("^")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "√x",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("√")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "(",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "7",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("7")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "8",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("8")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "9",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("9")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "×",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("×")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "lg",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("lg(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "ln",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("ln(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = ")",
                onClick = { viewModel.onAction(CalculatorAction.Symbol(")")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "4",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("4")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "5",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("5")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "6",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("6")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "-",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("-")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "sin",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("sin(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "cos",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("cos(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "π",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("π")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "1",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("1")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "2",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("2")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "3",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("3")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "+",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("+")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "tan",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("tan(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "ctg",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("ctg(")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "e",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("e")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = ".",
                onClick = { viewModel.onAction(CalculatorAction.Symbol(".")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "0",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("0")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "=",
                onClick = { viewModel.onAction(CalculatorAction.Calculate) },
                modifier = Modifier.weight(2f)
            )
        }
    }
}


@Composable
fun MinimalKeyboard(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 2.dp,
    viewModel: CalculatorViewModel = viewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "C",
                onClick = { viewModel.onAction(CalculatorAction.Clear) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "del",
                onClick = { viewModel.onAction(CalculatorAction.Delete) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "%",
                onClick = {
                    viewModel.onAction(CalculatorAction.Symbol("÷100"))
                    viewModel.onAction(CalculatorAction.Calculate)
                          },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "÷",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("÷")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "7",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("7")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "8",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("8")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "9",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("9")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "×",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("×")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "4",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("4")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "5",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("5")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "6",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("6")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "-",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("-")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = "1",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("1")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "2",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("2")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "3",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("3")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "+",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("+")) },
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            KeyboardButton(
                text = ".",
                onClick = { viewModel.onAction(CalculatorAction.Symbol(".")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "0",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("0")) },
                modifier = Modifier.weight(1f)
            )
            KeyboardButton(
                text = "=",
                onClick = { viewModel.onAction(CalculatorAction.Calculate) },
                modifier = Modifier.weight(2f)
            )
        }
    }
}


@Preview
@Composable
fun KeyboardPreview() {
    Keyboard()
}