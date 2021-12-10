package com.example.iot_application.data.remote.responses

data class IotUsersItem(
    val Id: Int,
    val Role: Int,
    val First_name: String,
    val Last_name: String,
    val Patronym: String,
    val Username: String
)