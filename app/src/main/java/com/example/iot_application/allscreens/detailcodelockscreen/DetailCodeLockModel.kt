package com.example.iot_application.allscreens.detailcodelockscreen

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
class DetailCodeLockModel @Inject constructor(
    private val repository: IotRepository
) : ViewModel() {


    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)




    suspend fun postDeleteCodeLock(
        token: String,
        codelock_id: String
    ): Resource<String> {
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        jsonObject.put("codelock_id", codelock_id.toInt())
        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var response = repository.postDeleteCodeLock(buuBodyRequest)


        Log.e("postDeleteCodeLock -> ", jsonObjectString)


        return response
    }

    suspend fun postEditCodeLock(
        token: String,
        codelock_id: String,
        describe: String,
        name: String
        ): Resource<String> {
        val jsonObject = JSONObject()
        jsonObject.put("token", token)
        jsonObject.put("codelock_id", codelock_id.toInt())
        jsonObject.put("describe", describe)
        jsonObject.put("name", name)

        val jsonObjectString = jsonObject.toString()
        val buuBodyRequest = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


        var response = repository.postEditCodeLock(buuBodyRequest)


        Log.e("postEditCodeLock -> ", jsonObjectString)


        return response
    }

}