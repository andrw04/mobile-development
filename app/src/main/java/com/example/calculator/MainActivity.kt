package com.example.calculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculator.common.NavigationRoutes
import com.example.calculator.ui.layouts.CalculatorUI
import com.example.calculator.ui.layouts.signin.SignInScreen
import com.example.calculator.ui.layouts.signup.SignUpScreen
import com.example.calculator.ui.theme.CalculatorTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val db = Firebase.firestore

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoutes.SIGN_IN,
                        builder = {
                            composable(NavigationRoutes.SIGN_IN) {
                                SignInScreen(navController = navController)
                            }

                            composable(NavigationRoutes.SIGN_UP) {
                                SignUpScreen(navController = navController)
                            }

                            composable(NavigationRoutes.FORGOT_PASSWORD) {

                            }

                            composable(NavigationRoutes.CALCULATOR) {
                                CalculatorUI()
                            }
                        }
                    )
                }
            }
        }
    }
}