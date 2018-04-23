package com.crazy.todo.ui.films

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.crazy.todo.ui.base.activity.SingleFragmentActivity

class FilmsActivity : SingleFragmentActivity() {

    override fun getFragment(): Fragment = FilmsFragment.newInstance()

    companion object {
        fun makeIntent(context: Context): Intent = Intent(context, FilmsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }
}
