package com.crazy.todo.data.repository

import com.crazy.todo.data.model.Film

interface Repository {
    suspend fun getFilms(): List<Film>

    suspend fun updateFavourite(filmId: String, favouriteStatus: Boolean)

    suspend fun isFavourite(filmId: String): Boolean

    suspend fun getFilm(filmId: String): Film
}