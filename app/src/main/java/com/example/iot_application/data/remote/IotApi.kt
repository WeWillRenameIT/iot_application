package com.example.iot_application.data.remote.responses

import okhttp3.RequestBody
import retrofit2.http.*

interface IotApi {


    @GET("journal")
    suspend fun getJournal(
        @Query("token") token: String
    ): IotJournal

    @GET("users")
    suspend fun getUsers(
        @Query("token") token: String
    ): IotUsers

    @GET("codelocks")
    suspend fun getCodeLocks(
        @Query("token") token: String
    ): IotCodeLock

    @POST("authorise")
    suspend fun postAuthorise(
        @Body requestBody: RequestBody
    ) : IotToken

}