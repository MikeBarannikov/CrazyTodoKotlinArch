package com.crazy.todo.ui.films

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crazy.todo.AppDelegate
import com.crazy.todo.R
import com.crazy.todo.ui.films.adapter.FilmsAdapter
import kotlinx.android.synthetic.main.fr_films.*

class FilmsFragment : Fragment() {

    private lateinit var viewModel: FilmViewModel
    private val adapter = FilmsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_films, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        viewModel = ViewModelProviders.of(this, AppDelegate.viewModelFactory).get(FilmViewModel::class.java)
        viewModel.films.observe(
                this,
                Observer {
                    adapter.changeData(it)
                }
        )
        viewModel.fetchFilms()
    }

    companion object {
        fun newInstance(): FilmsFragment = FilmsFragment()
    }
}