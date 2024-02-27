package com.example.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.AdditionalOperationButtonBackgroundColor
import com.example.calculator.ui.theme.NumberButtonBackgroundColor
import com.example.calculator.ui.theme.MainOperationButtonBackgroundColor

@Composable
fun CalculatorKeyboard(
    modifier: Modifier = Modifier,
    onKeyPressed: (String) -> Unit
) {
    val buttonSpacing = 8.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "deg",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = "sin",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "cos",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "tan",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "ctg",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "x^y",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = "lg",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "ln",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "(",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = ")",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = {}
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "√x",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = "C",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {}
            )
            CalculatorButton(
                text = "del",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {}
            )
            CalculatorButton(
                text = "%",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {}
            )
            CalculatorButton(
                text = "÷",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = {}
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "x!",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = "7",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "8",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "9",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "×",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = {}
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "1/x",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = "4",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "5",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "6",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "-",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = {}
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "π",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = "1",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "2",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "3",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "+",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = {}
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "e",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = AdditionalOperationButtonBackgroundColor,
                onClick = { /*TODO*/ }
            )
            CalculatorButton(
                text = ".",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "0",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = {}
            )
            CalculatorButton(
                text = "=",
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                color = MainOperationButtonBackgroundColor,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun CalculatorKeyboardPreview() {
    CalculatorKeyboard(onKeyPressed = { })
}