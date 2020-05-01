package com.rickandmorty.remote.models

data class NWCharactersResponse(
   val info   : NWInfo,
   val results: List<NWCharacter>
)

