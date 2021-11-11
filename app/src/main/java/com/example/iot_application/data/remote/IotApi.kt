package com.example.iot_application.data.remote.responses

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface IotApi {


    @POST("authorise")
    suspend fun postAuthorise(
        @Body requestBody: RequestBody
    ) : IotToken

}