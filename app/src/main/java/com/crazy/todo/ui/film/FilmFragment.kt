package com.crazy.todo.ui.film

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crazy.todo.AppDelegate
import com.crazy.todo.R
import com.crazy.todo.ui.base.view.LoadingView
import com.crazy.todo.ui.dialog.LoadingDialog
import com.crazy.todo.ui.films.FilmViewModel
import kotlinx.android.synthetic.main.fr_film.*

class FilmFragment : Fragment() {
    private lateinit var viewModel: FilmViewModel
    private lateinit var loadingView: LoadingView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_film, container, false)
    }

    private lateinit var filmId: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadingView = LoadingDialog.view(this)

        viewModel = ViewModelProviders.of(this, AppDelegate.viewModelFactory).get(FilmViewModel::class.java)
        viewModel.loading.observe(
                this,
                Observer {
                    if (it == true) loadingView.showLoadingIndicator() else loadingView.hideLoadingIndicator()
                }
        )
        viewModel.film.observe(
                this,
                Observer {
                    it?.let {
                        filmTitle.text = it.title
                        filmReleaseDate.text = it.releaseDate
                        filmRating.text = it.rtScore
                        filmDirector.text = it.director
                        filmProducer.text = it.producer
                        filmDescription.text = it.description
                        filmWatched.setImageResource(
                                if (it.favourite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
                        )
                    }
                }
        )

        arguments?.let {
            filmId = it.getString(KEY_FILM_ID) ?: ""
            if (TextUtils.isEmpty(filmId)) {
                activity?.supportFinishAfterTransition()
            } else {
                viewModel.fetchFilm(filmId)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        filmWatched.setOnClickListener {
            viewModel.film.value?.let {
                viewModel.updateFavourite(filmId, !it.favourite)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        filmWatched.setOnClickListener(null)
    }

    companion object {
        const val KEY_FILM_ID = "KEY_FILM_ID"

        fun newInstance(filmId: String) = FilmFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_FILM_ID, filmId)
            }
        }
    }
}