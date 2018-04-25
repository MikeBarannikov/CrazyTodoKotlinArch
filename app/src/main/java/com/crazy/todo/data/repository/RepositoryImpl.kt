package com.crazy.todo.data.repository

import com.crazy.todo.data.datasource.db.films.LocalFilmDataSource
import com.crazy.todo.data.datasource.remote.films.FilmDataSource
import com.crazy.todo.data.model.Film
import com.crazy.todo.utils.extension.kotlinx.coroutines.experimental.await
import kotlinx.coroutines.experimental.delay

class RepositoryImpl(
        private val filmDataSource: FilmDataSource,
        private val localDataSource: LocalFilmDataSource
) : Repository {

    override suspend fun getFilms(): List<Film> = filmDataSource.getFilms().await()

    override suspend fun updateFavourite(filmId: String, favouriteStatus: Boolean) {
        delay(300)
        localDataSource.updateFavourite(filmId, favouriteStatus)
    }

    override suspend fun isFavourite(filmId: String) = localDataSource.isFavourite(filmId)

    override suspend fun getFilm(filmId: String): Film = filmDataSource.getFilm(filmId).await()
}