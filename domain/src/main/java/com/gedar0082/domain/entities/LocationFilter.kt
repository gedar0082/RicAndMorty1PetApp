package com.gedar0082.domain.entities

import java.util.*

data class LocationFilter(
    val name: String = "",
    val type: String = "",
    val dimension: String = "",
    val page: Int = 1
){
    fun getMap(): Map<String, String>{
        val map = TreeMap<String, String>()
        if (name.isNotEmpty()) map[name] = name
        map[type] = type
        if (dimension.isNotEmpty()) map[dimension] = dimension
        return map
    }
}