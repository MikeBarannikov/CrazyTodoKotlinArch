package com.crazy.todo

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.StrictMode
import android.support.multidex.MultiDexApplication
import com.crazy.todo.data.datasource.url.UrlDataSourceImpl
import com.crazy.todo.data.di.*

class AppDelegate : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults()
            StrictMode.setVmPolicy(
                    StrictMode.VmPolicy.Builder(StrictMode.getVmPolicy())
                            .penaltyLog().build()
            )
        }

        appContext = applicationContext

        letDiBegin()
    }

    private fun letDiBegin() {
        val okHttpProvider = OkHttpProvider()
        val urlDataSource = UrlDataSourceImpl()
        val retrofitProvider = RetrofitProvider(okHttpProvider.provideClient(), urlDataSource)
        val dataSourceProvider = DataSourceProvider(retrofitProvider.provideRetrofit())
        val repositoryProvider = RepositoryProvider(dataSourceProvider.provideFilmsDataSource())
        viewModelFactory = ViewModelFactory(repositoryProvider.provideRepository())
    }

    companion object {
        var appContext: Context? = null
            private set
        lateinit var viewModelFactory: ViewModelProvider.Factory
            private set
    }
}
