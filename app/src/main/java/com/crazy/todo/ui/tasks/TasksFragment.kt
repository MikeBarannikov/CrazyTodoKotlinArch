package com.crazy.todo.ui.tasks

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment

class TasksFragment: Fragment() {

    private lateinit var viewModel: TaskViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
    }

    companion object {
        fun newInstance(): TasksFragment {
            return TasksFragment()
        }
    }
}