package com.rickandmorty.remote.services

import com.rickandmorty.remote.executors.JobExecutor
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

data class RemoteServiceConfig(
    val baseUrl: String,
    val debug: Boolean
)

abstract class RemoteService<T>
constructor(c: Class<T>, private val config: RemoteServiceConfig) {
    protected var service: T

    init {
        service = initApiService().create(c)
    }

    private fun initApiService(): Retrofit {
        val builder = OkHttpClient.Builder()
            .addInterceptor(getRequestInterceptor())

        return Retrofit.Builder().baseUrl(config.baseUrl)
            .callbackExecutor(JobExecutor())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(builder.build()).build()
    }

    private fun getRequestInterceptor(): Interceptor = Interceptor { chain ->
        chain.proceed(
            chain.request().newBuilder()
                .url(addBaseParameters(chain.request().url()))
                .build()
        )
    }

    private fun addBaseParameters(url: HttpUrl): HttpUrl {
        val builder = url.newBuilder()
        return builder.build()
    }
}