package com.crazy.todo.data.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.crazy.todo.data.repository.Repository
import com.crazy.todo.ui.films.FilmViewModel

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    private val creators: Map<Class<out ViewModel>, Int> = mapOf(
            FilmViewModel::class.java to 0
    )

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(creators[modelClass]) {
            0 -> FilmViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown view model class $modelClass")
        }
    }
}