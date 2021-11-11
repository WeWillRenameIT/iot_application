package com.example.iot_application.repository

import com.example.iot_application.data.remote.responses.IotApi
import com.example.iot_application.data.remote.responses.IotToken
import com.example.iot_application.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.RequestBody
import javax.inject.Inject

@ActivityScoped
class IotRepository @Inject constructor(
    private val api: IotApi
){



    suspend fun postAuthorise(
        requestBody: RequestBody
    ): Resource<IotToken> {
        val response = try {
            api.postAuthorise(requestBody)
        } catch (e: Exception){
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }
}