package com.example.iot_application.allscreens.journalscreen

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.runBlocking


@Composable
fun JournalScreenState(
    iotToken: String,
    viewModel: JournalViewModel = hiltViewModel()

) {
    val journalList by remember { viewModel.journalList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }


    Log.e("JSS -> ", journalList.toString())
    var loadList by remember { mutableStateOf(true) }
    if(loadList) {
        runBlocking {
            viewModel.getJournal(iotToken)
        }
        loadList = false
    }

    LazyColumn(
        contentPadding = PaddingValues(10.dp)
    ){
        items(journalList.size){
            JournalScreenRow(
                id = it+1,
                userId = journalList[it].User_id,
                codeLockName = journalList[it].Codelock_name,
                fio = journalList[it].Fio,
                timestamp = journalList[it].Timestamp,
                result = journalList[it].Results
            )
        }
        items(1)
        {
            Spacer(modifier = Modifier.height(60.dp))
        }

    }


    Log.e("JSS -> ", journalList.toString())

}