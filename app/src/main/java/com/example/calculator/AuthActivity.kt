package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.calculator.domain.utilities.PinEncryptionUtils
import com.example.calculator.ui.layouts.signin.SignInScreen
import com.example.calculator.ui.theme.CalculatorTheme
import java.util.concurrent.Executor

class AuthActivity : AppCompatActivity() {
    lateinit var executor: Executor
    lateinit var pinEncryptionUtils: PinEncryptionUtils
    val MAX_PIN_LENGTH = 6
    var storedPin: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        executor = ContextCompat.getMainExecutor(this)
        pinEncryptionUtils = PinEncryptionUtils()
        storedPin = pinEncryptionUtils.loadPinFromSecureStorage(this)

        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    SignInScreen()
                }
            }
        }
    }
}