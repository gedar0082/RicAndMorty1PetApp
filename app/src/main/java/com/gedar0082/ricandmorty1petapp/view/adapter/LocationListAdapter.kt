package com.gedar0082.ricandmorty1petapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gedar0082.domain.entities.Location
import com.gedar0082.ricandmorty1petapp.databinding.CardLocationBinding

class LocationListAdapter (private val locations: List<Location>,
                           private val locationClickListener: (Location) -> Unit
) : RecyclerView.Adapter<LocationListAdapter.LocationViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardLocationBinding.inflate(
            layoutInflater,
            parent,
            false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location, locationClickListener)
    }

    override fun getItemCount() = locations.size

    inner class LocationViewHolder(private val binding: CardLocationBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(location: Location, locationClickListener: (Location) -> Unit){
            binding.locationCard.setOnClickListener { locationClickListener(location) }
            binding.locationCardName.text = location.name
        }
    }
}