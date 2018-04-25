package com.crazy.todo.ui.films

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.crazy.todo.data.model.Film
import com.crazy.todo.data.repository.Repository
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class FilmViewModel(private val repository: Repository) : ViewModel() {
    private val _films = MutableLiveData<List<Film>>()
    private val _loading = MutableLiveData<Boolean>()
    private val _film = MutableLiveData<Film>()

    val films: LiveData<List<Film>> = _films
    val loading: LiveData<Boolean> = _loading
    val film: LiveData<Film> = _film

    private var fetchFilmsJob: Job? = null
    private var favouriteStatusUpdateJob: Job? = null
    private var fetchFilmJob: Job? = null

    fun fetchFilms() {
        fetchFilmsJob?.cancel()
        fetchFilmsJob = launch(UI) {
            _loading.value = true
            _films.value = async {
                repository.getFilms().apply {
                    forEach { it.favourite = repository.isFavourite(it.id) }
                }
            }.await()
            _loading.value = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        fetchFilmsJob?.cancel()
        favouriteStatusUpdateJob?.cancel()
        fetchFilmJob?.cancel()
    }

    fun updateFavourite(filmId: String, favouriteStatus: Boolean) {
        favouriteStatusUpdateJob?.cancel()
        favouriteStatusUpdateJob = launch(UI) {
            try {
                _loading.value = true
                async {
                    repository.updateFavourite(filmId, favouriteStatus)
                    _films.postValue(_films.value?.apply {
                        filter { it.id == filmId }
                                .forEach { it.favourite = favouriteStatus }
                    })
                    _film.postValue(_film.value?.apply {
                        if (id == filmId) {
                            favourite = favouriteStatus
                        }
                    })
                }.await()
            } finally {
                _loading.value = false
            }
        }
    }

    fun fetchFilm(filmId: String) {
        fetchFilmJob?.cancel()
        fetchFilmJob = launch(UI) {
            _loading.value = true
            _film.value = repository.getFilm(filmId).apply {
                favourite = repository.isFavourite(filmId)
            }
            _loading.value = false
        }
    }
}
