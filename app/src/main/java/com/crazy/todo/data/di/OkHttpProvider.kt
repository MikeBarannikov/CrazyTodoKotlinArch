package com.crazy.todo.data.di

import com.crazy.todo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpProvider {

    private lateinit var client: OkHttpClient

    fun provideClient(): OkHttpClient {
        if (!this::client.isInitialized) {
            val builder = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }

            client = builder.build()
        }

        return client
    }
}