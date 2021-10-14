package com.test.jokeapp

import android.app.Application
import com.test.jokeapp.di.dataModule
import com.test.jokeapp.di.interactorModule
import com.test.jokeapp.di.networkModule
import com.test.jokeapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JokesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinModules()
    }

    private fun initKoinModules(){
        startKoin{
            androidContext(applicationContext)
            modules(listOf(networkModule, dataModule, interactorModule, viewModelModule))
        }
    }
}