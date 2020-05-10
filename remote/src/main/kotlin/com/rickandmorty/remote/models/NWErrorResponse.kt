package com.rickandmorty.remote.models

import kotlinx.serialization.Optional

data class NWErrorResponse(
    @Optional
    var code: Int = 0,
    @Optional
    override var message: String = "Opps! Something wrong"
) : Throwable()