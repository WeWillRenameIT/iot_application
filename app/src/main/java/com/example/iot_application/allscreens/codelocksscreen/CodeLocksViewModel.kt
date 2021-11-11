package com.example.iot_application.allscreens.codelocksscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.iot_application.data.remote.responses.IotCodeLockItem
import com.example.iot_application.data.remote.responses.IotJournalItem
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CodeLocksViewModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {

    var codeLocksList = mutableStateOf<List<IotCodeLockItem>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)
    var iotToken = mutableStateOf("")


    fun changeToken(token: String) {
        iotToken.value = token
    }


    suspend fun getCodeLocks(token: String) {
        //Log.e("JVM -> ", "RUNNN")
        isLoading.value = true
        val result = repository.getCodeLocks(token)
        Log.e("JVM -> ", "Error->result: ${result.message}")
        when (result) {
            is Resource.Success -> {
                //endReached.value = curPage * PAGE_SIZE >= result.data!!.count
                val codeLocksEntries = result.data!!.mapIndexed { index, entry ->
                    val description = entry.Description
                    val id = entry.Id
                    val name = entry.Name
                    IotCodeLockItem(description, id, name)
                }
                //curPage++
                loadError.value = ""
                isLoading.value = false
                codeLocksList.value += codeLocksEntries
            }
            is Resource.Error -> {
                loadError.value = result.message!!
                Log.e("JVM -> ", "Error ${loadError.value}")
                isLoading.value = false
            }
        }
    }
}

