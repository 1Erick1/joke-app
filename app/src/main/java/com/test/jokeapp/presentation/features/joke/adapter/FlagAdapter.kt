package com.test.jokeapp.presentation.features.joke.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.jokeapp.databinding.ItemFlagBinding

class FlagAdapter: RecyclerView.Adapter<FlagAdapter.ViewHolder>() {
    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFlagBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItems(items: List<String>){
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemFlagBinding): RecyclerView.ViewHolder(binding.root){

        fun bindView(flagName: String){
            binding.tvFlagName.text = flagName
        }
    }


}