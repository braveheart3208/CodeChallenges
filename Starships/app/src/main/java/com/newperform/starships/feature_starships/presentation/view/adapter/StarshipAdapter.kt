package com.newperform.starships.feature_starships.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newperform.starships.databinding.AdapterStarshipsBinding
import com.newperform.starships.feature_starships.domain.model.Starship

/**
 * Created by Alex Toan Duong on 13/09/2022.
 * This project belongs to Alex Toan Duong.
 * Do Not Copy in any circumstance
 * Please Contact braveheart3208@gmail.com
 * or minhtoanduongngo@outlook.com for more information
 */
class StarshipAdapter : RecyclerView.Adapter<StarshipAdapter.ViewHolder>() {

    private val starships = mutableListOf<Starship>()

    fun setStarships(starships : List<Starship>){
        this.starships.clear()
        this.starships.addAll(starships)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding : AdapterStarshipsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(starship: Starship){
            binding.starshipNameTextView.text = starship.name
            binding.starshipCapacityTextView.text = starship.cargoCapacity
            binding.starshipSpeedTextView.text = starship.maxSpeed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AdapterStarshipsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(starships[position])
    }

    override fun getItemCount(): Int {
        return starships.size
    }
}