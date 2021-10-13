package com.test.jokeapp.data.datasource.network

import com.test.jokeapp.data.datasource.network.reponse.JokeResponse
import com.test.jokeapp.data.datasource.network.service.JokesService

class JokesNetworkDataSource(
    private val jokesService: JokesService
): IJokesNetworkDataSource {

    override suspend fun getRandomJoke(): JokeResponse {
        return jokesService.getRandomJoke()
    }

}