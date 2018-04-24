package com.crazy.todo.ui.films.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.crazy.todo.R
import com.crazy.todo.data.model.Film
import com.crazy.todo.ui.films.adapter.holder.FilmViewHolder

class FilmsAdapter(private val listener: FilmViewHolder.FilmListener) : RecyclerView.Adapter<FilmViewHolder>() {
    private val items: MutableList<Film> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.li_film, parent, false)
        return FilmViewHolder(view, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(items[position], position == 0)
    }

    fun changeData(newItems: List<Film>?) {
        items.clear()
        if (newItems != null) {
            items.addAll(newItems)
        }
        notifyDataSetChanged()
    }
}