package com.test.jokeapp.di

import com.test.jokeapp.data.datasource.network.IJokesNetworkDataSource
import com.test.jokeapp.data.datasource.network.JokesNetworkDataSource
import com.test.jokeapp.data.repository.JokesRepository
import com.test.jokeapp.domain.repository.IJokesRepository
import org.koin.dsl.module

val dataModule = module {
    single<IJokesNetworkDataSource> { JokesNetworkDataSource(get()) }
    single<IJokesRepository> { JokesRepository(get()) }
}