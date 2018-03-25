package com.crazy.todo.data.datasource.films

import com.crazy.todo.data.model.Film
import retrofit2.Call
import retrofit2.http.GET

interface FilmsDataSource {
    @GET("films")
    fun getFilms(): Call<List<Film>>
}