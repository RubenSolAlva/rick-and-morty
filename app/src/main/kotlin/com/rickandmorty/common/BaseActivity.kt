package com.rickandmorty.common

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.rickandmorty.R
import androidx.lifecycle.Observer
import com.rickandmorty.extensions.getSnackbarInstance
import dagger.android.AndroidInjection
import io.reactivex.BackpressureStrategy
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.okButton
import javax.inject.Inject


abstract class BaseActivity: AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var netManager: NetworkManager
    lateinit var view: ViewGroup
    var progressLayout: FrameLayout? = null
    var snack: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

    /**
     * To track background progress.
     *
     * @param isRunning If api call is running -> true, else -> false
     */
    protected fun trackBackgroundProgress(isRunning: Boolean){
        if (isRunning){
            showLoading()
        }else {
            hideLoading()
        }
    }

    open fun showLoading() {
        progressLayout?.visibility = View.VISIBLE
    }

    open fun hideLoading() {
        progressLayout?.visibility = View.GONE
    }

    /**
     * To generate snackbar.
     *
     * @param activity to generate view on it
     */
    fun setNetworkListener(activity: Activity) {
        view =
            (activity.findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
        isNetworkAvailable()
        snack = view.getSnackbarInstance(
            getString(R.string.default_no_internet),
            Snackbar.LENGTH_INDEFINITE,
            null
        )
    }

    /**
     * Communication with NetworkManager Observable to know if network is available
     */
    @SuppressLint("CheckResult")
    fun isNetworkAvailable() {
        LiveDataReactiveStreams.fromPublisher(
            netManager.isNetworkAvailable()
                .map { it.available() }
                .toFlowable(BackpressureStrategy.BUFFER)
        ).observe(this, Observer {
            handleNetworkAvailability(it)
        })
    }

    /**
     * Show/hide snackbar.
     *
     * @param available to show/hide snackbar
     */
    open fun handleNetworkAvailability(available: Boolean) {
        snack!!.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        when {
            !available -> snack!!.show()
            else -> snack!!.dismiss()
        }
    }
}