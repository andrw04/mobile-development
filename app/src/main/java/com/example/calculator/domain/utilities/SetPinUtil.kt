package com.example.calculator.domain.utilities

import android.content.Intent
import android.widget.Toast
import com.example.calculator.AuthActivity
import com.example.calculator.MainActivity

fun setPin(activity: AuthActivity, pin: String) {
    if (pin.length == activity.MAX_PIN_LENGTH) {
        if (activity.storedPin == null) {
            activity.pinEncryptionUtils.savePinToSecureStorage(activity, pin)
            activity.storedPin = pin
            Toast.makeText(activity.applicationContext, "PIN set successfully", Toast.LENGTH_SHORT).show()
        } else {
            showBiometricConfirmationDialog(activity, pin)
        }
    } else {
        Toast.makeText(activity.applicationContext, "PIN must contain ${activity.MAX_PIN_LENGTH} digits", Toast.LENGTH_SHORT).show()
    }
}

fun login(activity: AuthActivity, pin: String) {
    if (activity.storedPin == null) {
        Toast.makeText(activity.applicationContext, "PIN not set", Toast.LENGTH_SHORT).show()
    } else if (pin.length == activity.MAX_PIN_LENGTH && pin == activity.storedPin) {
        Toast.makeText(activity.applicationContext, "PIN correct. Logging in...", Toast.LENGTH_SHORT).show()
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    } else {
        Toast.makeText(activity.applicationContext, "Incorrect PIN", Toast.LENGTH_SHORT).show()
    }
}