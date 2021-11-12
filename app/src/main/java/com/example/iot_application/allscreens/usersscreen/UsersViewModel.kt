package com.example.iot_application.allscreens.usersscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.iot_application.data.remote.responses.IotUsersItem
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {

    var usersList = mutableStateOf<List<IotUsersItem>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)
    var iotToken = mutableStateOf("")


    fun changeToken(token: String) {
        iotToken.value = token
    }


    suspend fun getUsers(token: String) {
        //Log.e("JVM -> ", "RUNNN")
        isLoading.value = true
        val result = repository.getUsers(token)
        Log.e("JVM -> ", "Error->result: ${result.message}")
        when (result) {
            is Resource.Success -> {
                //endReached.value = curPage * PAGE_SIZE >= result.data!!.count
                val usersEntries = result.data!!.mapIndexed { index, entry ->
                    val id = entry.Id
                    val username = entry.Fio
                    val role = entry.Role
                    IotUsersItem(id, role, username)
                }
                //curPage++
                loadError.value = ""
                isLoading.value = false
                usersList.value += usersEntries
            }
            is Resource.Error -> {
                loadError.value = result.message!!
                Log.e("JVM -> ", "Error ${loadError.value}")
                isLoading.value = false
            }
        }
    }
}

