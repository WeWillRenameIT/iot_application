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
            return Resource.Error(e.message.toString())
        }
        Log.e("getUsers ->", "True")
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

    suspend fun postAddUser(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postAddUser(requestBody)
        } catch (e: Exception){
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }

    suspend fun postAddCodeLock(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postAddCodeLock(requestBody)
        } catch (e: Exception){
            Log.e("postAddCodeLock", "False")
            return Resource.Error(e.message.toString())
        }
        Log.e("postAddCodeLock", "True")
        return Resource.Success(response)
    }

    suspend fun postDeleteUser(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postDeleteUser(requestBody)
        } catch (e: Exception){
            Log.e("postDeleteUser", "False")
            return Resource.Error(e.message.toString())
        }
        Log.e("postDeleteUser", "True")
        return Resource.Success(response)
    }

    suspend fun postEditUser(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postEditUser(requestBody)
        } catch (e: Exception){
            Log.e("postEditUser", "False")
            return Resource.Error(e.message.toString())
        }
        Log.e("postEditUser", "True")
        return Resource.Success(response)
    }

    suspend fun postDeleteCodeLock(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postDeleteCodeLock(requestBody)
        } catch (e: Exception){
            Log.e("postDeleteCodeLock", "False")
            return Resource.Error(e.message.toString())
        }
        Log.e("postDeleteCodeLock", "True")
        return Resource.Success(response)
    }


    suspend fun postEditCodeLock(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postEditCodeLock(requestBody)
        } catch (e: Exception){
            Log.e("postEditCodeLock", "False")
            return Resource.Error(e.message.toString())
        }
        Log.e("postEditCodeLock", "True")
        return Resource.Success(response)
    }

    suspend fun postTokenVerify(
        requestBody: RequestBody
    ): Resource<String> {
        val response = try {
            api.postTokenVerify(requestBody)
        } catch (e: Exception){
            Log.e("postTokenVerify", "False")
            return Resource.Error(e.message.toString())
        }
        Log.e("postTokenVerify", "True")
        return Resource.Success(response)
    }

}