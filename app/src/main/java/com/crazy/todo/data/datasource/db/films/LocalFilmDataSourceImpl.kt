package com.crazy.todo.data.datasource.db.films

class LocalFilmDataSourceImpl : LocalFilmDataSource {
    private val map = mutableMapOf<String, Boolean>()

    override fun updateFavourite(filmId: String, favouriteStatus: Boolean) {
        if (favouriteStatus) {
            map[filmId] = favouriteStatus
        } else {
            map.remove(filmId)
        }
    }

    override fun isFavourite(filmId: String) = map[filmId] ?: false
}