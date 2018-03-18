package com.crazy.todo.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.crazy.todo.R

object FragmentUtils {

    @JvmOverloads
    fun replaceFragment(fm: FragmentManager, fragment: Fragment, addToBackStack: Boolean = false,
                        enter: Int = 0, exit: Int = 0, popEnter: Int = 0, popExit: Int = 0) {
        val tr = fm.beginTransaction()
        if (enter != 0 && exit != 0) {
            if (popEnter != 0 && popExit != 0) {
                tr.setCustomAnimations(enter, exit, popEnter, popExit)
            } else {
                tr.setCustomAnimations(enter, exit)
            }
        }
        val className = fragment.javaClass.name
        tr.replace(R.id.fl_container, fragment, className)
        if (addToBackStack) {
            tr.addToBackStack(className)
        }
        tr.commit()
    }

    @JvmOverloads
    fun addFragment(fm: FragmentManager, fragment: Fragment, addToBackStack: Boolean = false) {
        val tr = fm.beginTransaction()
        val className = fragment.javaClass.name
        tr.add(R.id.fl_container, fragment, className)
        if (addToBackStack) {
            tr.addToBackStack(className)
        }
        tr.commit()

    }

    fun addFragment(fm: FragmentManager, fragment: Fragment, addToBackStack: Boolean,
                    enter: Int, exit: Int, popEnter: Int, popExit: Int) {
        val tr = fm.beginTransaction()
        tr.setCustomAnimations(enter, exit, popEnter, popExit)
        val className = fragment.javaClass.name
        tr.add(R.id.fl_container, fragment, className)
        if (addToBackStack) {
            tr.addToBackStack(className)
        }
        tr.commit()
    }
}
