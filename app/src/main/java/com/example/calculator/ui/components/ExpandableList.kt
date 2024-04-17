package com.example.calculator.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.calculator.domain.utilities.FirebaseManager
import com.example.calculator.domain.utilities.HistoryRecord

@Composable
fun ExpandableList(
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }
    //val listItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    Box {
        IconButton(onClick = { showDialog = true }) {
            Icon(Icons.Default.List, contentDescription = "Show menu")
        }

        if (showDialog) {
            var historyRecords by remember { mutableStateOf(listOf<String>()) }
            LaunchedEffect(key1 = true) {
                historyRecords = FirebaseManager.fetchHistory()
            }

            Dialog(onDismissRequest = { showDialog = false}) {
                Surface(
                    modifier = Modifier
                        .padding(6.dp)
                        .size(600.dp)
                ) {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        Button(text = "Close", onClick = { showDialog = false}, modifier = Modifier
                            .align(Alignment.End)
                            .padding(16.dp))

                        for (record in historyRecords) {
                            Text(text = record, modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
                        }
                    }
                }
            }
        }
    }
}