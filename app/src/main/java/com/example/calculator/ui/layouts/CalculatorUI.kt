package com.example.calculator.ui.layouts

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.domain.CalculatorAction
import com.example.calculator.ui.components.Display
import com.example.calculator.ui.components.Keyboard
import com.example.calculator.domain.CalculatorViewModel
import com.example.calculator.domain.VolumeButtonHandler
import com.example.calculator.states.AppTheme
import com.example.calculator.ui.components.MenuButton

@Composable
fun CalculatorUI(
    modifier: Modifier = Modifier,
    calculatorViewModel: CalculatorViewModel = viewModel(),
) {
    val calculatorUiState by calculatorViewModel.uiState.collectAsState()

    val orientation = LocalConfiguration.current.orientation
    val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE

    val appTheme =

    Surface(
        color = Color(0xFF_F1_F2_F3)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            MenuButton(
                modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp))

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Display(
                    text = calculatorUiState.currentText,
                    modifier = modifier.weight(2f),
                    appTheme = calculatorUiState.appTheme
                )
                if (isLandscape)
                {
                    Keyboard(
                        modifier = modifier.weight(3f),
                        appTheme = calculatorUiState.appTheme
                    );
                }
                else {
                    Keyboard(
                        modifier = modifier.weight(5f),
                        appTheme = calculatorUiState.appTheme
                    );
                }
            }
        }
    }

    VolumeButtonHandler(
        onVolumeUp = { calculatorViewModel.onAction(CalculatorAction.Calculate) },
        onVolumeDown = { calculatorViewModel.onAction(CalculatorAction.Clear) }
    )
}

@Preview
@Composable
fun CalculatorUIPreview() {
    CalculatorUI()
}