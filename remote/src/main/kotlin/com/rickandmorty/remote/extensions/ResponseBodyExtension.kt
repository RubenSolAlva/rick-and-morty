package com.rickandmorty.remote.extensions

import com.google.gson.Gson
import com.rickandmorty.remote.models.NWErrorResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.HttpException

fun <T> ResponseBody.parseSuccessResponse(serializer: Class<T>): T {
    val jsonString = string()
    try {
        return Gson().fromJson<T>(jsonString, serializer)
    } catch (e: Exception) {
        throw parseErrorResponse(jsonString)
    }
}

inline fun <reified T> ResponseBody.parseJSONResponse(): T =
        parseSuccessResponse(T::class.java)

@Throws
private fun parseErrorResponse(jsonString: String): NWErrorResponse {
    return Gson().fromJson(jsonString, NWErrorResponse::class.java)
}

fun <T> Single<T>.parseError(): Single<T> =
        onErrorResumeNext { error ->
            Single.error(error
                    .let { it as? HttpException }
                    ?.let { NWErrorResponse(it.code(), it.message()) }
                    ?: error)
        }

fun Completable.parseError(): Completable =
        onErrorResumeNext { error ->
            Completable.error(error
                    .let { it as? HttpException }
                    ?.let { NWErrorResponse(it.code(), it.message()) }
                    ?: error)
        }