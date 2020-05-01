package com.rickandmorty.models

data class UICharacter (
    val id      : Int,
    val name    : String,
    val status  : String,
    val species : String,
    val type    : String,
    val gender  : String,
    val origin  : UILocation,
    val location: UILocation,
    val image   : String,
    val episode : List<String>,
    val url     : String,
    val created : String
)