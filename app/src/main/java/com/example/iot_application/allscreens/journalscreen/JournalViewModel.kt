package com.example.iot_application.allscreens.journalscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iot_application.data.remote.responses.IotJournalItem
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


@HiltViewModel
class JournalViewModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {

    var journalList = mutableStateOf<List<IotJournalItem>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)
    var iotToken = mutableStateOf("")


    fun changeToken(token: String) {
        iotToken.value = token
    }


    suspend fun getJournal(token: String) {
        //Log.e("JVM -> ", "RUNNN")
        isLoading.value = true
        val result = repository.getJournal(token)
        Log.e("getJournal -> ", "Error->result: ${result.message}")
        when (result) {
            is Resource.Success -> {
                //endReached.value = curPage * PAGE_SIZE >= result.data!!.count
                val journalEntries = result.data!!.mapIndexed { index, entry ->
                    val id = entry.Id
                    val codeLockName = entry.Codelock_name
                    val fio = entry.Fio
                    val results = entry.Results
                    val timestamp = entry.Timestamp
                    val userId = entry.User_id
                    IotJournalItem(codeLockName, fio, id, results, timestamp, userId)
                }
                //curPage++
                loadError.value = ""
                isLoading.value = false
                journalList.value += journalEntries
            }
            is Resource.Error -> {
                loadError.value = result.message!!
                Log.e("getJournal -> ", "Error ${loadError.value}")
                isLoading.value = false
            }
        }
    }
}

