package com.crazy.todo.ui.tasks

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.crazy.todo.ui.base.activity.SingleFragmentActivity

class TasksActivity : SingleFragmentActivity() {

    override fun getFragment(): Fragment {
        return TasksFragment.newInstance()
    }

    companion object {
        fun makeIntent(context: Context): Intent {
            val intent = Intent(context, TasksActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            return intent
        }
    }
}
