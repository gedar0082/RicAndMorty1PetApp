package com.gedar0082.ricandmorty1petapp.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gedar0082.domain.entities.Character
import com.gedar0082.ricandmorty1petapp.databinding.CardCharacterBinding
import com.squareup.picasso.Picasso

class CharacterListAdapter(
    private val characters: List<Character>,
    private val characterClickListener: (Character) -> Unit
) : RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardCharacterBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, characterClickListener)
    }

    override fun getItemCount() = characters.size

    inner class CharacterViewHolder(private val binding: CardCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character, characterClickListener: (Character) -> Unit) {
            binding.characterCardName.text = character.name
            binding.characterCard.setOnClickListener { characterClickListener(character) }
            Picasso
                .get()
                .load(character.image)
                .resize(500, 500)
                .into(binding.characterCardImage)
        }
    }
}