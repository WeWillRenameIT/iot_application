package com.example.iot_application.data.remote.responses

import java.sql.Timestamp

data class IotJournalItem(
    val Codelock_name: String,
    val Fio: String,
    val Id: Int,
    val Results: String,
    val Timestamp: String,
    val User_id: Int
)