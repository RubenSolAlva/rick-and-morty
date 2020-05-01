package com.rickandmorty.remote.models

data class NWInfo (
    val count: Int,
    val pages: Int,
    val next : String,
    val prev : String
)