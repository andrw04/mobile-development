package com.example.calculator.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.RememberWindowInfo
import com.example.calculator.ui.WindowInfo
import com.example.calculator.ui.components.CalculatorDisplay
import com.example.calculator.ui.components.CalculatorKeyboard
import com.example.calculator.ui.components.CompactKeyboard
import com.example.calculator.ui.components.ExpandedKeyboard
import com.example.calculator.ui.theme.BackgroundColor
import com.example.calculator.viewmodels.CalculatorViewModel

@Composable
fun CalculatorUI(
    calculatorViewModel: CalculatorViewModel = viewModel()
) {
    val windowInfo = RememberWindowInfo()
    val backgroundColor = BackgroundColor
    val calculatorUiState by calculatorViewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorDisplay(
                calculatorUiState.currentText,
                color =  Color.Black,
            )

            if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
                CompactKeyboard(
                    viewModel = calculatorViewModel
                )
            }
            else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Medium) {
                ExpandedKeyboard(
                    viewModel = calculatorViewModel
                )
            }
            else {
                ExpandedKeyboard(
                    viewModel = calculatorViewModel
                )
            }
        }
    }
}

//@Composable
//fun CalculatorUI(
//    calculatorViewModel: CalculatorViewModel = viewModel()
//) {
//    val windowInfo = RememberWindowInfo()
//    val backgroundColor = BackgroundColor
//    val calculatorUiState by calculatorViewModel.uiState.collectAsState()
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = backgroundColor),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Bottom,
//            modifier = Modifier
//                .fillMaxHeight()
//        ) {
//            Box(
//                modifier = Modifier
//                    .weight(1f),
//                contentAlignment = Alignment.BottomCenter
//            ) {
//                CalculatorDisplay(
//                    calculatorUiState.currentText,
//                    color =  Color.Black,
//                )
//            }
//            Divider(
//                color = Color.LightGray,
//                thickness = 1.dp
//            )
//            if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
//                CompactKeyboard(
//                    viewModel = calculatorViewModel
//                )
//            }
//            else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Medium) {
//                ExpandedKeyboard(
//                    viewModel = calculatorViewModel
//                )
//            }
//            else {
//                ExpandedKeyboard(
//                    viewModel = calculatorViewModel
//                )
//            }
//        }
//    }
//}

@Preview
@Composable
fun CalculatorUIPreview() {
    CalculatorUI()
}
