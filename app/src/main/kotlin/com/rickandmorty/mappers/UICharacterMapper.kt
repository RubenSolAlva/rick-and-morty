package com.rickandmorty.mappers

import com.rickandmorty.data.models.CharacterEntity
import com.rickandmorty.data.models.LocationEntity
import com.rickandmorty.models.UICharacter
import com.rickandmorty.models.UILocation

fun List<CharacterEntity>.asUIEntity(): List<UICharacter> =
    map { it.asUIEntity() }

fun CharacterEntity.asUIEntity(): UICharacter {
    return UICharacter(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.asUIEntity(),
        location.asUIEntity(),
        image,
        episode,
        url,
        created
    )
}

fun LocationEntity.asUIEntity(): UILocation {
    return UILocation(
        name,
        url
    )
}
