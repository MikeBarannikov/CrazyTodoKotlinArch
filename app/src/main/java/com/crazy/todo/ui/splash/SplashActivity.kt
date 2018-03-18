package com.crazy.todo.ui.splash

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.crazy.todo.R
import com.crazy.todo.ui.tasks.TasksActivity

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {
    private val mUiHandler = Handler()
    private val mOpenNextActivity = Runnable { openNextActivity() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_splash)
    }

    override fun onResume() {
        super.onResume()
        delayedOpenNextActivity()
    }

    override fun onPause() {
        mUiHandler.removeCallbacks(mOpenNextActivity)
        super.onPause()
    }

    private fun delayedOpenNextActivity() {
        mUiHandler.removeCallbacks(mOpenNextActivity)
        mUiHandler.postDelayed(mOpenNextActivity, OPEN_NEXT_ACTIVITY_DELAY.toLong())
    }

    private fun openNextActivity() {
        startActivity(TasksActivity.makeIntent(this))
    }

    companion object {
        private val OPEN_NEXT_ACTIVITY_DELAY = 1000
    }
}
