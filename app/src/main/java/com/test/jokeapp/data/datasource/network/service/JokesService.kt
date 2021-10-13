package com.test.jokeapp.data.datasource.network.service

import com.test.jokeapp.data.datasource.network.reponse.JokeResponse
import retrofit2.http.GET

interface JokesService {

    @GET("joke/Any")
    suspend fun getRandomJoke(): JokeResponse
}