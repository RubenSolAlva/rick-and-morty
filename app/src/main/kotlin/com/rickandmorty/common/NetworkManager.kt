package com.rickandmorty.common

import android.annotation.SuppressLint
import android.content.Context
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkManager  @Inject constructor(private val context: Context) {

    /**
     * NetworkManager Observable to know if network is available
     */
    @SuppressLint("CheckResult")
    fun isNetworkAvailable(): Observable<Connectivity> {
        return ReactiveNetwork
            .observeNetworkConnectivity(context)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}