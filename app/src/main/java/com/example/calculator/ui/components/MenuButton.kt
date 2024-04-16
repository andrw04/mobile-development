package com.example.calculator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.domain.CalculatorAction
import com.example.calculator.domain.CalculatorViewModel
import com.example.calculator.domain.utilities.ThemeRepository
import com.example.calculator.states.AppTheme


@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Show menu")
        }

        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false }
        ) {
            var themes by remember { mutableStateOf(listOf<AppTheme>()) }

            LaunchedEffect(key1 = true) {
                themes = ThemeRepository.fetchThemes()
            }

            for (theme in themes) {
                DropdownMenuItem(
                    text = { Text(theme.themeName) },
                    onClick = { viewModel.onAction(CalculatorAction.SetTheme(theme)) })
            }
        }
    }
}
