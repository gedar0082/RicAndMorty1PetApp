package com.gedar0082.ricandmorty1petapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gedar0082.domain.entities.Episode
import com.gedar0082.ricandmorty1petapp.databinding.CardEpisodeBinding

class EpisodeListAdapter(private val episodes: List<Episode>,
                          private val episodeClickListener: (Episode) -> Unit
) : RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardEpisodeBinding.inflate(
            layoutInflater,
            parent,
            false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode, episodeClickListener)
    }

    override fun getItemCount() = episodes.size

    inner class EpisodeViewHolder(private val binding: CardEpisodeBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: Episode, episodeClickListener: (Episode) -> Unit){
            binding.episodeCardName.text = episode.name
            binding.episodeCard.setOnClickListener { episodeClickListener(episode) }
        }
    }
}