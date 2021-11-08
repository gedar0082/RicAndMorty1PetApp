package com.gedar0082.domain.entities

data class Location(
    val id: Int,
    val name: String,
    val type : String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)