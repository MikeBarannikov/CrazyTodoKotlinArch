package com.crazy.todo.data.repository

import com.crazy.todo.data.model.Film

interface Repository {
    suspend fun getFilms(): List<Film>
}