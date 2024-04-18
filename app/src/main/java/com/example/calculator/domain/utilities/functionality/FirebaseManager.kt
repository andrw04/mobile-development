package com.example.calculator.domain.utilities.functionality

import android.content.ContentValues
import android.util.Log
import androidx.compose.ui.graphics.Color
import com.example.calculator.domain.states.AppTheme
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FirebaseManager {
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

        fun recordCalculationHistory(expression: String, result: String) {
            val db = Firebase.firestore
            val timestamp = Timestamp.now()
            val record = HistoryRecord(expression, result, Timestamp.now())
            db.collection("history").add(record)
        }

        suspend fun fetchHistory(): List<String> {
            return withContext(Dispatchers.IO) {
                val db = Firebase.firestore

                try {
                    val records = mutableListOf<HistoryRecord>()
                    val result = db.collection("history").get().await()
                    for (record in result) {
                        val historyRecord = HistoryRecord(
                            expression = record.data["expression"] as String,
                            result = record.data["result"] as String,
                            timestamp = record.data["timestamp"] as Timestamp
                        )
                        records.add(historyRecord)
                    }

                    records.sortByDescending { record -> record.timestamp }

                    val stringRecords = mutableListOf<String>()

                    for (record in records) {
                        stringRecords.add("${record.expression} = ${record.result}")
                    }

                    stringRecords
                } catch (exception: Exception) {
                    Log.d(ContentValues.TAG, "Error getting documents", exception)
                    emptyList()
                }
            }
        }

        fun clearHistory() {
            val db = Firebase.firestore
            db.collection("history").get().addOnSuccessListener { result ->
                for (document in result) {
                    document.reference.delete()
                }
            }
        }
    }
}

data class HistoryRecord(val expression: String, val result: String, val timestamp: Timestamp)
