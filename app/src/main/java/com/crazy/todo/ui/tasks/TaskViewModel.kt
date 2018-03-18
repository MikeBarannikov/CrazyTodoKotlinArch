package com.crazy.todo.ui.tasks

import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class TaskViewModel: ViewModel() {
    fun test() {
        async(UI) {
        }
    }
}
