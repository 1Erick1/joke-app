package com.test.jokeapp.domain.interactor

import com.test.jokeapp.domain.entity.Joke
import com.test.jokeapp.domain.repository.IJokesRepository

class GetRandomJokeInteractor(
    private val jokesRepository: IJokesRepository
) {
    suspend fun execute(): Joke{
        return jokesRepository.getRandomJoke()
    }
}