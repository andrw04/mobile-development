package com.example.calculator.domain.utilities

import android.content.Intent
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import com.example.calculator.AuthActivity
import com.example.calculator.MainActivity

fun biometricAuth(activity: AuthActivity) {
    val biometricAuthPrompt = BiometricPrompt(activity, activity.executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(activity.applicationContext, "Auth error: $errString", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(activity.applicationContext, "Auth succeeded", Toast.LENGTH_SHORT).show()
                activity.startActivity(Intent(activity, MainActivity::class.java))
                activity.finish()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(activity.applicationContext, "Auth failed", Toast.LENGTH_SHORT).show()
            }
        })

    val authPromptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Login into application")
        .setSubtitle("Using fingerprint")
        .setNegativeButtonText("Use alternative password")
        .setConfirmationRequired(false)
        .build()

    biometricAuthPrompt.authenticate(authPromptInfo)
}

fun showBiometricConfirmationDialog(activity: AuthActivity, newPin: String) {
    val biometricPrompt = BiometricPrompt(activity, activity.executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(activity.applicationContext, "Auth error: $errString", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                activity.pinEncryptionUtils.savePinToSecureStorage(activity, newPin)
                activity.storedPin = newPin
                Toast.makeText(activity.applicationContext, "PIN updated successfully", Toast.LENGTH_SHORT).show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(activity.applicationContext, "Auth failed", Toast.LENGTH_SHORT).show()
            }
        })

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Confirm PIN change")
        .setSubtitle("Using fingerprint to confirm PIN change")
        .setNegativeButtonText("Cancel")
        .build()

    biometricPrompt.authenticate(promptInfo)
}