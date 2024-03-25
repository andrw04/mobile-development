package com.example.calculator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.AdditionalOperationButtonBackgroundColor
import com.example.calculator.ui.theme.MainOperationButtonBackgroundColor
import com.example.calculator.ui.theme.NumberButtonBackgroundColor
import com.example.calculator.viewmodels.CalculatorAction
import com.example.calculator.viewmodels.CalculatorViewModel

@Composable
fun CompactKeyboard(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
    val buttonSpacing = 8.dp

    Column (
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
                text = "C",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { viewModel.onAction(CalculatorAction.Clear) }
            )
            CalculatorButton(
                text = "del",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { viewModel.onAction(CalculatorAction.Delete) }
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
                onClick = { viewModel.onAction(CalculatorAction.Symbol("÷")) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "7",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("7")) }
            )
            CalculatorButton(
                text = "8",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("8")) }
            )
            CalculatorButton(
                text = "9",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("9")) }
            )
            CalculatorButton(
                text = "×",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("×")) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "4",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("4")) }
            )
            CalculatorButton(
                text = "5",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("5")) }
            )
            CalculatorButton(
                text = "6",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("6")) }
            )
            CalculatorButton(
                text = "-",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("-")) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = "1",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("1")) }
            )
            CalculatorButton(
                text = "2",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("2")) }
            )
            CalculatorButton(
                text = "3",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("3")) }
            )
            CalculatorButton(
                text = "+",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = MainOperationButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("+")) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculatorButton(
                text = ".",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol(".")) }
            )
            CalculatorButton(
                text = "0",
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                color = NumberButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Symbol("0")) }
            )
            CalculatorButton(
                text = "=",
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                color = MainOperationButtonBackgroundColor,
                onClick = { viewModel.onAction(CalculatorAction.Calculate) }
            )
        }
    }
}

@Preview
@Composable
fun CompactKeyboardPreview() {
    CompactKeyboard()
}