package com.test.jokeapp.domain.entity

class Joke(
    val id: Int,
    val category: String,
    val type: TypeEnum,
    val joke: String,
    val setup: String,
    val delivery: String,
    val flags: List<JokeFlag>
)