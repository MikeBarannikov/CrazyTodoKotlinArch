package com.crazy.todo.ui.films

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.crazy.todo.data.model.Film
import com.crazy.todo.data.repository.Repository
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class FilmViewModel(private val repository: Repository) : ViewModel() {
    private val _films = MutableLiveData<List<Film>>()
    val films: LiveData<List<Film>> = _films

    private var fetchFilmsJob: Job? = null

    fun fetchFilms() {
        fetchFilmsJob?.cancel()
        fetchFilmsJob = launch(UI) {
            _films.value = repository.getFilms()
        }
    }

    override fun onCleared() {
        super.onCleared()
        fetchFilmsJob?.cancel()
    }
}
