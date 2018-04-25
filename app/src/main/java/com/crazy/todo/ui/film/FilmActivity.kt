package com.crazy.todo.ui.film

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.crazy.todo.ui.base.activity.SingleFragmentActivity

class FilmActivity : SingleFragmentActivity() {

    override fun getFragment(): Fragment = FilmFragment.newInstance(intent.getStringExtra(FilmFragment.KEY_FILM_ID))

    companion object {
        fun makeIntent(context: Context, filmId: String) = Intent(context, FilmActivity::class.java).apply {
            putExtra(FilmFragment.KEY_FILM_ID, filmId)
        }
    }
}
