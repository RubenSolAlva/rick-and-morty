package com.rickandmorty.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.rickandmorty.R
import com.rickandmorty.common.BaseActivity


class SplashActivity : BaseActivity() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000 //2 seconds

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(applicationContext, OnboardingActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

}