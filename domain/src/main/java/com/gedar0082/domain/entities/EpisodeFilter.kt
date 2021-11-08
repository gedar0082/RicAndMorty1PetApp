package com.gedar0082.domain.entities

import java.util.*

data class EpisodeFilter(
    val name: String = "",
    val episode: String = "",
    val page: Int = 1
){
    fun getMap(): Map<String, String> {
        val map = TreeMap<String, String>()
        if(name.isNotEmpty()) map[name] = name
        if (episode.isNotEmpty()) map[episode] = episode
        return map
    }
}
