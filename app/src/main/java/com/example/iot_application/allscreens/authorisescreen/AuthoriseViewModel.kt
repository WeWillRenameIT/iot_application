package com.example.iot_application.allscreens.authorisescreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iot_application.data.remote.responses.IotToken
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject


@HiltViewModel
class AuthoriseViewModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {


    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)




    suspend fun postAuthorise(login: String, password: String): Resource<IotToken> {
        //isLoading.value = true
        val jsonObject = JSONObject()
        jsonObject.put("login", login)
        jsonObject.put("password", password)
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var newIotToken = repository.postAuthorise(buuBodyRequest)

        Log.e("AVM -> ", "login: $login password: $password")
        Log.e("AVM -> ", jsonObjectString)
        Log.e("AVM -> ", "message: ${newIotToken.message}")
        Log.e("AVM -> ", "token: ${newIotToken.data?.token}")

        return newIotToken
    }

    suspend fun postTokenVerify(token: String): Resource<IotToken> {
        //isLoading.value = true
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var verify = repository.postAuthorise(buuBodyRequest)


        Log.e("postAuthorise -> ", "${verify.data}")

        return verify
    }

}