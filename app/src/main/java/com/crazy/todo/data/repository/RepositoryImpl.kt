package com.crazy.todo.data.repository

import com.crazy.todo.data.datasource.films.FilmsDataSource
import com.crazy.todo.data.model.Film
import com.crazy.todo.utils.extension.kotlinx.coroutines.experimental.await

class RepositoryImpl(private val filmsDataSource: FilmsDataSource) : Repository {
    override suspend fun getFilms(): List<Film> = filmsDataSource.getFilms().await()
}