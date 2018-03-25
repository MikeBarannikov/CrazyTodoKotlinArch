package com.crazy.todo.ui.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.crazy.todo.data.model.Film
import com.crazy.todo.data.repository.Repository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class TaskViewModel(private val repository: Repository) : ViewModel() {
    private val _films = MutableLiveData<List<Film>>()
    val films: LiveData<List<Film>> = _films

    fun fetchFilms() {
        launch(UI) {
            _films.value = repository.getFilms()
        }
    }
}
