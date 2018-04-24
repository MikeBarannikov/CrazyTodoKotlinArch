package com.crazy.todo.data.di

import com.crazy.todo.data.datasource.db.films.LocalFilmDataSource
import com.crazy.todo.data.datasource.remote.films.FilmDataSource
import com.crazy.todo.data.repository.Repository
import com.crazy.todo.data.repository.RepositoryImpl

class RepositoryProvider(filmDataSource: FilmDataSource, localFilmDataSource: LocalFilmDataSource) {

    private val repository: Repository = RepositoryImpl(filmDataSource, localFilmDataSource)

    fun provideRepository(): Repository {
        return repository
    }
}