package com.test.jokeapp.presentation.features.joke.model

import com.test.jokeapp.domain.entity.Joke
import com.test.jokeapp.domain.entity.TypeEnum

class JokeModel(
    val id: Int,
    val category: String,
    val firstLine: String,
    val secondLine: String,
    val flags: List<String>
)

fun Joke.toModel(): JokeModel{
    val line1 = if (type==TypeEnum.SINGLE) joke else setup
    val line2 = delivery
    return JokeModel(
        id = id,
        category = category,
        firstLine = line1,
        secondLine = line2,
        flags = flags.filter { it.checked }.map { it.flag.description }
    )
}