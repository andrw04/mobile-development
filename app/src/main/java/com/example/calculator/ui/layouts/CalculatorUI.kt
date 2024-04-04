package com.example.calculator.ui.layouts

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.components.Display
import com.example.calculator.ui.components.Keyboard
import com.example.calculator.domain.CalculatorViewModel

@Composable
fun CalculatorUI(
    modifier: Modifier = Modifier,
    calculatorViewModel: CalculatorViewModel = viewModel()
) {
    val calculatorUiState by calculatorViewModel.uiState.collectAsState()

    val orientation = LocalConfiguration.current.orientation
    val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE

    Surface(
        color = Color(0xFF_80_C0_FF)
    ) {
        Column(
          modifier = Modifier.fillMaxSize()
        ) {
            Display(
                text = calculatorUiState.currentText,
                modifier = modifier.weight(2f)
            )
            if (isLandscape)
            {
                Keyboard(modifier = modifier.weight(3f));
            }
            else {
                Keyboard(
                    modifier = modifier.weight(5f)
                );
            }
        }
    }
}

@Preview
@Composable
fun CalculatorUIPreview() {
    CalculatorUI()
}