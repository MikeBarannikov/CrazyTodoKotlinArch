package com.crazy.todo.data.datasource.db.films

interface LocalFilmDataSource {
    fun updateFavourite(filmId: String, favouriteStatus: Boolean)

    fun isFavourite(filmId: String) : Boolean
}