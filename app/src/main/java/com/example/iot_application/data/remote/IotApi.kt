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

    @POST("add_user")
    suspend fun postAddUser(
        @Body requestBody: RequestBody
    ) : String

    @POST("add_codelock")
    suspend fun postAddCodeLock(
        @Body requestBody: RequestBody
    ) : String

    @POST("delete_user")
    suspend fun postDeleteUser(
        @Body requestBody: RequestBody
    ) : String

    @POST("edit_user")
    suspend fun postEditUser(
        @Body requestBody: RequestBody
    ) : String

    @POST("delete_codelock")
    suspend fun postDeleteCodeLock(
        @Body requestBody: RequestBody
    ) : String

    @POST("edit_codelock")
    suspend fun postEditCodeLock(
        @Body requestBody: RequestBody
    ) : String

    @POST("token_verify")
    suspend fun postTokenVerify(
        @Body requestBody: RequestBody
    ) : String



}