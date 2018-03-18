package com.crazy.todo.ui.tasks

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crazy.todo.R
import kotlinx.android.synthetic.main.fr_tasks.*

class TasksFragment : Fragment() {

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fr_tasks, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        viewModel.num.observe(
                this,
                Observer {
                    textView.text = it.toString()
                }
        )
        button.setOnClickListener {
            Log.d("MYDEBUG", "---------test started---------")
            viewModel.testAsync()
        }
    }

    companion object {
        fun newInstance(): TasksFragment {
            return TasksFragment()
        }
    }
}