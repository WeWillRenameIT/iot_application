package com.example.iot_application.allscreens.userdetailscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.iot_application.data.remote.responses.IotToken
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class DetailUserViewModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {


    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)




    suspend fun postDeleteUser(
        token: String,
        user_id: String
    ): Resource<String> {
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        jsonObject.put("user_id", user_id.toInt())
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var response = repository.postDeleteUser(buuBodyRequest)


        Log.e("postDeleteUser -> ", jsonObjectString)


        return response
    }

    suspend fun postEditUser(
        token: String,
        user_id: String,
        login: String,
        first_name: String,
        last_name: String,
        patronym: String,
        password: String,
        code: String,
        role: String,

    ): Resource<String> {
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        jsonObject.put("user_id", user_id.toInt())
        jsonObject.put("login", login)
        jsonObject.put("first_name", first_name)
        jsonObject.put("last_name", last_name)
        jsonObject.put("patronym", patronym)
        jsonObject.put("password", password)
        jsonObject.put("code", code)
        jsonObject.put("role", role.toInt())

        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var response = repository.postEditUser(buuBodyRequest)


        Log.e("postEditUser -> ", jsonObjectString)


        return response
    }

}