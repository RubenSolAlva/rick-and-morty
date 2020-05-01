package com.rickandmorty.remote.mappers

import com.rickandmorty.data.models.CharacterEntity
import com.rickandmorty.data.models.LocationEntity
import com.rickandmorty.remote.models.NWCharacter
import com.rickandmorty.remote.models.NWLocation
import io.reactivex.Single

fun Single<NWCharacter>.asDataEntity(): Single<CharacterEntity> {
    return this.map { it.asDataEntity() }
}
fun List<NWCharacter>.asDataEntity(): List<CharacterEntity> =
    map { it.asDataEntity() }

fun NWCharacter.asDataEntity(): CharacterEntity {
    return CharacterEntity(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.asDataEntity(),
        location.asDataEntity(),
        image,
        episode,
        url,
        created
    )
}

fun NWLocation.asDataEntity(): LocationEntity {
    return LocationEntity(
        name,
        url
    )
}
