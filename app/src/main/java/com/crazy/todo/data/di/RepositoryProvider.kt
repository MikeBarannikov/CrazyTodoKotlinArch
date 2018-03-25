package com.crazy.todo.data.di

import com.crazy.todo.data.datasource.films.FilmsDataSource
import com.crazy.todo.data.repository.Repository
import com.crazy.todo.data.repository.RepositoryImpl

class RepositoryProvider(filmsDataSource: FilmsDataSource) {

    private val repository: Repository = RepositoryImpl(filmsDataSource)

    fun provideRepository(): Repository {
        return repository
    }
}