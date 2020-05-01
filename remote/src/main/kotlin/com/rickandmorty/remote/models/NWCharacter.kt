package com.rickandmorty.remote.models

data class NWCharacter (
   val id      : Int,
   val name    : String,
   val status  : String,
   val species : String,
   val type    : String,
   val gender  : String,
   val origin  : NWLocation,
   val location: NWLocation,
   val image   : String,
   val episode : List<String>,
   val url     : String,
   val created : String
)