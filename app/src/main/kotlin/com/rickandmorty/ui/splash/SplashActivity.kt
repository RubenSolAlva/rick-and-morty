package com.rickandmorty.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.rickandmorty.R
import com.rickandmorty.common.BaseActivity
import com.rickandmorty.ui.MainActivity

class SplashActivity : BaseActivity() {
    private var mDelayHandler: Handler? = null

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, resources.getInteger(R.integer.SPLASH_DELAY).toLong())
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }
}