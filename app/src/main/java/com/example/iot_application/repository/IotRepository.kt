package com.example.iot_application.repository

import android.util.Log
import com.example.iot_application.data.remote.responses.*
import com.example.iot_application.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.RequestBody
import javax.inject.Inject

@ActivityScoped
class IotRepository @Inject constructor(
    private val api: IotApi
){


    suspend fun getUsers(token: String): Resource<IotUsers> {
        val response = try {
            api.getUsers(token)
        } catch(e: Exception) {
            //Log.e("REP -> ", e.message!!)
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getCodeLocks(token: String): Resource<IotCodeLock> {
        val response = try {
            api.getCodeLocks(token)
        } catch(e: Exception) {
            //Log.e("REP -> ", e.message!!)
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }


    suspend fun getJournal(token: String): Resource<IotJournal> {
        val response = try {
            api.getJournal(token)
        } catch(e: Exception) {
            //Log.e("REP -> ", e.message!!)
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)
    }

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