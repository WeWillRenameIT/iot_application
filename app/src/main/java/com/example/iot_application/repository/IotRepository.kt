package com.example.iot_application.repository

import com.example.iot_application.data.remote.responses.IotApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class IotRepository @Inject constructor(
    private val api: IotApi
){

}