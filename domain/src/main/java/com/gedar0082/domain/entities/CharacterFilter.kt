package com.gedar0082.domain.entities

import java.util.*

data class CharacterFilter(
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val page: Int = 1
){
    fun getMap(): Map<String, String>{
        val map = TreeMap<String, String>()
        if (name.isNotEmpty()) map[name] = name
        if (status.isNotEmpty()) map[status] = status
        if (species.isNotEmpty()) map[species] = species
        map[type] = type
        if (gender.isNotEmpty()) map[gender] = gender
        return map
    }
}
