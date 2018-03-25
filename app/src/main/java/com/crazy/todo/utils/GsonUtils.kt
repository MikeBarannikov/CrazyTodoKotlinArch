package com.crazy.todo.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonUtils {
    private lateinit var sRequestGson: Gson

    fun requestGson(): Gson {
        if (!this::sRequestGson.isInitialized) {
            sRequestGson = GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'")
                    .create()
        }
        return sRequestGson
    }

}