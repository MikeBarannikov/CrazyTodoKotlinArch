package com.crazy.todo.data.di

import com.crazy.todo.data.datasource.films.FilmsDataSource
import retrofit2.Retrofit

class DataSourceProvider(private val retrofit: Retrofit) {

    fun provideFilmsDataSource(): FilmsDataSource {
        return retrofit.create(FilmsDataSource::class.java)
    }
}