package com.test.jokeapp.di

import com.test.jokeapp.presentation.features.joke.viewModel.JokeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { JokeViewModel(get()) }
}