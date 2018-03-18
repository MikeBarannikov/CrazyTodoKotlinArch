package com.crazy.todo.ui.base.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import com.crazy.todo.R
import com.crazy.todo.utils.FragmentUtils

abstract class SingleFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            FragmentUtils.replaceFragment(supportFragmentManager, getFragment())
        }
    }

    @LayoutRes
    protected open fun getLayout(): Int {
        return R.layout.ac_single_frame
    }

    abstract fun getFragment(): Fragment
}
