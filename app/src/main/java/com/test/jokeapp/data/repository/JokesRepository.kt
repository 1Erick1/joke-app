package com.test.jokeapp.data.repository

import com.test.jokeapp.data.datasource.network.IJokesNetworkDataSource
import com.test.jokeapp.domain.entity.Joke
import com.test.jokeapp.domain.repository.IJokesRepository


class JokesRepository(
    private val jokesNetworkDataSource: IJokesNetworkDataSource
): IJokesRepository {

    override suspend fun getRandomJoke(): Joke {
        return jokesNetworkDataSource.getRandomJoke().toDomainEntity()
    }

}