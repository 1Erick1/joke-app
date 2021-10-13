package com.test.jokeapp.data.datasource.network.reponse

import com.test.jokeapp.domain.entity.FlagEnum
import com.test.jokeapp.domain.entity.Joke
import com.test.jokeapp.domain.entity.JokeFlag
import com.test.jokeapp.domain.entity.TypeEnum

class JokeResponse(
    val id: Int,
    val category: String,
    val type: String,
    val joke: String?,
    val setup: String?,
    val delivery: String?,
    val flags: FlagsResponse,
    val safe: Boolean,
    val lang: String
){
    fun toDomainEntity(): Joke{
        return Joke(
            id = id,
            category = category,
            type = TypeEnum.values().find { it.value == type } ?: TypeEnum.SINGLE,
            joke = joke?:"",
            setup = setup?:"",
            delivery = delivery?:"",
            flags = listOf(
                JokeFlag(FlagEnum.NSFW,flags.nsfw),
                JokeFlag(FlagEnum.EXPLICIT,flags.explicit),
                JokeFlag(FlagEnum.POLITICAL,flags.political),
                JokeFlag(FlagEnum.RACIST,flags.racist),
                JokeFlag(FlagEnum.SEXIST,flags.sexist),
                JokeFlag(FlagEnum.RELIGIOUS,flags.religiuos)
            )
        )
    }
}