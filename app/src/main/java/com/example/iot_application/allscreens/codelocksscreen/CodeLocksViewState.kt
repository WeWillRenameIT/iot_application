package com.example.iot_application.allscreens.codelocksscreen

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.iot_application.allscreens.Screens
import com.example.iot_application.allscreens.journalscreen.JournalScreenRow
import com.example.iot_application.allscreens.journalscreen.JournalViewModel
import com.example.iot_application.allscreens.journalscreen.PlusUserView
import kotlinx.coroutines.runBlocking

@Composable
fun CodeLocksScreenState(
    iotToken: String,
    setShowAddDialog: (Boolean) -> Unit,
    viewModel: CodeLocksViewModel = hiltViewModel(),
    fnButton: ()->Unit

) {
    val codeLocksList by remember { viewModel.codeLocksList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }


    Log.e("JSS -> ", codeLocksList.toString())
    var loadList by remember { mutableStateOf(true) }
    if(loadList) {
        runBlocking {
            viewModel.getCodeLocks(iotToken)
        }
        loadList = false
    }

    LazyColumn(
        contentPadding = PaddingValues(10.dp)
    ){
        items(codeLocksList.size){
            CodeLockScreenRow(
                id = it+1,
                name = codeLocksList[it].Name,
                description = codeLocksList[it].Description,
                fnButton = fnButton
            )
        }
        items(1)
        {
            Spacer(modifier = Modifier.height(60.dp))
        }

    }
    // TODO: 13.11.2021 Добавление замка
    PlusUserView(fnButton = {setShowAddDialog(true)})

    Log.e("JSS -> ", codeLocksList.toString())

}