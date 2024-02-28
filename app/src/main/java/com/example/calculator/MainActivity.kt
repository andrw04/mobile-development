package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.components.CalculatorUI
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.viewmodels.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                CalculatorUI()
            }
        }
    }
}

@Preview
@Composable
fun CalculatorUIPreview() {
    CalculatorUI()
}
