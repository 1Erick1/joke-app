package com.test.jokeapp.presentation.features.joke.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.test.jokeapp.R
import com.test.jokeapp.databinding.ActivityJokeBinding
import com.test.jokeapp.presentation.features.joke.adapter.FlagAdapter
import com.test.jokeapp.presentation.features.joke.viewModel.JokeViewModel
import org.koin.android.ext.android.inject

class JokeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityJokeBinding
    private val viewModel: JokeViewModel by inject()
    private val flagsAdapter = FlagAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvFlags.adapter = flagsAdapter
        setupViewModel()
        setupViewEvents()
        viewModel.getJoke()
    }

    private fun setupViewEvents() {
        with(binding){
            fabRefresh.setOnClickListener {
                viewModel.getJoke()
            }
        }
    }

    private fun setupViewModel(){
        viewModel.joke.observe(this, Observer {
            with(binding){
                flagsAdapter.setItems(it.flags)
                tvCategory.text = it.category
                tvJokeLine1.text = it.firstLine
                tvJokeLine2.text = it.secondLine
            }
        })

        viewModel.progress.observe(this, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, R.string.generic_error_msg,Toast.LENGTH_LONG).show()
        })
    }
}