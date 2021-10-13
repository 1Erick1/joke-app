package com.test.jokeapp.di

import com.test.jokeapp.domain.interactor.GetRandomJokeInteractor
import org.koin.dsl.module

val interactorModule = module {
    single { GetRandomJokeInteractor(get()) }
}