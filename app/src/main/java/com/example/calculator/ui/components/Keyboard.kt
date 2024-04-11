package com.example.calculator.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.domain.CalculatorAction
import com.example.calculator.domain.CalculatorViewModel
import kotlin.math.absoluteValue

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
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    if (dragAmount.x.absoluteValue > dragAmount.y.absoluteValue) {
                        if (dragAmount.x > 0) { // right
                            viewModel.onAction(CalculatorAction.Symbol("÷"))
                        } else { // left
                            viewModel.onAction(CalculatorAction.Symbol("×"))
                        }
                    } else {
                        if (dragAmount.y > 0) { // down
                            viewModel.onAction(CalculatorAction.Symbol("-"))
                        } else { // up
                            viewModel.onAction(CalculatorAction.Symbol("+"))
                        }
                    }
                }
            }
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
    val numberButtonColor : Color = Color(0xFF_FF_FF_FF)
    val operationButtonColor : Color = Color(0xFF_4B_5E_FC)
    val functionButtonColor : Color = Color(0xFF_D2_D3_DA)

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
            Button(
                text = "x!",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("!")) },
                modifier = Modifier.weight(3f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "C",
                onClick = { viewModel.onAction(CalculatorAction.Clear) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "del",
                onClick = { viewModel.onAction(CalculatorAction.Delete) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "%",
                onClick = {
                    viewModel.onAction(CalculatorAction.Symbol("÷"))
                    viewModel.onAction(CalculatorAction.Symbol("100"))
                    viewModel.onAction(CalculatorAction.Calculate)
                          },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "÷",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("÷")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "xⁿ",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("^")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "√x",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("√")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "(",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "7",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("7")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "8",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("8")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "9",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("9")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "×",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("×")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "lg",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("lg(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "ln",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("ln(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = ")",
                onClick = { viewModel.onAction(CalculatorAction.Symbol(")")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "4",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("4")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "5",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("5")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "6",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("6")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "-",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("-")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "sin",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("sin(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "cos",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("cos(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "π",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("π")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "1",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("1")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "2",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("2")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "3",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("3")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "+",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("+")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "tan",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("tan(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "ctg",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("ctg(")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = "e",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("e")) },
                modifier = Modifier.weight(1f),
                backgroundColor = functionButtonColor
            )
            Button(
                text = ".",
                onClick = { viewModel.onAction(CalculatorAction.Symbol(".")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "0",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("0")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "=",
                onClick = { viewModel.onAction(CalculatorAction.Calculate) },
                modifier = Modifier.weight(2f),
                backgroundColor = operationButtonColor
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
    val numberButtonColor : Color = Color(0xFF_FF_FF_FF)
    val operationButtonColor : Color = Color(0xFF_4B_5E_FC)
    val functionButtonColor : Color = Color(0xFF_D2_D3_DA)

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
            Button(
                text = "C",
                onClick = { viewModel.onAction(CalculatorAction.Clear) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "del",
                onClick = { viewModel.onAction(CalculatorAction.Delete) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "%",
                onClick = {
                    viewModel.onAction(CalculatorAction.Symbol("÷"))
                    viewModel.onAction(CalculatorAction.Symbol("100"))
                    viewModel.onAction(CalculatorAction.Calculate)
                          },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "÷",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("÷")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "7",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("7")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "8",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("8")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "9",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("9")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "×",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("×")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "4",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("4")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "5",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("5")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "6",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("6")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "-",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("-")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = "1",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("1")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "2",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("2")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "3",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("3")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "+",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("+")) },
                modifier = Modifier.weight(1f),
                backgroundColor = operationButtonColor
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Button(
                text = ".",
                onClick = { viewModel.onAction(CalculatorAction.Symbol(".")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "0",
                onClick = { viewModel.onAction(CalculatorAction.Symbol("0")) },
                modifier = Modifier.weight(1f),
                backgroundColor = numberButtonColor
            )
            Button(
                text = "=",
                onClick = { viewModel.onAction(CalculatorAction.Calculate) },
                modifier = Modifier.weight(2f),
                backgroundColor = operationButtonColor
            )
        }
    }
}


@Preview
@Composable
fun KeyboardPreview() {
    Keyboard()
}