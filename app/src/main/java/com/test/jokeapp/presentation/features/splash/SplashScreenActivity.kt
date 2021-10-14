package com.test.jokeapp.presentation.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.jokeapp.presentation.features.joke.activity.JokeActivity

class SplashScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,JokeActivity::class.java))
        finish()
    }
}