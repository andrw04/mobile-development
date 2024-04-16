package com.example.calculator.domain.utilities

import android.content.ContentValues
import android.util.Log
import androidx.compose.ui.graphics.Color
import com.example.calculator.states.AppTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ThemeRepository {
    companion object {
        suspend fun fetchThemes(): List<AppTheme> {
            return withContext(Dispatchers.IO) {
                val db = Firebase.firestore
                val themes = mutableListOf<AppTheme>()

                try {
                    val result = db.collection("theme").get().await()
                    for (document in result) {
                        val appTheme = AppTheme(
                            themeName = document.data["themeName"] as String,
                            backgroundColor = Color(document.getLong("backgroundColor") as Long),
                            displayTextColor = Color(document.getLong("displayTextColor") as Long),
                            numberButtonColor = Color(document.getLong("numberButtonColor") as Long),
                            operationButtonColor = Color(document.getLong("operationButtonColor") as Long),
                            functionButtonColor = Color(document.getLong("functionButtonColor") as Long),
                            numberButtonTextColor = Color(document.getLong("numberButtonTextColor") as Long),
                            operationButtonTextColor = Color(document.getLong("operationButtonTextColor") as Long),
                            functionButtonTextColor = Color(document.getLong("functionButtonTextColor") as Long)
                        )
                        themes.add(appTheme)
                    }
                    themes
                } catch (exception: Exception) {
                    Log.d(ContentValues.TAG, "Error getting documents", exception)
                    emptyList()
                }
            }
        }
    }
}
