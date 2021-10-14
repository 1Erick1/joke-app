package com.test.jokeapp.presentation.features.joke.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.jokeapp.domain.interactor.GetRandomJokeInteractor
import com.test.jokeapp.presentation.features.joke.model.JokeModel
import com.test.jokeapp.presentation.features.joke.model.toModel
import kotlinx.coroutines.launch

class JokeViewModel(
    private val getRandomJokeInteractor: GetRandomJokeInteractor
): ViewModel(){

    val joke = MutableLiveData<JokeModel>()
    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()

    fun getJoke(){
        viewModelScope.launch {
            progress.postValue(true)
            try {
                joke.postValue(getRandomJokeInteractor.execute().toModel())
                progress.postValue(false)
            }catch (e: Exception){
                error.postValue(e.localizedMessage)
                progress.postValue(false)
            }
        }
    }
}