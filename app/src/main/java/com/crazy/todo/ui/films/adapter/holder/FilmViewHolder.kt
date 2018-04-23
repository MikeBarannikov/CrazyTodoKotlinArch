package com.crazy.todo.ui.films.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.VISIBLE
import com.crazy.todo.data.model.Film
import kotlinx.android.synthetic.main.li_film.view.*

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(film: Film, isFirst: Boolean) {
        itemView.divider.visibility = if (isFirst) View.GONE else VISIBLE
        itemView.filmTitle.text = film.title
        itemView.filmReleaseDate.text = film.releaseDate
        itemView.filmRating.text = film.rtScore
    }
}
