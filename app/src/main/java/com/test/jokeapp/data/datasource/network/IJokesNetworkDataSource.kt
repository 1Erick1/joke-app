package com.test.jokeapp.data.datasource.network

import com.test.jokeapp.data.datasource.network.reponse.JokeResponse

interface IJokesNetworkDataSource {
    suspend fun getRandomJoke(): JokeResponse
}