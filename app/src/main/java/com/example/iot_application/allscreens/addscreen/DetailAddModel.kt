package com.example.iot_application.allscreens.addscreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject


@HiltViewModel
class DetailAddModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {


    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)




    suspend fun postAddUser(
        token: String,
        login: String,
        first_name: String,
        last_name: String,
        patronym: String,
        password: String,
        code: String,
        role: Int,
    ): Resource<String> {
        //isLoading.value = true
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        jsonObject.put("login", login)
        jsonObject.put("first_name", first_name)
        jsonObject.put("last_name", last_name)
        jsonObject.put("patronym", patronym)
        jsonObject.put("password", password)
        jsonObject.put("code", code)
        jsonObject.put("role", role)
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var response = repository.postAddUser(buuBodyRequest)


        Log.e("DAM_ADU -> ", jsonObjectString)


        return response
    }

    suspend fun postAddCodeLock(
        token: String,
        name: String,
        describe: String,
    ): Resource<String> {
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        jsonObject.put("name", name)
        jsonObject.put("describe", describe)
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var response = repository.postAddCodeLock(buuBodyRequest)


        Log.e("DAM_ADL -> ", jsonObjectString)


        return response
    }
}