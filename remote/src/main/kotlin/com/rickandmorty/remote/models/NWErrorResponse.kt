package com.rickandmorty.remote.models

import kotlinx.serialization.SerialName

data class NWErrorResponse(
    @SerialName("ErrorCode")
    var code: String = "",
    @SerialName("FieldName")
    var fieldName: String = "",
    @SerialName("Message")
    override var message: String = ""
): Throwable()