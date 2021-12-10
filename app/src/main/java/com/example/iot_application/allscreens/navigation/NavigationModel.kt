package com.example.iot_application.allscreens.navigation

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
    class NavigationModel @Inject constructor(
        private val repository: IotRepository
    ) : ViewModel() {


        var loadError = mutableStateOf("")
        var isLoading = mutableStateOf(false)
        var endReached = mutableStateOf(false)







        suspend fun postTokenVerify(token: String): Resource<String> {
        //isLoading.value = true
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var verify = repository.postTokenVerify(buuBodyRequest)


        Log.e("postTokenVerify -> ", "${verify.data}")

        return verify
    }

}