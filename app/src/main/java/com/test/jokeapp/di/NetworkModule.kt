package com.test.jokeapp.di

import com.readystatesoftware.chuck.ChuckInterceptor
import com.test.jokeapp.BuildConfig
import com.test.jokeapp.data.datasource.network.service.JokesService
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    //HttpClient
    single {
        OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(androidContext()))
        .build()
    }

    //Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    //Jokes Service
    single {
        get<Retrofit>().create(JokesService::class.java)
    }
}