package com.crazy.todo.ui.tasks

import android.arch.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
    var a: Int? = null
    var b: (() -> Unit)? = null

    fun test() {
        myInline {
            a = 100
            return
        }
        myNoInline {
            a = 200
        }
        myCrossInline {
            a = 300
        }
    }

    inline fun myInline(block: () -> Unit) {
        block()
    }

    @Suppress("NOTHING_TO_INLINE")
    inline fun myNoInline(noinline block: () -> Unit) {
        val a = block
        a()
    }

    inline fun myCrossInline(crossinline block: () -> Unit) {
        block()
    }
}
