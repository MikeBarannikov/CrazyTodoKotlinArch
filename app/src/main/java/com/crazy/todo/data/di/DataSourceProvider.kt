package com.crazy.todo.data.di

import com.crazy.todo.data.datasource.db.films.LocalFilmDataSourceImpl
import com.crazy.todo.data.datasource.remote.films.FilmDataSource
import retrofit2.Retrofit

class DataSourceProvider(private val retrofit: Retrofit) {

    fun provideFilmDataSource(): FilmDataSource = retrofit.create(FilmDataSource::class.java)

    fun provideLocalFilmDataSource() = LocalFilmDataSourceImpl()
}