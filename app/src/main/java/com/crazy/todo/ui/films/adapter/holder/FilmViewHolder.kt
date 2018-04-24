package com.crazy.todo.ui.films.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.VISIBLE
import com.crazy.todo.R
import com.crazy.todo.data.model.Film
import kotlinx.android.synthetic.main.li_film.view.*

class FilmViewHolder(
        itemView: View,
        private val listener: FilmListener
) : RecyclerView.ViewHolder(itemView) {
    private lateinit var film: Film

    init {
        itemView.setOnClickListener { listener.onItemClicked(film) }
        itemView.filmWatched.setOnClickListener { listener.onFavouriteClicked(film) }
    }

    fun bind(film: Film, isFirst: Boolean) {
        this.film = film
        itemView.divider.visibility = if (isFirst) View.GONE else VISIBLE
        itemView.filmTitle.text = film.title
        itemView.filmReleaseDate.text = film.releaseDate
        itemView.filmRating.text = film.rtScore
        itemView.filmWatched.setImageResource(
                if (film.favourite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        )
    }

    interface FilmListener {
        fun onItemClicked(film: Film)

        fun onFavouriteClicked(film: Film)
    }
}
