package com.test.jokeapp.domain.repository

import com.test.jokeapp.domain.entity.Joke

interface IJokesRepository {
    suspend fun getRandomJoke(): Joke
}