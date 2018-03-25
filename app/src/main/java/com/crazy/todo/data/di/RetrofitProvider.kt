package com.crazy.todo.data.di

import com.crazy.todo.data.datasource.url.UrlDataSource
import com.crazy.todo.utils.GsonUtils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider(okHttpClient: OkHttpClient, urlDataSource: UrlDataSource) {

    private val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(urlDataSource.provideFilmsUrl())
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(GsonUtils.requestGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

    fun provideRetrofit(): Retrofit {
        return retrofit
    }
}