package com.example.calculator.ui.layouts

import android.Manifest
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.domain.viewmodels.CalculatorAction
import com.example.calculator.ui.components.Display
import com.example.calculator.ui.components.Keyboard
import com.example.calculator.domain.viewmodels.CalculatorViewModel
import com.example.calculator.domain.handlers.VolumeButtonHandler
import com.example.calculator.domain.handlers.NotificationHandler
import com.example.calculator.ui.components.MenuButton
import com.example.calculator.ui.theme.ChangeStatusBarColor
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.platform.LocalContext
import com.example.calculator.ui.components.ExpandableList
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CalculatorUI(
    modifier: Modifier = Modifier,
    calculatorViewModel: CalculatorViewModel = viewModel(),
) {
    val calculatorUiState by calculatorViewModel.uiState.collectAsState()

    val orientation = LocalConfiguration.current.orientation
    val isLandscape = orientation == Configuration.ORIENTATION_LANDSCAPE
    
    ChangeStatusBarColor(appTheme = calculatorUiState.appTheme)

    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val notificationHandler = NotificationHandler(LocalContext.current)

    LaunchedEffect(key1 = true) {
        if (!postNotificationPermission.status.isGranted) {
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Surface(
        color = calculatorUiState.appTheme.backgroundColor
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                ExpandableList(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(48.dp)
                )

                MenuButton(
                    modifier = Modifier
                        .padding(16.dp),
                    notificationHandler = { title, message ->
                        notificationHandler.showSimpleNotification(title, message)
                    }
                )
            }


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
