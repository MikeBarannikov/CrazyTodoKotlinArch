package com.crazy.todo.data.datasource.url

import com.crazy.todo.BuildConfig

class UrlDataSourceImpl : UrlDataSource {
    override fun provideFilmsUrl(): String {
       return BuildConfig.API_BASE_URL
    }
}