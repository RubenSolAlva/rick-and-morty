package com.rickandmorty.data.models

data class CharacterEntity (
    val id      : Int,
    val name    : String,
    val status  : String,
    val species : String,
    val type    : String,
    val gender  : String,
    val origin  : LocationEntity,
    val location: LocationEntity,
    val image   : String,
    val episode : List<String>,
    val url     : String,
    val created : String
)