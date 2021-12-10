package com.example.iot_application.di

import com.example.iot_application.data.remote.responses.IotApi
import com.example.iot_application.repository.IotRepository
import com.example.iot_application.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.Gson

import com.google.gson.GsonBuilder
import retrofit2.converter.scalars.ScalarsConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun iotRepository(
        api: IotApi
    ) = IotRepository(api)

    @Singleton
    @Provides
    fun provideIotApi(): IotApi {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
            .create(IotApi::class.java)
    }
}