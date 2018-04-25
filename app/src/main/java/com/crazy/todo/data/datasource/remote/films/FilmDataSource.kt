package com.crazy.todo.data.datasource.remote.films

import com.crazy.todo.data.model.Film
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmDataSource {
    @GET("films")
    fun getFilms(): Call<List<Film>>

    @GET("films/{id}")
    fun getFilm(@Path("id") filmId: String): Call<Film>
}