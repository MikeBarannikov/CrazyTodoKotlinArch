package com.crazy.todo.ui.tasks

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.crazy.todo.utils.POOL
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.*

class TaskViewModel : ViewModel() {
    private val uiHandler = Handler(Looper.getMainLooper())
    private val rand = Random(13)
    private val number = MutableLiveData<Int>()
    val num: LiveData<Int> = number

    fun test() {
        launch(UI + CoroutineExceptionHandler({_, t -> log("exception: " + t.message)})) {
            val defer = async(POOL) {
                throw Exception("MyMessage")
            }
            defer.await()
        }
    }

    fun testBlocking() = runBlocking {
        log("third")
        post { log("ui work") }
        val defer = async(POOL) {
            log("forth")
            Thread.sleep(2000)
            log("fifth")
            rand.nextInt(100)
        }
        log("second")
        number.postValue(defer.await())
        log("sixth")
    }

    fun testLaunch() {
        log("first")
        launch(UI) {
            log("third")
            post { log("ui work") }
            val defer = async(POOL) {
                log("forth")
                Thread.sleep(2000)
                log("fifth")
                rand.nextInt(100)
            }
            log("second")
            number.postValue(defer.await())
            log("sixth")
        }
        log("seventh")
    }

    fun testAsync() {
        log("first")
        async(UI) {
            log("third")
            post { log("ui work") }
            val defer = async(POOL) {
                log("forth")
                Thread.sleep(2000)
                log("fifth")
                rand.nextInt(100)
            }
            log("second")
            number.postValue(defer.await())
            log("sixth")
        }
        log("seventh")
    }

    private fun post(block: () -> Unit) {
        uiHandler.post {
            log("ui work start")
            block()
            log("ui work end")
        }
    }

    private fun log(msg: String) {
        Log.d("MYDEBUG", msg + " ${Thread.currentThread().name}")
    }
}
