package com.test.jokeapp.domain.entity

enum class FlagEnum(val description: String) {
    NSFW("nsfw"),
    RELIGIOUS("religious"),
    POLITICAL("political"),
    RACIST("racist"),
    SEXIST("sexist"),
    EXPLICIT("explicit")
}